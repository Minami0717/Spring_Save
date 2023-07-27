package com.green.growgreen;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

@Slf4j
public class Exam {
    @Test
    public void test() {
        String[] repeatWeekArr = {"0","1","2","3","4","5","6"};
        for (String s : repeatWeekArr) {
            int dayOfWeek = Integer.parseInt(s) == 6 ? 0 : Integer.parseInt(s) + 1;
            log.info(String.valueOf(dayOfWeek));
        }
    }
}
