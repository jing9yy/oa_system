package com.team.oa_system.mapper;

import com.team.oa_system.entity.Transfer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransferMapper {
    @Insert("INSERT INTO oa_system.transfer (employee_id,transfer_to_department_id, transfer_to_position, approver_id, is_approved) " +
            "VALUES (#{employeeId},#{transferToDepartmentId}, #{transferToPosition}, 0, 0)")
    void applyForTransfer(Transfer transfer);

    @Select("SELECT transfer_id as transferId,employee_id as employeeId,transfer_to_position as transferToPosition,approver_id as approverId,is_approved as isApproved,transfer_to_department_id as transferToDepartmentId,department_name as transferToDepartment from oa_system.transfer,oa_system.department where employee_id = #{employeeId} and transfer_to_department_id = #{transferToDepartmentId}")
    List<Transfer> applyForView(Integer employeeId);

    @Update("UPDATE oa_system.transfer SET is_approved =#{isApproved},approver_id =#{approverId} where transfer_id =#{transferId}")
    void transferReview(@Param("transferId") Integer transferId,@Param("approverId") Integer approverId,@Param("isApproved") Integer isApproved);

    @Select("SELECT * from oa_system.transfer where is_approved = 0")
    List<Transfer> noReviewTransfer();

    @Update("UPDATE oa_system.employee SET department_id = #{departmentId}, position = #{position} WHERE employee_id = #{employeeId}")
    void updateEmployeeDepartmentAndPosition(@Param("employeeId") Integer employeeId, @Param("departmentId") Integer departmentId, @Param("position") String position);

    @Select("SELECT * FROM oa_system.transfer WHERE transfer_id = #{transferId}")
    Transfer getTransferById(@Param("transferId") Integer transferId);
}
