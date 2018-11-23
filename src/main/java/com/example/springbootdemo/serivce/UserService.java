package com.example.springbootdemo.serivce;

import com.example.springbootdemo.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> queryPageable(int curPage, int size);
}
