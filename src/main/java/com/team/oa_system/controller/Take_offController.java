package com.team.oa_system.controller;

import com.team.oa_system.entity.Take_off;
import com.team.oa_system.service.Take_offService;
import com.team.oa_system.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Take_offController {
    @Autowired
    Take_offService take_offService;

    //请假申请
    @PostMapping("/applyTake_off")
    public Result applyTake_off(@RequestBody Take_off take_off){
        take_offService.applyTake_off(take_off);
        return Result.success("请假申请成功");
    }

    //根据用户id查看自己的请假申请
    @GetMapping("/getTake_offById/{id}")
    public Result getTake_offById(@PathVariable Integer id){
        List<Take_off> take_offList = take_offService.getTake_offById(id);
        return Result.success(take_offList);
    }

    //管理员查看所有未审核的请假申请
    @GetMapping("/noReviewTake_off")
    public Result noReviewTake_off(){
        List<Take_off>take_offList =take_offService.noReviewTake_off();
        return  Result.success(take_offList);
    }

    //审核请假申请
    //根据请假申请id，审核人id，审核是否通过,为1未通过，为2已通过，三个参数
    @PutMapping("/Take_offReview/{take_off_id}/{approver_id}/{is_approved}")
    public Result take_offReview(@PathVariable Integer take_off_id, @PathVariable Integer approver_id, @PathVariable Integer is_approved) {
        take_offService.take_offReview(take_off_id, approver_id, is_approved);
        return Result.success();
    }
}