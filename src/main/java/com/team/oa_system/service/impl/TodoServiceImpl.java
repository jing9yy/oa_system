package com.team.oa_system.service.impl;

import com.team.oa_system.entity.Todo_list;
import com.team.oa_system.mapper.TodoMapper;
import com.team.oa_system.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoMapper todoMapper;

    //添加代办事项
    @Override
    public void addTodo(Todo_list todo_list) {
        todoMapper.addTodo(todo_list);
    }

    //显示代办事项
    @Override
    public List<Todo_list> showTodo() {
        List<Todo_list> todoLists = todoMapper.showTodo();
        return todoLists;
    }

    //修改代办事项是否完成
    @Override
    public void updateTodo(Integer todo_id, Integer is_completed) {
        todoMapper.updateTodo(todo_id,is_completed);
    }

    //删除代办事项
    @Override
    public void deleteTodoById(Integer id) {
        todoMapper.deleteTodoById(id);
    }
}
