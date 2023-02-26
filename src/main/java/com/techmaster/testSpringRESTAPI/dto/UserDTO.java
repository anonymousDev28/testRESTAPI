package com.techmaster.testSpringRESTAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull
    private int id;
    @NotNull
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
