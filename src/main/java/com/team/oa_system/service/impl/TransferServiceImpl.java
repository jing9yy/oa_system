package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Transfer;
import com.team.oa_system.mapper.TransferMapper;
import com.team.oa_system.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferMapper transferMapper;

    //提交调岗申请
    public void applyForTransfer(Transfer transfer) {

        switch (transfer.getTransferToDepartment()){
            case "销售部":transfer.setTransferToDepartmentId(1);
            break;
            case "技术部":transfer.setTransferToDepartmentId(2);
            break;
            case "人力资源部":transfer.setTransferToDepartmentId(3);
            break;
            case "财政部":transfer.setTransferToDepartmentId(4);
            break;
            case "营销部":transfer.setTransferToDepartmentId(5);
            break;
        }
//        System.out.println(transfer);
        transferMapper.applyForTransfer(transfer);
    }
    //根据员工id查看申请
    @Override
    public List<Transfer> applyForView(Integer id) {
        return transferMapper.applyForView(id);
    }

    @Override
    public List<Transfer> noReviewTransfer(){
        List<Transfer> noReviewTransferList = transferMapper.noReviewTransfer();
        return noReviewTransferList;
    }
    //审批调岗申请
    @Override
    @Transactional
    public void transferReview(Integer transferId, Integer approverId, Integer isApproved) {
        // 更新调岗申请表的审批状态
        transferMapper.transferReview(transferId, approverId, isApproved);
        // 如果审批通过，更新员工表
        if (isApproved == 1) { // 假设1表示通过
            Transfer transfer = transferMapper.getTransferById(transferId);
            if (transfer != null) {
                updateEmployeeDepartmentAndPosition(transfer.getEmployeeId(), transfer.getTransferToDepartmentId(), transfer.getTransferToPosition());
            }
        }
    }

    @Override
    public void updateEmployeeDepartmentAndPosition(Integer employeeId, Integer departmentId, String position) {
        transferMapper.updateEmployeeDepartmentAndPosition(employeeId, departmentId, position);
    }
}
