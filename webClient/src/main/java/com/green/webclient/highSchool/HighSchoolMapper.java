package com.green.webclient.highSchool;

import com.green.webclient.highSchool.model.SchoolDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HighSchoolMapper {
    int insSchool(List<SchoolDto> list);
}
