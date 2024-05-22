package com.team.oa_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class announcement {
    private Integer announcement_id;//公告id
    private Integer initiator_id;//公告创建人
    private String content;//公告内容
    private LocalDate publish_time;//创建时间
    private Integer approver_id;//审核人id
    private Integer status;//审核状态，为0待审核，为1拒绝通过，为2允许展示
}