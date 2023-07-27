package com.green.webclient.highSchool;

import com.green.webclient.highSchool.model.SchoolDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/high-school")
@RequiredArgsConstructor
public class HighSchoolController {
    private final HighSchoolService service;

    @GetMapping
    public List<SchoolDto> getSchoolNm() {
        return service.getSchoolNm();
    }
}
