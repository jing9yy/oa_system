package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    private Integer meeting_id;//会议id
    private Integer employee_id;//员工id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime meeting_time;//会议时间

    private String location;//会议地点
    private String topic;//会议主题
    private Integer duration;//会议时长
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否审批通过

}
