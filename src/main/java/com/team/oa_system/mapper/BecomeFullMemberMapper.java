package com.team.oa_system.mapper;

//import com.sun.tools.javac.util.List;
import com.team.oa_system.entity.Become_full_member;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface BecomeFullMemberMapper {
    @Insert("INSERT INTO oa_system.become_full_member(become_full_member_id, employee_id, approver_id, position, is_approved, effective_date) VALUES (#{become_full_member_id},#{employee_id},#{approver_id},#{position},0,#{effective_date})")
    void fullMemberApply(Become_full_member becomeFullMember);

    @Select("SELECT * FROM oa_system.become_full_member where employee_id =#{emplyee_id}")
    List<Become_full_member> fullMemberView(@Param("emplyee_id") Integer emplyee_id);

    @Select("SELECT * FROM oa_system.become_full_member where is_approved = 0")
    List<Become_full_member> noFullMemberView();

    @Update("UPDATE oa_system.become_full_member SET  approver_id =#{approver_id}, is_approved =#{is_approved} where become_full_member_id =#{become_full_member_id}")
    void fullMemberReview(@Param("become_full_member_id") Integer become_full_member_id,@Param("approver_id") Integer approver_id,@Param("is_approved") Integer is_approved);

    @Select("SELECT * FROM oa_system.become_full_member WHERE become_full_member_id =#{become_full_member_id}")
    Become_full_member getBeFullMemberById(@Param("become_full_member_id") Integer become_full_member_id);

    @Update("UPDATE oa_system.employee SET is_regular_employee = 1 where employee_id =#{employee_id}")
    void updateEmployeeStatus(@Param("employee_id") Integer employee_id);
}

