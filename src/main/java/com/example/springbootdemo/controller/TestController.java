package com.example.springbootdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/home")
    @ApiOperation(value = "home", httpMethod = "GET")
    @ResponseBody
    public String home(ModelMap modelMap) {
        System.out.println(modelMap.get("author"));
        int i = 1 / 0;
        return modelMap.get("author").toString();
    }

}
