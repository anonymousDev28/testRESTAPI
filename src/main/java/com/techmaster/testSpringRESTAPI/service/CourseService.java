package com.techmaster.testSpringRESTAPI.service;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAllCourses(String type, String name, String[] topics);
    CourseDTO findCourseById(int id);

    CourseDTO save(CourseDTO courseDTO);

    CourseDTO put(CourseDTO courseDTO);

    void delete(int id);
}
