package com.techmaster.testSpringRESTAPI.database;

import com.techmaster.testSpringRESTAPI.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(
            List.of(new User(1,"Pham Huong","phamhuong1@gmail.com","0934234243","avatar"),
                    new User(2,"Chu Dat","chudat1@gmail.com","093433634243","avatar"),
                    new User(3,"Nguyen Tuyen","nguyentuyen1@gmail.com","0989234243","avatar"),
                    new User(4,"Pham Quang","phamhuong1@gmail.com","0934234243","avatar"),
                    new User(5,"Bui Hien","chudat1@gmail.com","093433634243","avatar"),
                    new User(6,"Trong Duc","nguyentuyen1@gmail.com","0989234243","avatar"),
                    new User(7,"Johnny Tri Nguyen","phamhuong1@gmail.com","0934234243","avatar"),
                    new User(8,"Kratos","chudat1@gmail.com","093433634243","avatar"),
                    new User(9,"lilnig","nguyentuyen1@gmail.com","0989234243","avatar"),
                    new User(10,"lmaoo track dong","nguyentuyen1@gmail.com","0989234243","avatar")
                    ));
}
