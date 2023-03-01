package com.techmaster.testSpringRESTAPI.controller;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;
import com.techmaster.testSpringRESTAPI.dto.PageDTO;
import com.techmaster.testSpringRESTAPI.dto.UserDTO;
import com.techmaster.testSpringRESTAPI.model.Course;
import com.techmaster.testSpringRESTAPI.model.User;
import com.techmaster.testSpringRESTAPI.repository.UserRepository;
import com.techmaster.testSpringRESTAPI.service.CourseServiceImpl;
import com.techmaster.testSpringRESTAPI.service.UserService;
import com.techmaster.testSpringRESTAPI.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PageDTO> getAllUsers(
            @RequestParam(required = false) int pageNumber,
            @RequestParam(required = false) int pageSize
    ) {
        PageDTO pageDTO = userService.findAllwithPagination(pageNumber,pageSize);
        return (pageDTO == null) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pageDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        CourseDTO courseDTO = courseService.findCourseById(id);
        return (courseDTO == null) ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course is't exist") :
                ResponseEntity.ok(courseDTO);
    }

    @PostMapping
    public ResponseEntity<?> postCourse(@RequestBody CourseDTO courseDTO) {
        // kiểm tra course đã tồn tại hay chưa
        boolean isCourseExist = courseService.findCourseById(courseDTO.getId()) != null;
        // nếu tồn tại trả về bad request chưa thì lưu
        if (!isCourseExist) {
            courseService.save(courseDTO);
        }
        return isCourseExist ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course is exist !!!") : ResponseEntity.ok(courseDTO);
    }

    @PutMapping
    public ResponseEntity<?> putCourseById(@RequestBody CourseDTO courseDTO) {
        boolean isCourseExist = courseService.findCourseById(courseDTO.getId()) != null;
        // nếu tồn tại trả về bad request chưa thì lưu
        if (isCourseExist) {
            courseService.put(courseDTO);
        }
        return isCourseExist ? ResponseEntity.ok(courseDTO) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course is't exist !!!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        boolean isCourseExist = courseService.findCourseById(id) != null;
        CourseDTO courseDTO = courseService.findCourseById(id);
        // nếu tồn tại trả về bad request chưa thì lưu
        if (isCourseExist) {
            courseService.delete(id);
        }
        return isCourseExist ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course is't exist !!!");
    }

}
