package com.example.springbootdemo.serivce.impl;


import com.example.springbootdemo.dao.UserMapper;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.model.UserExample;
import com.example.springbootdemo.serivce.UserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User user) {
        log.debug("debug 日志");
        log.info("info 日志");
        log.warn("warn 日志");
        log.error("error 日志");
        userMapper.insert(user);
        return user;
    }

    @Override
    public List<User> queryPageable(int curPage, int size) {
        log.debug("debug 日志");
        log.info("info 日志");
        log.warn("warn 日志");
        log.error("error 日志");
        PageHelper.startPage(curPage,size).setOrderBy("id desc");
        return userMapper.selectByExample(new UserExample());
    }

}
