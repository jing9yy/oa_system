package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Attendance;
import com.team.oa_system.mapper.AttendanceMapper;
import com.team.oa_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AttendanceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    //签到
    @Override
    public void signIn(Attendance attendance) {
        Date sign_day = null;
        Date sign_out_time = attendance.getSign_in_time();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        String strDate4 = sdf4.format(sign_out_time);//签到时间的年月日，字符串形式
        System.out.println(strDate4);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            sign_day = sdf2.parse(strDate4);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(sign_day);

        attendance.setSign_day(sign_day);
        attendanceMapper.signIn(attendance);
    }

    @Override
    public void signOut(Attendance attendance) {
        Date sign_day = attendance.getSign_day();
        Date sign_out_time = attendance.getSign_out_time();

        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        String strDate4 = sdf4.format(sign_day);
        System.out.println(strDate4);
        //签退截至时间
        String deadLine = strDate4 + " 18:00:00";
        System.out.println(deadLine);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date myDate2 = null;
        try {
            myDate2 = sdf2.parse(deadLine);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(myDate2);

        if(sign_out_time.after(myDate2)){
            //签退时间晚于规定时间
            attendance.setSign_in_status(1);
        }else {
            attendance.setSign_in_status(0);
        }
        System.out.println(attendance.getSign_in_status());
        attendanceMapper.signOut(attendance);
    }
}
