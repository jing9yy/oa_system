package com.team.oa_system.controller;

import com.team.oa_system.entity.Meeting;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    //会议事务相关接口

    //申请会议
    @PostMapping("/applyMeeting")
    public Result applyMeeting(@RequestBody Meeting meeting){
        meetingService.applyMeeting(meeting);
        return Result.success("会议申请成功");
    }

    //根据用户id查看自己的申请的会议
    @GetMapping("/getById/{id}")
    public Result getMeetIngById(@PathVariable Integer id){
        List<Meeting> meetingList = meetingService.getMeetingById(id);
        return Result.success(meetingList);
    }
    //管理员查看所有未审核会议申请
    @GetMapping("/noReviewMeeting")
    public Result noReviewMeeting(){
        List<Meeting> noReviewMeetingList = meetingService.noReviewMeeting();
        return  Result.success(noReviewMeetingList);
    }

    //审核会议
    //根据会议申请id，审核人id，审核是否通过,为1未通过，为2已通过，三个参数
    @PutMapping("/meetingReview/{meeting_id}/{approver_id}/{is_approved}")
    public Result meetingReview(@PathVariable Integer meeting_id, @PathVariable Integer approver_id, @PathVariable Integer is_approved){
        meetingService.meetingReview(meeting_id,approver_id,is_approved);
        return Result.success();
    }

}
