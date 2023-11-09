package com.example.teddy.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer userId;

    private String name;

    private String password;

    private String gender;

    private int age;
}
