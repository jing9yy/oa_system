package com.team.oa_system.controller;

import com.team.oa_system.entity.Emp;
import com.team.oa_system.entity.Result;
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
    public Result login(@RequestBody Emp emp){
        Emp loginEmp = empService.login(emp);
        if (loginEmp != null){
            return Result.success("登录成功");
        }else {
            return Result.error("登录失败");
        }


    }
}
