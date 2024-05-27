package com.team.oa_system.mapper;


import org.apache.ibatis.annotations.*;
import com.team.oa_system.entity.Take_off;

import java.util.List;

@Mapper
public interface Take_offMapper {
    //请假申请
    @Insert("insert into oa_system.take_off(employee_id, start_time, end_time,  reason, leave_type, approver_id, is_approved) value (#{employee_id},#{start_time},#{end_time},#{reason},#{leave_type},0,0)")
    public void applyTake_off(Take_off take_off);

    //根据用户id查看自己的申请的请假申请
    @Select("select * from oa_system.take_off where employee_id = #{id}")
    public List<Take_off> getTake_offById(Integer id);

    //管理员查看所有未审核请假申请
    @Select("select * from oa_system.take_off where is_approved = 0")
    public List<Take_off> noReviewTake_off();

    //审核请假
    @Update("update oa_system.take_off set approver_id = #{approver_id},is_approved = #{is_approved} where take_off_id = #{take_off_id}")
    public void take_offReview(@Param("take_off_id") Integer take_off_id, @Param("approver_id") Integer approver_id, @Param("is_approved") Integer is_approved);


}
