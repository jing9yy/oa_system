package com.team.oa_system.service;

import com.team.oa_system.entity.Announcement;

import java.util.List;

public interface AnnouncementService {

    //新增公告
    public void add(Announcement announcement);

    //删除公告
    public void deleteById(Integer id);

    //审核公告
    public void review(Integer announcement_id,Integer approver_id,Integer status);

    //获得全部公告
    public List<Announcement> getAll();

    //获得未审核公告
    public List<Announcement> getNoReview();

    //获得审核通过的公告
    public List<Announcement> getPassList();
}
