package com.team.oa_system.controller;

//import com.sun.tools.javac.util.List;

import com.team.oa_system.entity.Become_full_member;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.BecomeFullMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BecomeFullMemberController {
    @Autowired
    private BecomeFullMemberService becomeFullMemberService;

    @PostMapping("/fullMemberApply")
    public Result fullMemberApply(@RequestBody Become_full_member becomeFullMember) {
        becomeFullMemberService.fullMemberApply(becomeFullMember);
        return Result.success("申请成功");
    }

    @GetMapping("/fullMemberView/{id}")
    public Result fullMemberView(@PathVariable("id") Integer id) {
        List<Become_full_member> becomeFullMemberList = becomeFullMemberService.fullMemberView(id);
        return Result.success(becomeFullMemberList);
    }

    @GetMapping("/noFullMemberView")
    public Result noFullMemberView() {
        List<Become_full_member> noFullMemberList = becomeFullMemberService.noFullMemberView();
        return Result.success(noFullMemberList);
    }

    @PutMapping("/fullMemberReview/{become_full_member_id}/{approver_id}/{is_approved}")
    public Result fullMemberReview(@PathVariable("become_full_member_id") Integer become_full_member_id,@PathVariable("approver_id") Integer approver_id,@PathVariable("is_approved") Integer is_approved) {
        becomeFullMemberService.fullMemberReview(become_full_member_id,approver_id,is_approved);
        return Result.success("审批成功");
    }

}
