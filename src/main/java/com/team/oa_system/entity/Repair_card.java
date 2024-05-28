package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repair_card {
    private Integer make_up_card_id;//补卡id
    private Integer employee_id;//员工id
    private Data application_date;//申请日期
    private String remark;//备注
    private Integer approver_id;//审批人id
    private Integer is_approved;//是否审批通过
}
