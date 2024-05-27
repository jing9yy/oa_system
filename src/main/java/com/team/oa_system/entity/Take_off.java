package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Take_off {
    private Integer take_off_id;
    private Integer employee_id;
    private Date start_time;
    private Date end_time;
    private String reason;
    private String leave_type;
    private Integer approver_id;
    private Integer is_approved;


}
