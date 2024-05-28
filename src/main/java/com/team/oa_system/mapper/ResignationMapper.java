package com.team.oa_system.mapper;

import com.team.oa_system.entity.Resignation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResignationMapper {
    //申请离职
    @Insert("insert into oa_system.resignation(employee_id, reason,  approver_id, is_approved) value (#{employee_id},#{reason},0,0)")
    public void applyResignation(Resignation resignation);

    //根据用户id查看自己的申请的离职申请
    @Select("select * from oa_system.resignation where employee_id = #{id}")
    public List<Resignation> getResignationById(Integer id);

    //管理员查看所有未审核离职申请
    @Select("select * from oa_system.resignation where is_approved = 0")
    public List<Resignation> noReviewResignation();

    //审核离职
    @Update("update oa_system.resignation set approver_id = #{approver_id},is_approved = #{is_approved} where resignation_id = #{resignation_id}")
    public void resignationReview(@Param("resignation_id") Integer resignation_id, @Param("approver_id") Integer approver_id, @Param("is_approved") Integer is_approved);

    //删除员工
    @Delete("delete from oa_system.employee where employee_id=#{id}")
    public void deleteEmp(Integer id);

    @Select("select employee_id from oa_system.resignation where resignation_id=#{id}")
    public int getEmpId(Integer id);

}