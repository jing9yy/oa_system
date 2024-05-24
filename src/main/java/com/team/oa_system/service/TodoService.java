package com.team.oa_system.service;

import com.team.oa_system.entity.Todo_list;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    //添加代办事项
    public void addTodo(Todo_list todo_list);

    //显示代办事项
    public List<Todo_list> showTodo();

    //修改代办事项是否完成
    public void updateTodo(Integer todo_id,Integer is_completed);

    //删除代办事项
    public void deleteTodoById(Integer id);
}
