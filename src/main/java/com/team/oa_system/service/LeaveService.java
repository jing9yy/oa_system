package com.team.oa_system.service;

import com.team.oa_system.entity.Leave;


import java.util.List;


public interface LeaveService {
    //出差申请
    public void applyLeave(Leave leave);

    //根据用户id查看自己的申请的出差申请
    public List<Leave> getLeaveById(Integer id);

    //管理员查看所有未审核出差申请
    public List<Leave> noReviewLeave();

    //审核出差
    public void leaveReview(Integer leave_id, Integer approver_id, Integer is_approved);
}
