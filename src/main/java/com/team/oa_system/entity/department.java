package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class department {
    private Integer department_id;//部门id
    private String department_name;//部门名
    private Integer department_manager_id;//部门经理id
}
