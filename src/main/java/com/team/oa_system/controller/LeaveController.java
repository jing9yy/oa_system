package com.team.oa_system.controller;

import com.team.oa_system.entity.Leave;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    //出差申请
    @PostMapping("/applyLeave")
    public Result applyLeave(@RequestBody Leave leave){
        leaveService.applyLeave(leave);
        return Result.success("出差申请成功");
    }

    //根据用户id查看自己的出差申请
    @GetMapping("/getLeaveById/{id}")
    public Result getLeaveById(@PathVariable Integer id){
        List<Leave> leaveList = leaveService.getLeaveById(id);
        return Result.success(leaveList);
    }

    //管理员查看所有未审核的出差申请
    @GetMapping("/noReviewLeave")
    public Result noReviewLeave(){
        List<Leave>leaveList =leaveService.noReviewLeave();
        return  Result.success(leaveList);
    }

    //审核出差申请
    //根据出差申请id，审核人id，审核是否通过,为1未通过，为2已通过，三个参数
    @PutMapping("/LeaveReview/{leave_id}/{approver_id}/{is_approved}")
    public Result leaveReview(@PathVariable Integer leave_id, @PathVariable Integer approver_id, @PathVariable Integer is_approved){
        leaveService.leaveReview(leave_id,approver_id,is_approved);
        return Result.success();
    }
}
