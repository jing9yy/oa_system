package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Overtime {
    private Integer overtime_id;//加班id
    private Integer employee_id;//员工id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime start_time;//开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime end_time;//结束时间

    private String reason;//加班原因
    private Integer duration;//加班时长
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否审批通过，为0未通过，为1通过

}
