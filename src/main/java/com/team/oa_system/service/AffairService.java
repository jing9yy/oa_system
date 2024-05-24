package com.team.oa_system.service;

import com.team.oa_system.entity.Meeting;

import java.util.List;

public interface AffairService {

    //申请会议
    public void applyMeeting(Meeting meeting);

    //根据用户id查看自己的申请的会议列表
    public List<Meeting> getMeetingById(Integer id);

    //管理员查看所有未审核会议申请
    public List<Meeting> noReviewMeeting();

    //审核会议
    public void meetingReview(Integer meeting_id,Integer approver_id,Integer is_approved);
}
