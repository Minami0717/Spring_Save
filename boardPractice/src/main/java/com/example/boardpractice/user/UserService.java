package com.example.boardpractice.user;

import com.example.boardpractice.board.BoardService;
import com.example.boardpractice.board.model.BoardDelDto;
import com.example.boardpractice.cmt.CmtService;
import com.example.boardpractice.cmt.model.CmtDelDto;
import com.example.boardpractice.user.model.*;
import com.example.boardpractice.utils.CommonUtils;
import com.example.boardpractice.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils utils;
    private final BoardService boardService;
    private final CmtService cmtService;

    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils utils, BoardService boardService, CmtService cmtService) {
        this.mapper = mapper;
        this.utils = utils;
        this.boardService = boardService;
        this.cmtService = cmtService;
    }

    public int insUser(UserInsDto dto) {
        //성별 항상 대문자 변경
//        char gender = Character.toUpperCase(dto.getGender());
//        if (!(gender == 'M' || gender == 'F')) {
//            return -1;
//        }
//        dto.setGender(gender);

        //비밀번호 암호화
//        String upw = dto.getUpw();
//        String changeUpw = commonUtils.encodeSha256(upw);
//        dto.setUpw(changeUpw);

        dto.setUpw(utils.encodeSha256(dto.getUpw()));
        try {
            return mapper.insUser(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int login(UserLoginDto dto) {
        UserVo user = mapper.selUserByUid(dto);
        if (user == null) {
            return 2;
        }

        String upw = utils.encodeSha256(dto.getUpw());
        if (user.getUpw().equals(upw)) {
            return 1;
        }
        return 3;
    }

    public int updUserPw(UserUpdPwDto dto) {
        dto.setUpw(utils.encodeSha256(dto.getUpw()));
        return mapper.updUserPw(dto);
    }

    public int delUser(UserDelDto dto) throws Exception {
        dto.setUpw(utils.encodeSha256(dto.getUpw()));
        if (mapper.checkIuser(dto) == null) {
            return 0;
        }

        BoardDelDto boardDto = new BoardDelDto();
        boardDto.setIuser(dto.getIuser());

        List<Integer> iboardList = boardService.selIboardByIuser(dto.getIuser());
        for (int iboard : iboardList) {
            boardDto.setIboard(iboard);
            boardService.delBoard(boardDto);
        }

        CmtDelDto cmtDto = new CmtDelDto();
        cmtDto.setIuser(dto.getIuser());
        cmtService.delCmt(cmtDto);

        return mapper.delUser(dto);
    }

    public int updUserPic(MultipartFile pic, UserUpdPicDto dto) {
        String centerPath = String.format("user/%d", dto.getIuser());
        String dicPath = String.format("%s/%s", fileDir, centerPath);

        File dic = new File(dicPath);
        if (!dic.exists()) {
            dic.mkdirs();
        }

        String originFileName = pic.getOriginalFilename();
        String savedFileName = FileUtils.makeRandomFileNm(originFileName);
        String savedFilePath = String.format("%s/%s", centerPath, savedFileName);
        String targetPath = String.format("%s/%s", fileDir, savedFilePath);

        File file = new File(targetPath);

        try {
            pic.transferTo(file);
        } catch (IOException e) {
            return 0;
        }

        dto.setMainPic(savedFilePath);
        try {
            int result = mapper.updUserPic(dto);
            if (result == 0) {
                throw new Exception("사진 등록 실패");
            }
        } catch (Exception e) {
            file.delete();
            return 0;
        }
        return 1;
    }
}
