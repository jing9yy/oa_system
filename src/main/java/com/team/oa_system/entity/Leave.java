package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leave {
    private Integer leave_id;//离职id
    private Integer employee_id;//员工id
    private LocalDate start_time;//开始时间
    private LocalDate end_time;//结束时间
    private String departure_location;//出发地点
    private String destination;//目的地
    private  String purpose_or_reason;//目的和理由
    private Integer duration;//时长
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否审批通过，为0未通过，为1已通过
}