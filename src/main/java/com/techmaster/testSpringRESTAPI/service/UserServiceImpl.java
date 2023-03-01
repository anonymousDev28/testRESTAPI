package com.techmaster.testSpringRESTAPI.service;

import com.techmaster.testSpringRESTAPI.database.UserDB;
import com.techmaster.testSpringRESTAPI.dto.PageDTO;
import com.techmaster.testSpringRESTAPI.dto.UserDTO;
import com.techmaster.testSpringRESTAPI.model.User;
import com.techmaster.testSpringRESTAPI.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;
    public UserDTO getUserById(int id) {
        return new ModelMapper().map(userRepository.findUserById(id),UserDTO.class);
    }
    public List<UserDTO> findAll(int pageNumber, int pageSize) {
        List<User> users = userRepository.findAll().stream().filter(user -> user.getId() > pageSize * (pageNumber - 1) && user.getId() <= (pageSize * pageNumber)).toList();
        return users.stream().map(user -> new ModelMapper().map(user,UserDTO.class)).collect(Collectors.toList());
    }
    public PageDTO findAllwithPagination(int pageNumber,int pageSize){
        int totalItems = userRepository.findAll().size();
        int totalPages = totalItems / pageSize + 1;
        return new PageDTO(pageNumber,pageSize,totalPages,totalItems,findAll(pageNumber,pageSize));
    }
}
