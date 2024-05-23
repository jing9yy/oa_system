package com.team.oa_system.mapper;

import com.team.oa_system.entity.Announcement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnnouncementMapper {
    //新增公告
    @Insert("insert into oa_system.announcement(initiator_id, content, publish_time, approver_id, status, title) value (#{initiator_id},#{content},#{publish_time},0,0,#{title})")
    public void add(Announcement announcement);

    //根据id删除公告
    @Delete("delete from oa_system.announcement where announcement_id = #{id}")
    public void deleteById(Integer id);

    //审核公告
    @Update("update oa_system.announcement set approver_id = #{approver_id},status=#{status} where announcement_id = #{announcement_id}")
    public void review(@Param("announcement_id") Integer announcement_id, @Param("approver_id") Integer approver_id,@Param("status") Integer status);

    //所有公告的列表
    @Select("select * from oa_system.announcement")
    public List<Announcement> getAll();

    //获得未审核公告
    @Select("select * from oa_system.announcement where status = 0")
    public  List<Announcement> getNoReview();

    //获得审核通过的公告
    @Select("select * from oa_system.announcement where status = 2")
    public  List<Announcement> getPassList();
}
