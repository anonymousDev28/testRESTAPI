package com.techmaster.testSpringRESTAPI.controller;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;
import com.techmaster.testSpringRESTAPI.model.Course;
import com.techmaster.testSpringRESTAPI.service.CourseServiceImpl;
import com.techmaster.testSpringRESTAPI.service.UserService;
import com.techmaster.testSpringRESTAPI.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourse(
             @RequestParam(required = false) String type,
             @RequestParam(required = false) String[] topics,
             @RequestParam(required = false) String name
    ){
        List<CourseDTO> courseDTOS = courseService.findAllCourses(type,name,topics);
        return (courseDTOS.isEmpty())?ResponseEntity.noContent().build():ResponseEntity.ok(courseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id){
        CourseDTO courseDTO = courseService.findCourseById(id);
        return (courseDTO != null)?
                ResponseEntity.ok(courseDTO):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course is't exist");
    }
}
