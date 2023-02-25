package com.techmaster.testSpringRESTAPI.controller;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;
import com.techmaster.testSpringRESTAPI.dto.UserDTO;
import com.techmaster.testSpringRESTAPI.model.Course;
import com.techmaster.testSpringRESTAPI.model.User;
import com.techmaster.testSpringRESTAPI.repository.UserRepository;
import com.techmaster.testSpringRESTAPI.service.CourseServiceImpl;
import com.techmaster.testSpringRESTAPI.service.UserService;
import com.techmaster.testSpringRESTAPI.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/courses")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CourseServiceImpl courseService;
    @GetMapping
    public List<UserDTO> getAllUsers(
       @RequestParam(required = false) int pageNumber,
       @RequestParam(required = false) int pageSize
    ){
        return userService.findAll(pageNumber,pageSize);
    }
    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable int id){
        return courseService.findCourseById(id);
    }
    @PostMapping
    public CourseDTO postCourse(@RequestBody CourseDTO courseDTO){
        return courseService.save(courseDTO);
    }
    @PutMapping
    public CourseDTO putCourseById(@RequestBody CourseDTO courseDTO){
        return courseService.put(courseDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.delete(id);
    }

}
