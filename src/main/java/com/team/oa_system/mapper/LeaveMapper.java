package com.team.oa_system.mapper;

import org.apache.ibatis.annotations.*;
import com.team.oa_system.entity.Leave;

import java.util.List;

@Mapper
public interface LeaveMapper {
    //出差申请
    @Insert("insert into oa_system.leave(employee_id, start_time, end_time,  purpose_or_reason, duration, departure_location, destination, vehicle, approver_id, is_approved) value (#{employee_id},#{start_time},#{end_time},#{purpose_or_reason},#{duration},#{departure_location},#{destination},#{vehicle},0,0)")
    public void applyLeave(Leave leave);

    //根据用户id查看自己的申请的出差申请
    @Select("select * from oa_system.leave where employee_id = #{id}")
    public List<Leave> getLeaveById(Integer id);

    //管理员查看所有未审核出差申请
    @Select("select * from oa_system.leave where is_approved = 0")
    public List<Leave> noReviewLeave();

    //审核出差
    @Update("update oa_system.leave set approver_id = #{approver_id},is_approved = #{is_approved} where leave_id = #{leave_id}")
    public void leaveReview(@Param("leave_id") Integer leave_id, @Param("approver_id") Integer approver_id, @Param("is_approved") Integer is_approved);
}
