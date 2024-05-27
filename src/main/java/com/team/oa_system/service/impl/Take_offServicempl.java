package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Take_off;
import com.team.oa_system.mapper.Take_offMapper;
import com.team.oa_system.service.Take_offService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Take_offServicempl implements Take_offService{
    @Autowired
    private Take_offMapper take_offMapper;

    //申请请假
    @Override
    public void applyTake_off(Take_off take_off){take_offMapper.applyTake_off(take_off);}

    //根据用户id查看自己的申请的请假申请
    @Override
    public List<Take_off> getTake_offById(Integer id) {
        List<Take_off>leaveList = take_offMapper.getTake_offById(id);
        return leaveList;
    }

    //管理员查看所有请假申请
    @Override
    public List<Take_off> noReviewTake_off() {
        List<Take_off>noReviewTake_off = take_offMapper.noReviewTake_off();
        return noReviewTake_off;
    }

    //审核请假申请
    @Override
    public void take_offReview(Integer take_off_id, Integer approver_id, Integer is_approved) {
        take_offMapper.take_offReview(take_off_id,approver_id,is_approved);
    }
}
