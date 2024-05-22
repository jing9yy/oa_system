package com.team.oa_system.controller;

import com.team.oa_system.entity.Emp;
import com.team.oa_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public void Result(@RequestBody Emp emp){

    }
}
