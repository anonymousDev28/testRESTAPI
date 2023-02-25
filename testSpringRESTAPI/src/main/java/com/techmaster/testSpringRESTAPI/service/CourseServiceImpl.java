package com.techmaster.testSpringRESTAPI.service;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;
import com.techmaster.testSpringRESTAPI.model.Course;
import com.techmaster.testSpringRESTAPI.repository.CourseRepository;
import com.techmaster.testSpringRESTAPI.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserServiceImpl userService;

    public List<CourseDTO> findAllCourses(/*int pageNumber, int pageSize*/
            String typeInput,
            String nameInput,
            String[] topicsInput
    ) {
        List<Course> courses = courseRepository.findAll();
        if(typeInput != null){
            courses = courseRepository.findAll().stream().filter(course -> course.getType().equalsIgnoreCase(typeInput)).collect(Collectors.toList());
        }else if(nameInput != null){
            courses = courseRepository.findAll().stream().filter(course -> course.getName().equalsIgnoreCase(nameInput)).collect(Collectors.toList());
        }
        else if(topicsInput != null) {
            courses = courseRepository.findAll().stream().filter(course -> course.getTopics().equals(topicsInput)).collect(Collectors.toList());
        }
//        }else {
//            courses = courseRepository
//                    .findAll()
//                    .stream()
//                    .filter(course -> (course.getId() > (pageNumber-1)*pageSize && course.getId() <= (pageNumber)*pageSize)).toList();
//        }
        List<CourseDTO> courseDTOs = courses.stream()
                .map(course ->
                        new ModelMapper().map(course, CourseDTO.class))
                .collect(Collectors.toList());
        // set user cho course
        courseDTOs.forEach(courseDTO -> courseDTO.setUser(userService.getUserById(courseDTO.getUser().getId())));

        return courseDTOs;
    }

    @Override
    public CourseDTO findCourseById(int id) {
        Course courseDummy = courseRepository
                .findAll()
                .stream()
                .filter(course -> course.getId() == id)
                .findFirst().orElse(null);
        CourseDTO courseDTO = new ModelMapper().map(courseDummy,CourseDTO.class);
        courseDTO.setUser(userService.getUserById(courseDummy.getUserId()));
        return courseDTO;
    }
}
