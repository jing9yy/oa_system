package com.team.oa_system.mapper;

import com.team.oa_system.entity.Repair_card;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
@Mapper
public interface RepairCardMapper {

    @Insert("INSERT INTO oa_system.repair_card(employee_id,application_date,remark,approver_id,is_approved) VALUES(#{employeeId},#{applicationDate},#{remark},0,0)")
    void RepairCardApply(Repair_card repairCard);

    @Select("SELECT make_up_card_id as makeUpCardId,employee_id as employeeId,application_date as applicationDate,remark,approver_id as approverId,is_approved as isApproved FROM oa_system.repair_card where employee_id =#{id}")
    List<Repair_card> RepairCardForView(Integer id);

    @Select("SELECT make_up_card_id as makeUpCardId,employee_id as employeeId,application_date as applicationDate,remark,approver_id as approverId,is_approved as isApproved FROM oa_system.repair_card where is_approved = 0")
    List<Repair_card> noRepairCard();

    @Update("UPDATE oa_system.repair_card SET approver_id =#{approverId},is_approved =#{isApproved} where make_up_card_id =#{makeUpCardId}")
    void RepairCardForReview(@Param("makeUpCardId") Integer  makeUpCardId, @Param("approverId") Integer approverId,@Param("isApproved") Integer isApproved);

    @Select("SELECT make_up_card_id as makeUpCardId,employee_id as employeeId,application_date as applicationDate,remark,approver_id as approverId,is_approved as isApproved FROM oa_system.repair_card WHERE make_up_card_id = #{makeUpCardId}")
    Repair_card getRepairCardById(@Param("makeUpCardId") Integer makeUpCardId);

    // 更新 attendance 表的方法
    @Update("UPDATE oa_system.attendance SET sign_in_status = 1 WHERE employee_id = #{employeeId} and sign_day = #{application_date}")
    void updateAttendance(@Param("employeeId") Integer employeeId,@Param("application_date") LocalDate application_date);

}
