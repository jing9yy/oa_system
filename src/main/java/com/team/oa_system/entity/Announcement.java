package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    private Integer announcement_id;//公告id
    private Integer initiator_id;//公告创建人
    private String content;//公告内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime publish_time;//创建时间
    private Integer approver_id;//审核人id
    private Integer status;//审核状态，为0待审核，为1拒绝通过，为2允许展示
    private String title;//公告标题
}
