package com.team.oa_system.mapper;

import com.team.oa_system.entity.Repair_card;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RepairCardMapper {

    @Insert("INSERT INTO oa_system.repair_card(make_up_card_id,employee_id,application_date,remark,approver_id,is_approved) VALUES(#{makeUpCardId},#{employeeId},#{applicationDate},#{remark},#{approverId},#{isApproved})")
    void RepairCardApply(Repair_card repairCard);

    @Select("SELECT * FROM oa_system.repair_card where employee_id =#{employeeId}")
    List<Repair_card> RepairCardForView(@Param("id") Integer id);

    @Select("SELECT * FROM oa_system.repair_card where is_approved = 0")
    List<Repair_card> noRepairCard();

    @Update("UPDATE oa_system.repair_card SET approver_id =#{approverId},is_approved =#{isApproved} where make_up_card_id =#{makeUpCardId}")
    void RepairCardForReview(@Param("makeUpCardId") Integer  makeUpCardId, @Param("approverId") Integer approverId,@Param("isApproved") Integer isApproved);

    @Select("SELECT * FROM oa_system.repair_card WHERE make_up_card_id = #{makeUpCardId}")
    Repair_card getRepairCardById(@Param("makeUpCardId") Integer makeUpCardId);

    // 更新 attendance 表的方法
    @Update("UPDATE oa_system.attendance SET normal_sign_in_count = normal_sign_in_count + 1 WHERE employee_id = #{employeeId}")
    void updateAttendance(@Param("employeeId") Integer employeeId);

}
