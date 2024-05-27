package com.team.oa_system.controller;

import com.team.oa_system.entity.Attendance;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    //签到
    @PostMapping("/signIn")
    public Result signIn(@RequestBody Attendance attendance){
        attendanceService.signIn(attendance);
        return Result.success();
    }

    //签退
    @PutMapping("/signOut")
    public Result signOut(@RequestBody Attendance attendance){
//        System.out.println(sign_out_time);
//        Date date = new Date(Long.parseLong(sign_out_time));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String signOutTime = sdf.format(date);
//        System.out.println(signOutTime);
//
//        String[] s = signOutTime.split(" ");
//        String signDay = s[0];
//        System.out.println(signDay);
        Date signOutTime = attendance.getSign_out_time();
//        System.out.println(attendance.getSign_out_time());

        Date signDay = new Date(signOutTime.getYear(),signOutTime.getMonth(),signOutTime.getDay());
//        System.out.println(signDay);
        attendance.setSign_day(signDay);

        attendanceService.signOut(attendance);
        return Result.success();
    }
}
