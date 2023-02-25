package com.techmaster.testSpringRESTAPI.repository;

import com.techmaster.testSpringRESTAPI.database.UserDB;
import com.techmaster.testSpringRESTAPI.dto.UserDTO;
import com.techmaster.testSpringRESTAPI.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    public List<UserDTO> findAll(int pageNumber,int pageSize){
        List<User> users = UserDB.users.stream().filter(user -> user.getId() > pageSize * (pageNumber - 1) && user.getId() <= (pageSize * pageNumber)).toList();
        ModelMapper modelMapper = new ModelMapper();
        return users.stream().map(user -> modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
    }

    public User findUserById(int id) {
        return UserDB.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
