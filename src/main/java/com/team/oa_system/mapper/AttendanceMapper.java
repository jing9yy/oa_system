package com.team.oa_system.mapper;

import com.team.oa_system.entity.Attendance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AttendanceMapper {

    //签到
    @Insert("insert into oa_system.attendance(employee_id, sign_in_time,sign_day) value (#{employee_id},#{sign_in_time},#{sign_day})")
    public void signIn(Attendance attendance);

    //签退
    @Update("update oa_system.attendance set sign_out_time = #{sign_out_time},sign_in_status = #{sign_in_status} where employee_id = #{employee_id} and sign_day = #{sign_day} ")
    public void signOut(Attendance attendance);
}
