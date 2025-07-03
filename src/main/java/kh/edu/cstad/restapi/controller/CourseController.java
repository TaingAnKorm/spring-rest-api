package kh.edu.cstad.restapi.controller;


import kh.edu.cstad.restapi.domain.Course;
import kh.edu.cstad.restapi.dto.CourseResponse;
import kh.edu.cstad.restapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
//@Controller +@ResponseBody
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    // Required dependency
    private final CourseService courseService;

    //ទាញព័ត៍មានវគ្គសិក្សាទាំងអស់
    @GetMapping
    public List<CourseResponse> getCourses(@RequestParam(required = false, defaultValue = "true") Boolean status) {
        return courseService.getCourses(status);
    }
}
