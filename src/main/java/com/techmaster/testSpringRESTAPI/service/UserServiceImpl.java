package com.techmaster.testSpringRESTAPI.service;

import com.techmaster.testSpringRESTAPI.dto.UserDTO;
import com.techmaster.testSpringRESTAPI.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;
    public UserDTO getUserById(int id) {
        return new ModelMapper().map(userRepository.findUserById(id),UserDTO.class);
    }
    public List<UserDTO> findAll(int pageNumber, int pageSize) {
        return userRepository.findAll(pageNumber,pageSize);
    }
}
