package com.team.oa_system.controller;

import com.team.oa_system.entity.Overtime;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OvertimeController {
    @Autowired
    private OvertimeService overtimeService;

    //加班相关接口

    //加班申请
    @PostMapping("/applyOvertime")
    public Result applyOvertime(@RequestBody Overtime overtime){
        overtimeService.applyOvertime(overtime);
        return Result.success("加班申请成功");
    }

    //根据用户id查看自己的加班申请
    @GetMapping("/getOverById/{id}")
    public Result getOvertimeById(@PathVariable Integer id){
        List<Overtime> overtimeList = overtimeService.getOvertimeById(id);
        return Result.success(overtimeList);
    }

    //管理员查看所有未审核加班申请
    @GetMapping("/noReviewOvertime")
    public Result noReviewOvertime(){
        List<Overtime>overtimeList  = overtimeService.noReviewOvertime();
        return  Result.success(overtimeList);
    }

    //审核加班申请
    //根据加班申请id，审核人id，审核是否通过,为1未通过，为2已通过，三个参数
    @PutMapping("/overtimeReview/{overtime_id}/{approver_id}/{is_approved}")
    public Result overtimeReview(@PathVariable Integer overtime_id, @PathVariable Integer approver_id, @PathVariable Integer is_approved){
        overtimeService.overtimeReview(overtime_id,approver_id,is_approved);
        return Result.success();
    }


}