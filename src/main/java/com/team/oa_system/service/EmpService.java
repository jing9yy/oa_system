package com.team.oa_system.service;

import com.team.oa_system.entity.Emp;

public interface EmpService {

    //员工登录
    public Emp login(Emp emp);

    //员工注册
    public void register(Emp emp);
}
