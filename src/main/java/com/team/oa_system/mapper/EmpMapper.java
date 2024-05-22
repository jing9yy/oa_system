package com.team.oa_system.mapper;

import com.team.oa_system.entity.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {
    //登录查询
    @Select("select employee_id,name,department_id,position,phone_number,id_card,birthdate,is_regular_employee,hire_date,password,account,permission from oa_system.employee where account = #{account} and password = #{password} and permission = #{permission}")
    public Emp login(Emp emp);

    //注册
    @Insert("insert into oa_system.employee(name,department_id,position,phone_number,id_card,birthdate,is_regular_employee,hire_date,password,account,permission,department_name) value (#{name},#{department_id},#{position},#{phone_number},#{id_card},#{birthdate},0,#{hire_date},#{password},#{account},0,#{department_name})")
    public void register(Emp emp);
}
