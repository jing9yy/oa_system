package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Emp;
import com.team.oa_system.mapper.EmpMapper;
import com.team.oa_system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

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
        System.out.println(emp.getDepartment_name());
        switch (emp.getDepartment_name()){
            case "销售部":emp.setDepartment_id(1);
            break;
            case "技术部":emp.setDepartment_id(2);
            break;
            case "人力资源部":emp.setDepartment_id(3);
            break;
            case "财政部":emp.setDepartment_id(4);
            break;
            case "营销部":emp.setDepartment_id(5);
            break;
        }
        System.out.println(emp.getDepartment_id());
        empMapper.register(emp);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public void updatePassword(Integer id, String password) {
            empMapper.updatePassword(id,password);
    }


}
