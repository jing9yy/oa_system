package com.team.oa_system.controller;

import com.team.oa_system.entity.Reimbursement;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReimbursementController {
    @Autowired
    ReimbursementService reimbursementService;
    @PostMapping("/reimburse")
    public Result reimburseApply(@RequestBody Reimbursement reim){
        reimbursementService.reimburseApply(reim);
        return Result.success("报销申请成功");
    }

    //根据员工id查询申请表
    @GetMapping("/reimburseForView/{id}")
    public Result reimburseForView(@PathVariable("id")Integer id){
        List<Reimbursement> reimbursementList = reimbursementService.reimburseForView(id);
        return Result.success(reimbursementList);
    }
    //查询未审批的报销表
    @GetMapping("/noReimburse")
    public Result noReimburse() {
        List<Reimbursement> noReimburseList = reimbursementService.noReimburse();
        return Result.success(noReimburseList);
    }

    //审批人审批
    @PutMapping("/reimburseReview/{reimbursement_id}/{approver_id}/{is_approved}")
    public Result reimburseReview(@PathVariable Integer reimbursement_id,@PathVariable Integer approver_id,@PathVariable Integer is_approved){

        reimbursementService.reimburseReview(reimbursement_id,approver_id,is_approved);
        return Result.success();
    }
}
