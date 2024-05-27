package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Reimbursement;
import com.team.oa_system.mapper.ReimbursementMapper;
import com.team.oa_system.service.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimbursementServiceImpl implements ReimbursementService {
    @Autowired
    ReimbursementMapper reimbursementMapper;
    public void reimburseApply(Reimbursement reim){
        reimbursementMapper.reimburseApply(reim);
    }

    public List<Reimbursement> reimburseForView(Integer id){
        List<Reimbursement> reimbursementList =  reimbursementMapper.reimburseForView(id);
        return reimbursementList;
    }

    public List<Reimbursement> noReimburse(){
        List<Reimbursement> reimbursementList = reimbursementMapper.noReimburse();
        return reimbursementList;
    }

    @Override
    public void reimburseReview(Integer reimbursement_id, Integer approver_id, Integer is_approved) {
        reimbursementMapper.reimburseReview(reimbursement_id,approver_id,is_approved);
    }
}
