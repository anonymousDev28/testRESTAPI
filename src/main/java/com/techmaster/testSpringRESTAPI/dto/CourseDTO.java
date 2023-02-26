package com.techmaster.testSpringRESTAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 51)
    private String description;
    @NotNull
    @Pattern(regexp = "^(onlab|online)$")
    private String type;
    @NotNull
    private List<String> topics;
    @NotNull
    private String thumbnail;
    @NotNull
    private UserDTO user;
}
