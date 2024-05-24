package com.team.oa_system.mapper;

import com.team.oa_system.entity.Meeting;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AffairMapper {

    //申请会议
    @Insert("insert into oa_system.meeting(employee_id, meeting_time, location, topic, duration, approver_id, is_approved) value (#{employee_id},#{meeting_time},#{location},#{topic},#{duration},0,0)")
    public void applyMeeting(Meeting meeting);

    //根据用户id查看自己的申请的会议列表
    @Select("select * from oa_system.meeting where employee_id = #{id}")
    public List<Meeting> getMeetingById(Integer id);

    //管理员查看所有未审核会议申请
    @Select("select * from oa_system.meeting where is_approved = 0")
    public List<Meeting> noReviewMeeting();

    //审核会议
    @Update("update oa_system.meeting set approver_id = #{approver_id},is_approved = #{is_approved} where meeting_id = #{meeting_id}")
    public void meetingReview(@Param("meeting_id") Integer meeting_id,@Param("approver_id") Integer approver_id,@Param("is_approved") Integer is_approved);
}
