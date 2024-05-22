package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resignation {
    private Integer resignation_id;//离职id
    private Integer employee_id;//员工id
    private String reason;//离职原因
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否审批通过
}
