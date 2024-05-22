package com.team.oa_system.controller;

import com.team.oa_system.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public void Result(@RequestBody User user){
        userService.login
    }
}
