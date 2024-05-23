package com.team.oa_system.controller;

import com.team.oa_system.entity.Emp;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    @PostMapping("/register")
    public Result register(@RequestBody Emp emp){

        empService.register(emp);
        return Result.success("注册成功");
    }

    //根据id查找员工
    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    //根据id修改员工密码
    @PutMapping("/emps/{id}/{password}")
    public Result updatePassword(@PathVariable Integer id,@PathVariable String password){
        empService.updatePassword(id,password);
        return Result.success(password);
    }
}
