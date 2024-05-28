package com.team.oa_system.service;

//import com.sun.tools.javac.util.List;

import com.team.oa_system.entity.Become_full_member;

import java.util.List;

public interface BecomeFullMemberService {
    void fullMemberApply(Become_full_member becomeFullMember);

    List<Become_full_member> fullMemberView(Integer id);

    List<Become_full_member> noFullMemberView();

    void fullMemberReview( Integer become_full_member_id, Integer approver_id, Integer is_approved);

    void updateEmployeeStatus(Integer employee_id);

    Become_full_member getBeFullMemberById(Integer become_full_member_id);
}
