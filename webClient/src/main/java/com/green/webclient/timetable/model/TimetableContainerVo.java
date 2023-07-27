package com.green.webclient.timetable.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
public class TimetableContainerVo {
    private String date;
    private String semester;
    private String schoolNm;
    private List<TimetableInfoVo> infoList;
}
