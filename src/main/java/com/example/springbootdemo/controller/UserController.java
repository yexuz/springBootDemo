package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.serivce.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "User apis")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    @ApiOperation(value = "Add a user", httpMethod = "POST")
    public User save(@RequestBody User user){
        return userService.save(user);
    }


    @GetMapping
    @ApiOperation(value = "Query users", httpMethod = "GET")
    public List<User> findAll(@RequestParam(value = "page",defaultValue = "0") int curPage , @RequestParam(value = "size",defaultValue = "10") int size){
        return userService.queryPageable(curPage,size);
    }
}
