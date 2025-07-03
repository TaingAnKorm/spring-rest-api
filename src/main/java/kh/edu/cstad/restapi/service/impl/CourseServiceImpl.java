package kh.edu.cstad.restapi.service.impl;

import kh.edu.cstad.restapi.domain.Course;
import kh.edu.cstad.restapi.dto.CourseResponse;
import kh.edu.cstad.restapi.repository.CourseRepository;
import kh.edu.cstad.restapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getCourses(Boolean status) {

        // Filter
        List<Course> filteredCourse = courseRepository.getCourses()
                .stream()
                .filter(course -> course.getStatus().equals(status))
                .toList();

        // Map data from domain model to DTO
        List<CourseResponse> courseResponsesList = filteredCourse
                .stream()
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();

        return courseResponsesList;
    }
}
