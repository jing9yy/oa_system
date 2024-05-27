package com.team.oa_system.service;

import com.team.oa_system.entity.Take_off;


import java.util.List;

public interface Take_offService {
    //请假申请
    public void applyTake_off(Take_off take_off);

    //根据用户id查看自己的申请的请假申请
    public List<Take_off> getTake_offById(Integer id);

    //管理员查看所有未审核请假申请
    public List<Take_off> noReviewTake_off();

    //审核请假
    public void take_offReview(Integer take_off_id, Integer approver_id, Integer is_approved);


}
