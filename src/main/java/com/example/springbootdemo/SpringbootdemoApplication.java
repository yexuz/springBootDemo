package com.example.springbootdemo;

import com.example.springbootdemo.serivce.MyService;
import com.example.springbootdemo.serivce.MyServiceImpl;
import com.example.springbootdemo.springcondition.JdbcTemplateCondition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootApplication
@MapperScan("com.example.springbootdemo.dao")
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class,
                args);
    }

    @Bean
//    @Conditional(JdbcTemplateCondition.class) //  ，只有当JdbcTemplateCondition类的条件成立时才会创建MyService这个bean
   @ConditionalOnClass(JdbcTemplateCondition.class)
    public MyService myService() {
        return new MyServiceImpl();
    }
}
