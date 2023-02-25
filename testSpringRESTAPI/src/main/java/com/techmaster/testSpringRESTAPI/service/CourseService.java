package com.techmaster.testSpringRESTAPI.service;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;
import com.techmaster.testSpringRESTAPI.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAllCourses(String type, String name, String[] topics);
    CourseDTO findCourseById(int id);
}
