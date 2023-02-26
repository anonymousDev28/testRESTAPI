package com.techmaster.testSpringRESTAPI.service;

import com.techmaster.testSpringRESTAPI.dto.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> findAll(int pageNumber, int pageSize);
}
