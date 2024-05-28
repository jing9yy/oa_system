package com.team.oa_system.service;

import com.team.oa_system.entity.Resignation;

import java.util.List;

public interface ResignationService {
    //加班申请
    public void applyResignation(Resignation resignation);

    //根据用户id查看自己的申请的离职申请
    public List<Resignation> getResignationById(Integer id);

    //管理员查看所有未审核离职申请
    public List<Resignation> noReviewResignation();

    //审核离职
    public void resignationReview(Integer resignation_id, Integer approver_id, Integer is_approved);

}
