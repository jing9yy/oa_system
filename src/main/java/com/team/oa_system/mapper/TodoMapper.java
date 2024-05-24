package com.team.oa_system.mapper;

import com.team.oa_system.entity.Todo_list;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {
    //添加代办事项
    @Insert("insert into oa_system.todo_list(employee_id, content, due_date, is_completed) value (#{employee_id},#{content},#{due_date},0)")
    public void addTodo(Todo_list todo_list);

    //显示代办事项
    @Select("select * from oa_system.todo_list")
    public List<Todo_list> showTodo();

    //修改代办事项是否完成
    @Update("update oa_system.todo_list set is_completed = #{is_completed} where todo_id = #{todo_id}")
    public void updateTodo(@Param("todo_id") Integer todo_id,@Param("is_completed") Integer is_completed);

    //删除代办事项
    @Delete("delete from oa_system.todo_list where todo_id = #{id}")
    public void deleteTodoById(Integer id);
}
