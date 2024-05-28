package com.team.oa_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.team.oa_system.entity.Resignation;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.ResignationService;

import java.util.List;

@RestController
public class ResignationController {
    @Autowired
    ResignationService resignationService;

    //离职相关接口

    //离职申请
    @PostMapping("/applyResignation")
    public Result applyResignation(@RequestBody Resignation resignation){
        resignationService.applyResignation(resignation);
        return Result.success("离职申请成功");
    }

    //根据用户id查看自己的离职申请
    @GetMapping("/getResignationById/{id}")
    public Result getResignationById(@PathVariable Integer id){
        List<Resignation> resignationList = resignationService.getResignationById(id);
        return Result.success(resignationList);
    }

    //管理员查看所有未审核离职申请
    @GetMapping("/noReviewResignation")
    public Result noReviewResignation(){
        List<Resignation>resignationList  = resignationService.noReviewResignation();
        return  Result.success(resignationList);
    }

    //审核离职申请
    @PutMapping("/resignationReview/{resignation_id}/{approver_id}/{is_approved}")
    public Result resignationReview(@PathVariable Integer resignation_id, @PathVariable Integer approver_id, @PathVariable Integer is_approved){
        resignationService.resignationReview(resignation_id,approver_id,is_approved);
        return Result.success();
    }
}