package com.team.oa_system.mapper;

import com.team.oa_system.entity.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {
    //登录查询
    @Select("select employee_id,name,department_id,position,phone_number,id_card,birthdate,is_regular_employee,hire_date,password,account,permission,department_name from oa_system.employee where account = #{account} and password = #{password} and permission = #{permission}")
    public Emp login(Emp emp);

    //注册
    @Insert("insert into oa_system.employee(name,department_id,position,phone_number,id_card,birthdate,is_regular_employee,hire_date,password,account,permission,department_name) value (#{name},#{department_id},#{position},#{phone_number},#{id_card},#{birthdate},0,#{hire_date},#{password},#{account},0,#{department_name})")
    public void register(Emp emp);

    //根据id获得员工信息,部门id在ServiceImpl层设置
    @Select("select employee_id,name,department_id,position,phone_number,id_card,birthdate,is_regular_employee,hire_date,password,account,permission,department_name from oa_system.employee where employee_id = #{id}")
    public Emp getById(Integer id);

    //根据id修改员工密码,方法中不加@param标识会报错
    @Update("update oa_system.employee set password = #{password} where employee_id = #{id}")
    public void updatePassword(@Param("id") Integer id,@Param("password") String password);
}
