package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    private Integer attendance_id;//签到id
    private Integer employee_id;//员工id
    private  Integer sign_in_status;//签到状态为0，表示未签到，为1表示正常签到

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime sign_in_time;//签到时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime sign_out_time;//签退时间

    private Date sign_day;//签到日期

}
