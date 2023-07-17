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
        YearMonth today = YearMonth.now();
        log.info("today: {}", YearMonth.now());

        LocalDate thisMonStart = today.atDay(1);
        LocalDate thisMonEnd = today.atEndOfMonth();

        log.info("thisMonStart: {}", thisMonStart);
        log.info("thisMonEnd: {}", thisMonEnd);

        DayOfWeek d1 = thisMonStart.getDayOfWeek();
        DayOfWeek d2 = thisMonEnd.getDayOfWeek();

        log.info(String.valueOf(thisMonStart.minusDays(d1.getValue())));
        log.info(String.valueOf(thisMonEnd.plusDays(6 - d2.getValue())));
    }
}
