package com.techmaster.testSpringRESTAPI.service;

import com.techmaster.testSpringRESTAPI.dto.CourseDTO;
import com.techmaster.testSpringRESTAPI.exception.NotFoundException;
import com.techmaster.testSpringRESTAPI.model.Course;
import com.techmaster.testSpringRESTAPI.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        Course course = new ModelMapper().map(courseDTO,Course.class);
        course.setId(courseRepository.findAll().size()+1);
        courseRepository.save(course);
        return courseDTO;
    }

    @Override
    public CourseDTO put(CourseDTO courseDTO) {
        if(courseRepository.findCourseById(courseDTO.getId()) == null){
            throw new NotFoundException("id "+courseDTO.getId()+" is not exist !!!");
        }
        Course course = new ModelMapper().map(courseDTO,Course.class);
        courseRepository.save(course);
        return courseDTO;
    }

    @Override
    public void delete(int id) {
        if(courseRepository.findCourseById(id) == null){
            throw new NotFoundException("id "+id+" is not exist !!!");
        }
        courseRepository.delete(id);
    }
}
