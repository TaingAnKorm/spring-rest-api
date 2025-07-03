package kh.edu.cstad.restapi.service;

import kh.edu.cstad.restapi.dto.CourseResponse;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<CourseResponse> getCourses(Boolean status);

    /**
     * ទាញព័ត៍មានវគ្គសិក្សាទាំងអស់
     * @author TaingAn
     * @return List<CourseResponse>
     */
    List<CourseResponse> getCourses(Boolean status, String title);

    CourseResponse getCourseByCode(String code);

    CourseResponse getCourseById(String id);
}