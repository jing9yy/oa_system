package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Become_full_member {
    private Integer become_full_member_id;//转正id
    private Integer employee_id;//员工id

    private Integer approver_id;//审批人id
    private String position;//职位
    private Integer is_approved;//是否审批通过，为0未通过，为1已通过
    private LocalDate effective_date;//生效日期
}
