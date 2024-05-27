package com.team.oa_system.mapper;

import com.team.oa_system.entity.Reimbursement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReimbursementMapper {
    @Insert("INSERT INTO oa_system.reimbursement(employee_id, amount, reason, claim_time, approver_id, is_approved) VALUES (#{employee_id}, #{amount}, #{reason}, #{claim_time}, 0, 0)")
    void reimburseApply(Reimbursement reimbursement);

    @Select("SELECT * from oa_system.reimbursement where employee_id =#{employee_id}")
    List<Reimbursement> reimburseForView(Integer employee_id);

    @Select("SELECT * from oa_system.reimbursement where is_approved = 0")
    List<Reimbursement> noReimburse();

    @Update("update oa_system.reimbursement set approver_id = #{approver_id},is_approved = #{is_approved} where reimbursement_id = #{reimbursement_id}")
    void reimburseReview(@Param("reimbursement_id") Integer reimbursement_id,@Param("approver_id") Integer approved_id,@Param("is_approved") Integer is_approved);
}
