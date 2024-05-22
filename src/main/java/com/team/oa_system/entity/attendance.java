package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class attendance {
    private Integer attendance_id;//签到id
    private Integer employee_id;//员工id
    private  Integer sign_in_status;//签到状态为0，表示未签到，为1表示正常签到
    private LocalDate sign_in_time;//签到时间
    private LocalDate sign_out_time;//签退时间
    private Integer normal_sign_in_count;//正常签到次数
    private Integer early_leave_count;//早退次数
    private Integer late_count;//迟到次数

}
