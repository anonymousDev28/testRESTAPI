package com.techmaster.testSpringRESTAPI.controller;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;
import com.techmaster.testSpringRESTAPI.model.Course;
import com.techmaster.testSpringRESTAPI.service.CourseServiceImpl;
import com.techmaster.testSpringRESTAPI.service.UserService;
import com.techmaster.testSpringRESTAPI.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;
    @GetMapping
    public List<CourseDTO> getAllCourse(
             @RequestParam(required = false) String type,
             @RequestParam(required = false) String[] topics,
             @RequestParam(required = false) String name
    ){
        return  courseService.findAllCourses(type,name,topics);
    }
    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable int id){
        return courseService.findCourseById(id);
    }
}
