package com.team.oa_system.controller;

import com.team.oa_system.entity.Result;
import com.team.oa_system.entity.Todo_list;
import com.team.oa_system.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    //添加代办事项
    @PostMapping("/addTodo")
    public Result addTodo(@RequestBody Todo_list todo_list){
        todoService.addTodo(todo_list);
        return Result.success("添加成功");
    }

    //显示代办事项
    @GetMapping("/showTodo")
    public Result showTodo(){
        List<Todo_list> todoLists = todoService.showTodo();
        return Result.success(todoLists);
    }

    //修改代办事项是否完成
    @PutMapping("/updateTodo/{todo_id}/{is_completed}")
    public Result updateTodo(@PathVariable Integer todo_id,@PathVariable Integer is_completed){
        todoService.updateTodo(todo_id,is_completed);
        return Result.success();
    }

    //删除代办事项
    @DeleteMapping("/deleteTodo/{id}")
    public Result deleteTodoById(@PathVariable Integer id){
        todoService.deleteTodoById(id);
        return Result.success();
    }
}
