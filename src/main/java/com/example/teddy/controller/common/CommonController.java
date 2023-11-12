package com.example.teddy.controller.common;

import com.example.teddy.dto.UserDto;
import com.example.teddy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
//        List<UserDto> list = userService.userList();
//        System.out.println("list = " + list);
        return "index";
    }

}
