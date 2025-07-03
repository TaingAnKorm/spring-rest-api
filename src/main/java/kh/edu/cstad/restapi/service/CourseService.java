package kh.edu.cstad.restapi.service;

import kh.edu.cstad.restapi.domain.Course;
import kh.edu.cstad.restapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {

    /**
     * ទាញព័ត៍មានវគ្គសិក្សាទាំងអស់
     * @author TaingAn
     * @return List<CourseResponse>
     */
    List<CourseResponse> getCourses(Boolean status);

    List<CourseResponse> getCourses(Boolean status, String title);

    CourseResponse getCourseByCode(String code);

    CourseResponse getCourseById(String id);
}
