package com.team.oa_system.service;

import com.team.oa_system.entity.Transfer;

import java.util.List;

public interface TransferService {
    void applyForTransfer(Transfer transfer);
    List<Transfer> applyForView(Integer id);
    void transferReview(Integer transferId, Integer approverId, Integer isApproved);
    List<Transfer> noReviewTransfer();
    void updateEmployeeDepartmentAndPosition(Integer employeeId, Integer departmentId, String position);
}

