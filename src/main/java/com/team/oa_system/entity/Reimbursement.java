package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {
    private Integer reimbursement_id;//报销id
    private Integer employee_id;//员工id
    private Float amount;//报销金额
    private String reason;//报销原因

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime claim_time;//报销时间
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否通过，为0未通过，为1已通过
}
