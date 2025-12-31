package com.fu.springbootdemo.service;

import com.fu.springbootdemo.entity.User;
import com.fu.springbootdemo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }

    public String findNameById(Integer id) {
        return userMapper.findNameById(id);
    }

}
