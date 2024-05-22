package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    private Integer meeting_id;//会议id
    private Integer employee_id;//员工id
    private LocalDate meeting_time;//会议时间
    private String location;//会议地点
    private String topic;//会议主题
    private Integer duration;//会议时长
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否审批通过

}
