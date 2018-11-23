package com.example.springbootdemo.serivce;

public class MyServiceImpl implements  MyService {
    @Override
    public String pt(String name) {
        return "hello " + name;
    }
}
