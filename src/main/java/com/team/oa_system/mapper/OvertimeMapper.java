package com.team.oa_system.mapper;

import org.apache.ibatis.annotations.*;
import com.team.oa_system.entity.Overtime;
import java.util.List;

@Mapper
public interface OvertimeMapper {
    //加班申请
    @Insert("insert into oa_system.overtime(employee_id, start_time, end_time, reason, duration, approver_id, is_approved) value (#{employee_id},#{start_time},#{end_time},#{reason},#{duration},0,0)")
    public void applyOvertime(Overtime overtime);

    //根据用户id查看自己的申请的加班申请
    @Select("select * from oa_system.overtime where employee_id = #{id}")
    public List<Overtime> getOvertimeById(Integer id);

    //管理员查看所有未审核加班申请
    @Select("select * from oa_system.overtime where is_approved = 0")
    public List<Overtime> noReviewOvertime();

    //审核会议
    @Update("update oa_system.overtime set approver_id = #{approver_id},is_approved = #{is_approved} where overtime_id = #{overtime_id}")
    public void overtimeReview(@Param("overtime_id") Integer overtime_id,@Param("approver_id") Integer approver_id,@Param("is_approved") Integer is_approved);
}
