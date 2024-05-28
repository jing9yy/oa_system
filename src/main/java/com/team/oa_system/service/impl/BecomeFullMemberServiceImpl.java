package com.team.oa_system.service.impl;

//import com.sun.tools.javac.util.List;

import com.team.oa_system.entity.Become_full_member;
import com.team.oa_system.mapper.BecomeFullMemberMapper;
import com.team.oa_system.service.BecomeFullMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BecomeFullMemberServiceImpl implements BecomeFullMemberService {

    @Autowired
    private BecomeFullMemberMapper becomeFullMemberMapper;
    @Override
    public void fullMemberApply(Become_full_member becomeFullMember){
        becomeFullMemberMapper.fullMemberApply(becomeFullMember);
    }
    @Override
    public List<Become_full_member> fullMemberView(Integer id){
        List<Become_full_member> becomeFullMemberList = becomeFullMemberMapper.fullMemberView(id);
        return becomeFullMemberList;
    }
    @Override
    public List<Become_full_member> noFullMemberView(){
        List<Become_full_member> noFullMemberList = becomeFullMemberMapper.noFullMemberView();
        return noFullMemberList;
    }
    @Override
    public void fullMemberReview( Integer become_full_member_id, Integer approver_id, Integer is_approved){
        becomeFullMemberMapper.fullMemberReview(become_full_member_id,approver_id,is_approved);
        if(is_approved == 1) {
            Become_full_member becomeFullMember = becomeFullMemberMapper.getBeFullMemberById(become_full_member_id);
            if(becomeFullMember != null) {
                becomeFullMemberMapper.updateEmployeeStatus(becomeFullMember.getEmployee_id());
            }
        }
    }
    @Override
    public Become_full_member getBeFullMemberById(Integer become_full_member_id){
        return becomeFullMemberMapper.getBeFullMemberById(become_full_member_id);
    }

    @Override
    public void updateEmployeeStatus(Integer employee_id) {
        becomeFullMemberMapper.updateEmployeeStatus(employee_id);
    }
}
