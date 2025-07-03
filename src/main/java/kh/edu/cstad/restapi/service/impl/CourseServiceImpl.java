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
        List<Course> filteredCourse = courseRepository.getCourses().stream()
                .filter(course -> course.getStatus().equals(status))
                .toList();

        // Map data from domain model to DTO
        List<CourseResponse> courseResponsesList = filteredCourse
                .stream()
                .map(course -> CourseResponse.builder()
                        .id(course.getId())
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();

        return courseResponsesList;
    }

    @Override
    public List<CourseResponse> getCourses(Boolean status, String title) {

        List<Course> filteredCourse = courseRepository.getCourses().stream()
                .filter(course -> course.getStatus().equals(status))
                .toList();

        if (title != null) {
            filteredCourse = filteredCourse.stream()
                    .filter(course -> course.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .toList();
        }

        List<CourseResponse> courseResponsesList = filteredCourse
                .stream()
                .map(course -> CourseResponse.builder()
                        .id(course.getId())
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();

        return courseResponsesList;
    }

    @Override
    public CourseResponse getCourseByCode(String code) {

        Course foundCourse = courseRepository.getCourses().stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);

        if (foundCourse == null) {
            return null;
        }

        return CourseResponse.builder()
                .id(foundCourse.getId())
                .code(foundCourse.getCode())
                .title(foundCourse.getTitle())
                .price(foundCourse.getPrice())
                .status(foundCourse.getStatus())
                .build();
    }

    @Override
    public CourseResponse getCourseById(String id) {

        Course foundCourse = courseRepository.getCourses().stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (foundCourse == null) {
            return null;
        }

        return CourseResponse.builder()
                .id(foundCourse.getId())
                .code(foundCourse.getCode())
                .title(foundCourse.getTitle())
                .price(foundCourse.getPrice())
                .status(foundCourse.getStatus())
                .build();
    }
}
