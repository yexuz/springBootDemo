package com.example.springbootdemo.controller;

import com.example.springbootdemo.jpadao.ReaderRepository;
import com.example.springbootdemo.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReaderController {
    @Autowired
    private ReaderRepository readerRepository;
    @RequestMapping("/reader/{username}")
    public String readerOne(@PathVariable String username) {

        Reader one = readerRepository.getOne(username);
        System.out.println(one.getUsername() + " : " + one.getPassword());
        return one.getUsername() + " : " + one.getPassword();
    }
}
