package com.green.webclient.timetable;

import com.green.webclient.timetable.model.TimetableContainerVo;
import com.green.webclient.timetable.model.TimetableParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetable")
@Slf4j
@RequiredArgsConstructor
public class TimeTableController {
    private final TimeTableService service;

    @GetMapping
    public TimetableContainerVo getTimetable(TimetableParam p) {
        log.info("p : {}", p);
        return service.getTimetable(p);
    }
}
