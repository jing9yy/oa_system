package com.team.oa_system.controller;


import com.team.oa_system.entity.Result;
import com.team.oa_system.entity.Transfer;
import com.team.oa_system.service.TransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/transfer")
@Slf4j
public class TransferController {
    @Autowired
    private TransferService transferService;

    //提交调岗申请
    @PostMapping("/applyTransfer")
    public Result applyForTransfer(@RequestBody Transfer transfer) {
//        System.out.println(transfer);
        transferService.applyForTransfer(transfer);
        return Result.success("申请成功");
    }
    //根据员工id，查看自己的调岗申请
    @GetMapping("/showTransferById/{id}")
    public Result applyForView(@PathVariable Integer id) {
        List<Transfer> transferList = transferService.applyForView(id);
        return Result.success(transferList);
    }
    //查看未审批的申请表
    @GetMapping("/noReviewTransfer")
    public Result noReviewTransfer() {
        List<Transfer> noReviewTransferList = transferService.noReviewTransfer();
        System.out.println(noReviewTransferList);
        return Result.success(noReviewTransferList);
    }
    //审批人审批调岗申请，需要上传调岗id，审批人id，审批状态
//    @PutMapping("/transferReview/{transfer_id}/{approver_id}/{is_approved}")
//    public Result transferReview(@PathVariable Integer transfer_id,@PathVariable Integer approver_id, @PathVariable Integer is_approved){
//        transferService.transferReview(transfer_id,approver_id,is_approved);
//        return Result.success();
//    }
    @PutMapping("/transferReview/{transferId}/{approverId}/{isApproved}")
    public Result transferReview(@PathVariable Integer transferId, @PathVariable Integer approverId, @PathVariable Integer isApproved) {
        transferService.transferReview(transferId, approverId, isApproved);
        return Result.success();
    }

}
