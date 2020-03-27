package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Admin;
import me.zhangyu.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {


    int findTotalRecords();

    List<Teacher> findTeachersWithPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    void addTeacher(@Param(value = "teacher") Teacher teacher);

    void delTeacherById(@Param("id") String id);
}
