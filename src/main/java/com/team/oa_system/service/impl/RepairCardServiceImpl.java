package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Repair_card;
import com.team.oa_system.mapper.RepairCardMapper;
import com.team.oa_system.service.RepairCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairCardServiceImpl implements RepairCardService {
    @Autowired
    private RepairCardMapper repairCardMapper;
    @Override
    public void RepairCardApply(Repair_card repairCard){
        repairCardMapper.RepairCardApply(repairCard);
    }
    @Override
    public List<Repair_card> RepairCardForView(Integer id){
        List<Repair_card> repairCardList = repairCardMapper.RepairCardForView(id);
        return repairCardList;
    }
    @Override
    public List<Repair_card> noRepairCard() {
        List<Repair_card> noRepairCardList = repairCardMapper.noRepairCard();
        return noRepairCardList;
    }
    @Override
    public void RepairCardForReview(Integer makeUpCardId, Integer approverId, Integer isApproved){
        repairCardMapper.RepairCardForReview(makeUpCardId, approverId, isApproved);

        // 如果审批通过，更新 attendance 表
        if (isApproved == 1) {
            // 获取补卡申请的详细信息
            Repair_card repairCard = repairCardMapper.getRepairCardById(makeUpCardId);
            if (repairCard != null) {
                repairCardMapper.updateAttendance(repairCard.getEmployeeId());
            }
        }
    }
    @Override
    public void updateAttendance(Integer employeeId) {
        repairCardMapper.updateAttendance(employeeId);
    }
}
