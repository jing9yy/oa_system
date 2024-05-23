package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Announcement;
import com.team.oa_system.mapper.AnnouncementMapper;
import com.team.oa_system.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnnouncementImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public void add(Announcement announcement) {
        announcement.setPublish_time(LocalDate.now());
        announcementMapper.add(announcement);
    }

    @Override
    public void deleteById(Integer id) {
        announcementMapper.deleteById(id);
    }

    @Override
    public void review(Integer announcement_id, Integer approver_id, Integer status) {
        announcementMapper.review(announcement_id,approver_id,status);
    }

    @Override
    public List<Announcement> getAll() {
        //所有公告的列表
        List<Announcement> all = announcementMapper.getAll();
        return all;
    }

    //获得未审核公告
    @Override
    public List<Announcement> getNoReview() {
        List<Announcement> noReview = announcementMapper.getNoReview();
        return noReview;
    }

    //获得审核通过的公告
    @Override
    public List<Announcement> getPassList() {
        List<Announcement> passList = announcementMapper.getPassList();
        return passList;

    }
}
