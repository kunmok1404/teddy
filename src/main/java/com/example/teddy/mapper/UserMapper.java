package com.example.teddy.mapper;

import com.example.teddy.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    // 유저 전체 조회
    List<UserDto> findAll();

}
