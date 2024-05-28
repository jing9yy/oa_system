package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer employee_id;//员工id
    private String name;//姓名
    private Integer department_id;//部门id
    private String position;//部门id
    private String phone_number;//手机号
    private String id_card;//身份证号

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthdate;//生日
    private Integer is_regular_employee;//是否是正式员工，为0不是，为1是

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate hire_date;//入职时间
    private String password;//账号密码
    private String account;//账号
    private Integer permission;//权限，为0是普通员工，为1是管理员
    private String department_name;//部门名称
}
