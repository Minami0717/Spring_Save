package com.green.webclient.timetable.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@ToString
public class TimetableInfoVo {
    private String period;
    private String subject;

    @JsonProperty("period")
    public String getPeriod() {
        return period;
    }

    @JsonProperty("PERIO")
    public void setPeriod(String period) {
        this.period = period;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("ITRT_CNTNT")
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
