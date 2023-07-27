package com.green.webclient.timetable.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TimetableParam {
    private String sdSchulCode;
    private String ay;
    private String sem;
    private String dghtCrseScNm;
    private String allTiYmd;
    private String grade;
    private String classNm;
}
