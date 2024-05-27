package com.team.oa_system.service;

import com.team.oa_system.entity.Attendance;

public interface AttendanceService {
    //签到
    public void signIn(Attendance attendance);

    //签退
    public void signOut(Attendance attendance);
}
