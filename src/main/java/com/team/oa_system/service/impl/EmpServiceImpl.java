package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Emp;
import com.team.oa_system.mapper.EmpMapper;
import com.team.oa_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public Emp login(Emp emp) {
        Emp loginEmp = empMapper.login(emp);
        return loginEmp;

    }

    //员工注册
    @Override
    public void register(Emp emp) {
        emp.setHire_date(LocalDate.now());
        empMapper.register(emp);
    }
}
