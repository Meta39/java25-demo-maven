package com.fu.springbootdemo.controller;

import com.fu.springbootdemo.entity.User;
import com.fu.springbootdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("getNameById/{id}")
    public String getNameById(@PathVariable Integer id) {
        return userService.findNameById(id);
    }

}
