package com.noah.nframework.demo.service;

import com.noah.nframework.core.annotation.Service;
import com.noah.nframework.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 14:25
 */
@Service
public class UserService {

    private final List<User> users = new ArrayList<User>(3);

    public UserService() {
        User userA = new User();
        userA.setId(1L);
        userA.setName("noah");
        users.add(userA);

        User userB = new User();
        userB.setId(2L);
        userB.setName("cindy");
        users.add(userB);

        User userC = new User();
        userC.setId(3L);
        userC.setName("july");
        users.add(userC);
    }

    public User get(Long id) {
        Optional<User> userOptional = users.stream().filter(x -> x.getId().equals(id)).findFirst();
        return userOptional.orElse(null);
    }

    public List<User> query() {
        return users;
    }
}
