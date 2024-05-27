package com.team.oa_system.service;

import com.team.oa_system.entity.Reimbursement;

import java.util.List;


public interface ReimbursementService {

    void reimburseApply(Reimbursement reim);

    List<Reimbursement> reimburseForView(Integer id);

    List<Reimbursement> noReimburse();

    void reimburseReview(Integer reimbursement_id, Integer approver_id, Integer is_approved);
}
