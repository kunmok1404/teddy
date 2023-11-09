package com.example.teddy;

import com.example.teddy.dto.UserDto;
import com.example.teddy.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test {

    @Autowired
    private UserMapper userMapper;

    @org.junit.jupiter.api.Test
    void test() {
        List<UserDto> list = userMapper.findAll();
        System.out.println("list = " + list);
    }
}
