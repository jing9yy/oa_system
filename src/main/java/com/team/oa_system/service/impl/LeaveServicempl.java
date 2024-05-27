package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Leave;
import com.team.oa_system.mapper.LeaveMapper;
import com.team.oa_system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeaveServicempl implements LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;

    //申请出差
    @Override
    public void applyLeave(Leave leave) {leaveMapper.applyLeave(leave);}

    //根据用户id查看自己的申请的出差申请
    @Override
    public List<Leave> getLeaveById(Integer id) {
        List<Leave>leaveList = leaveMapper.getLeaveById(id);
        return leaveList;
    }

    //管理员查看所有出差申请
    @Override
    public List<Leave> noReviewLeave() {
        List<Leave>noReviewLeave = leaveMapper.noReviewLeave();
        return noReviewLeave;
    }

    //审核出差申请
    @Override
    public void leaveReview(Integer leave_id, Integer approver_id, Integer is_approved) {
        leaveMapper.leaveReview(leave_id,approver_id,is_approved);
    }
}
