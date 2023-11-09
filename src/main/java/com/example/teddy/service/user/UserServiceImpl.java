package com.example.teddy.service.user;

import com.example.teddy.dto.UserDto;
import com.example.teddy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> userList() {
        return userMapper.findAll();
    }
}
