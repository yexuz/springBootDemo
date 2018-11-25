package com.example.springbootdemo;

import com.example.springbootdemo.jpadao.ReaderRepository;
import com.example.springbootdemo.jpadao.ReadingListRepository;
import com.example.springbootdemo.model.Book;
//import com.example.springbootdemo.model.User;
import com.example.springbootdemo.model.Reader;
import com.example.springbootdemo.model.User;
//import com.example.springbootdemo.serivce.UserService;
import com.example.springbootdemo.serivce.MyService;
import com.example.springbootdemo.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootdemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private MyService myService;

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId("6");
        userService.save(user);
        Book book = new Book();
        book.setReader("1");
        book.setIsbn("2");
        book.setTitle("3");
        book.setAuthor("4");
        book.setDescription("5");
        readingListRepository.save(book);
    }

    @Test
    public void testCondition() {
        log.info(myService.pt("jack"));
    }
    @Test
    public void testReaderRepository() {
        Reader reader = readerRepository.getOne("admin");
        System.out.println(reader.getUsername());
    }

    @Test
    public void test() {
        String pwd = "123456Aa";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encodedPassword = passwordEncoder.encode(pwd);
        log.info("【加密后的密码为：】" + encodedPassword);
    }
}
