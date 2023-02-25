package com.techmaster.testSpringRESTAPI.database;

import com.techmaster.testSpringRESTAPI.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(
            List.of(new User(1,"Pham Huong","phamhuong1@gmail.com","0934234243","avatar"),
                    new User(2,"Chu Dat","chudat1@gmail.com","093433634243","avatar"),
            new User(3,"Nguyen Tuyen","nguyentuyen1@gmail.com","0989234243","avatar")
                    ));
}
