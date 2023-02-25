package com.techmaster.testSpringRESTAPI.repository;

import com.techmaster.testSpringRESTAPI.database.CourseDB;
import com.techmaster.testSpringRESTAPI.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CourseRepository {
    public List<Course> findAll(){
        return CourseDB.courses;
    }
}
