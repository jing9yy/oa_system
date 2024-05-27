package com.team.oa_system.controller;

import com.team.oa_system.entity.Repair_card;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.RepairCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepairCardController {
    @Autowired
    private RepairCardService repairCardService;
    //补卡申请
    @PostMapping("/RepairCardApply")
    public Result RepairCardApply(@RequestBody Repair_card repair_card) {
        repairCardService.RepairCardApply(repair_card);
        return Result.success("补卡申请成功");
    }
    //查看员工个人补卡申请表
    @GetMapping("/RepairCardForView/{id}")
    public Result RepairCardForView(@PathVariable("id") Integer id){
        List<Repair_card> repairCardList = repairCardService.RepairCardForView(id);
        return Result.success(repairCardList);
    }
    //审批人查看所有的未审批补卡申请
    @GetMapping("/noRepairCard")
    public Result noRepairCard() {
        List<Repair_card> noRepairCardList = repairCardService.noRepairCard();
        return Result.success(noRepairCardList);
    }
    //审批人审批补卡申请，需要传入的参数是补卡id，审批人id，审批状态
    @PutMapping("/RepairCardForReview/{makeUpCardId}/{approverId}/{isApproved}")
    public Result RepairCardForReview(@PathVariable("makeUpCardId") Integer makeUpCardId,@PathVariable("approverId") Integer approverId,@PathVariable("isApproved") Integer isApproved){
        repairCardService.RepairCardForReview(makeUpCardId,approverId,isApproved);
        return Result.success();
    }
}
