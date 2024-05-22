package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class employee {
    private Integer employee;//员工id
    private String name;//姓名
    private  Integer department_id;//部门id
    private String position;//部门id
    private Integer phone_number;//手机号
    private String id_card;//身份证号
    private Data birthdate;//生日
    private Integer is_regular_employee;//是否是正式员工，为0不是，为1是
    private Data hire_date;//入职时间
    private String password;//账号密码
    private String account;//账号
    private Integer permission;//权限，为0是普通员工，为1是管理员
}
