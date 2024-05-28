package com.team.oa_system.service;

import com.team.oa_system.entity.Repair_card;

import java.time.LocalDate;
import java.util.List;

public interface RepairCardService {
    void RepairCardApply(Repair_card repairCard);

    List<Repair_card> RepairCardForView(Integer id);

    List<Repair_card> noRepairCard();

    void RepairCardForReview(Integer makeUpCardId, Integer approverId, Integer isApproved);

    void updateAttendance(Integer employeeId, LocalDate application_date);
}
