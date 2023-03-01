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
    public List<User> findAll(){
        return UserDB.users;
    }
    public User findUserById(int id) {
        return UserDB.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
