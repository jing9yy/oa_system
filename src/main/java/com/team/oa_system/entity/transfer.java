package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class transfer {
    private Integer transfer_id;//
    private Integer employee_id;//
    private Integer transfer_to_department;
    private String transfer_to_position;
    private Integer approver_id;
    private Integer is_approved;
}
