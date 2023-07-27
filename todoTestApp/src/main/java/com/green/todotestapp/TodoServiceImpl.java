package com.green.todotestapp;

import com.green.todotestapp.model.*;
import com.green.todotestapp.utils.MyFileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {
    private final TodoMapper mapper;
    private final String FILE_DIR;

    @Autowired
    public TodoServiceImpl(TodoMapper mapper, @Value("${file.dir}") String fileDir) {
        this.mapper = mapper;
        this.FILE_DIR = MyFileUtils.getAbsolutePath(fileDir);
    }

    @Override
    public TodoRes insTodo(TodoInsParam p) {
        File tempDic = new File(FILE_DIR, "/temp");
        if (!tempDic.exists()) {
            tempDic.mkdirs();
        }

        //저장용 파일명
        String savedFileNm = MyFileUtils.makeRandomFileNm(p.getPic().getOriginalFilename());
        File tempFile = new File(tempDic.getPath(), savedFileNm);

        try {
            p.getPic().transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TodoInsDto dto = new TodoInsDto();
        dto.setCtnt(p.getCtnt());
        dto.setPic(savedFileNm);

        int result = mapper.insTodo(dto);
        if (result == 1) {
            String targetDicPath = FILE_DIR + "/todo/" + dto.getItodo();
            File targetDic = new File(targetDicPath);
            if (!targetDic.exists()) { targetDic.mkdirs(); }
            File targetFile = new File(targetDicPath, savedFileNm);
            tempFile.renameTo(targetFile);
            return new TodoRes(dto);
        }
        return null;
    }

    @Override
    public List<TodoVo> selTodo() {
        return mapper.selTodo();
    }

    @Override
    public int updTodo(TodoUpdDto dto) {
        return 0;
    }
}
