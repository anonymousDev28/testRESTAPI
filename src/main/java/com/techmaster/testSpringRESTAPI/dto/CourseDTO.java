package com.techmaster.testSpringRESTAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private int id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private UserDTO user;
}
