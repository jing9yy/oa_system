package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Resignation;
import com.team.oa_system.service.ResignationService;
import com.team.oa_system.mapper.ResignationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Resignationmpl implements ResignationService{
    @Autowired
    ResignationMapper resignationMapper;

    //离职申请
    @Override
    public void applyResignation(Resignation resignation) {resignationMapper.applyResignation(resignation);}

    //根据用户id查看自己的申请的离职申请
    @Override
    public List<Resignation> getResignationById(Integer id) {
        List<Resignation>resignationList = resignationMapper.getResignationById(id);
        return resignationList;
    }

    //管理员查看所有未审核离职申请
    @Override
    public List<Resignation> noReviewResignation() {
        List<Resignation>noReviewResignation = resignationMapper.noReviewResignation();
        return noReviewResignation;
    }

    //审核离职
    @Override
    public void resignationReview(Integer resignation_id, Integer approver_id, Integer is_approved) {
        resignationMapper.resignationReview(resignation_id,approver_id,is_approved);
        //有外键关联无法真正删除
//        if (is_approved==2){
//            resignationMapper.deleteEmp(resignationMapper.getEmpId(resignation_id));
//        }
    }
}