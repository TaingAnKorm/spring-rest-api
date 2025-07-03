package kh.edu.cstad.restapi.controller;


import kh.edu.cstad.restapi.dto.CourseResponse;
import kh.edu.cstad.restapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller + @ResponseBody
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    // Required dependency
    private final CourseService courseService;

    //ទាញព័ត៍មានវគ្គសិក្សាទាំងអស់
    @GetMapping
    public List<CourseResponse> getCourses(@RequestParam(required = false, defaultValue = "true") Boolean status,
                                           @RequestParam(required = false) String title) {
        return courseService.getCourses(status, title);
    }

    @GetMapping("/code/{code}")
    public CourseResponse getCourseByCode(@PathVariable String code){
        return courseService.getCourseByCode(code);
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable String id){
        return courseService.getCourseById(id);
    }
}