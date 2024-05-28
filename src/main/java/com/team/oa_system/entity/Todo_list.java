package com.team.oa_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo_list {
    private Integer todo_id;//代办事项id
    private Integer employee_id;//员工id
    private String content;//内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime due_date;//截至日期

    private Integer is_completed;//是否完成，为0未完成，为1已完成

}
