package com.example.boardpractice.cmt;

import com.example.boardpractice.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insCmt(CmtEntity entity) {
        try {
            int result = mapper.insCmt(entity);
            if (result == 1) {
                return entity.getIboardCmt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updCmt(CmtEntity entity) {
        return mapper.updCmt(entity);
    }

    public int delCmt(CmtDelDto dto) {
        return mapper.delCmt(dto);
    }

    public CmtRes selCmt(CmtSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        List<CmtVo> list = mapper.selCmt(dto);

        int cnt = mapper.selCmtCount(dto.getIboard());
        int maxPage = (int) Math.ceil((double) cnt / dto.getRow());
        int isMore = dto.getPage() < maxPage ? 1 : 0;

//        if (dto.getPage() >= lastPage) {
//            isMore = 0;
//        }

        return CmtRes.builder()
                .list(list)
                .isMore(isMore)
                .maxPage(maxPage)
                .row(dto.getRow())
                .build();
    }
}
