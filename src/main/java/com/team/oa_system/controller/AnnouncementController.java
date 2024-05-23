package com.team.oa_system.controller;

import com.team.oa_system.entity.Announcement;
import com.team.oa_system.entity.Result;
import com.team.oa_system.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    //新增公告
    @PostMapping("/addAnno")
    public Result add(@RequestBody Announcement announcement){
        announcementService.add(announcement);
        return Result.success("添加成功");
    }

    //删除公告
    @DeleteMapping("/deleteAnno/{id}")
    public Result deleteById(@PathVariable Integer id){
        announcementService.deleteById(id);
        return Result.success("删除成功");
    }

    //审核公告
    @PutMapping("/review/{announcement_id}/{approver_id}/{status}")
    public Result review(@PathVariable Integer announcement_id,@PathVariable Integer approver_id,@PathVariable Integer status){
            announcementService.review(announcement_id,approver_id,status);
            return Result.success();
    }

    //获得全部公告
    @GetMapping("/annoList")
    public Result getAll(){
        List<Announcement> all = announcementService.getAll();
        return Result.success(all);
    }

    //获得未审核公告
    @GetMapping("/noReview")
    public Result getNoReview(){
        List<Announcement> noReview = announcementService.getNoReview();
        return Result.success(noReview);

    }

    //获得审核通过的公告
    @GetMapping("/getPassList")
    public Result getPassList(){
        List<Announcement> passList = announcementService.getPassList();
        return Result.success(passList);
    }


}
