package com.example.springbootdemo.config;

import com.example.springbootdemo.dao.UserMapper;
import com.example.springbootdemo.jpadao.ReaderRepository;
import com.example.springbootdemo.model.Reader;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").access("haseRole('READER')")
                .antMatchers("/**").permitAll()
                .and().formLogin();
//                .loginPage("/login")
//                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                System.out.println(username);
//                return readerRepository.getOne(username);


                UserExample where = new UserExample();
                where.createCriteria().andUsernameEqualTo(username);
                List<User> users = userMapper.selectByExample(where);
                return users == null ? null : users.get(0);
            }
        }).passwordEncoder(new BCryptPasswordEncoder());;

    }

    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
        return new OpenEntityManagerInViewFilter();
    }

}
