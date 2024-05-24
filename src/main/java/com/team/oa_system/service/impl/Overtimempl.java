package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Overtime;
import com.team.oa_system.mapper.OvertimeMapper;
import com.team.oa_system.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Overtimempl implements OvertimeService{
    @Autowired
    private OvertimeMapper overtimeMapper;

    //加班申请
    @Override
    public void applyOvertime(Overtime overtime) {
        overtimeMapper.applyOvertime(overtime);
    }

    //根据用户id查看自己的申请的加班申请
    @Override
    public List<Overtime> getOvertimeById(Integer id) {
        List<Overtime>overtimeList = overtimeMapper.getOvertimeById(id);
        return overtimeList;
    }

    //管理员查看所有未审核加班申请
    @Override
    public List<Overtime> noReviewOvertime() {
        List<Overtime>noReviewOvertime = overtimeMapper.noReviewOvertime();
        return noReviewOvertime;
    }

    //审核会议
    @Override
    public void overtimeReview(Integer overtime_id, Integer approver_id, Integer is_approved) {
        overtimeMapper.overtimeReview(overtime_id,approver_id,is_approved);
    }
}
