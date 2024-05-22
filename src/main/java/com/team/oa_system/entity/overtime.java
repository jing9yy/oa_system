package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class overtime {
    private Integer overtime_id;//加班id
    private Integer employee_id;//员工id
    private LocalDate start_time;//开始时间
    private LocalDate end_time;//结束时间
    private String reason;//加班原因
    private Integer duration;//加班时长
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否审批通过，为0未通过，为1通过

}
