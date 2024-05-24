package com.team.oa_system.service;

import com.team.oa_system.entity.Overtime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OvertimeService {
    //加班申请
    public void applyOvertime(Overtime overtime);

    //根据用户id查看自己的申请的加班申请
    public List<Overtime> getOvertimeById(Integer id);

    //管理员查看所有未审核加班申请
    public List<Overtime> noReviewOvertime();

    //审核会议
    public void overtimeReview(Integer overtime_id, Integer approver_id, Integer is_approved);
}
