package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Meeting;
import com.team.oa_system.mapper.MeetingMapper;
import com.team.oa_system.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingMapper meetingMapper;

    //申请会议
    @Override
    public void applyMeeting(Meeting meeting) {
        meetingMapper.applyMeeting(meeting);
    }

    //根据用户id查看自己的申请的会议列表
    @Override
    public List<Meeting> getMeetingById(Integer id) {
        List<Meeting> meetingList = meetingMapper.getMeetingById(id);
        return meetingList;
    }

    //管理员查看所有未审核会议申请
    @Override
    public List<Meeting> noReviewMeeting() {
        List<Meeting> noReviewMeetingList = meetingMapper.noReviewMeeting();
        return noReviewMeetingList;

    }

    //审核会议
    @Override
    public void meetingReview(Integer meeting_id, Integer approver_id, Integer is_approved) {
        meetingMapper.meetingReview(meeting_id,approver_id,is_approved);
    }
}
