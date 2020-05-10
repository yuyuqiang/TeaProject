package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {


    int findTotalRecords();

    List<Teacher> findTeachersWithPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    void addTeacher(@Param(value = "teacher") Teacher teacher);

    void delTeacherById(@Param("id") String id);

    void addHomework(@Param(value = "homework")Homework homework);

    void addStudentHomework(@Param("sh") StudentHomework studentHomework);

    Teacher teaLogin(@Param("um") String um, @Param("up") String up);

    void updateTeacher(@Param("teacher") Teacher t);

    List<Homework> findPrevHomework(@Param("t_id") int t_id);

    List<StudentSubmitHomework> findSubmitHomework(@Param("hid") String hid);

    StudentSubmitHomework findSubmitHomeworkByid(@Param("id") String id);

    StudentSubmitHomework updateStudentGrade(@Param("upshg") StudentSubmitHomework studentSubmitHomework,@Param("id") int id);

    void updateStudentHomeworkGrade(@Param("upsh") StudentHomework studentHomework, @Param("hid") int hid, @Param("sid") int sid);

    String[] findStudentByclass();

    void publishNotice(@Param("notice") Notice notice);

    List<StudentSubmitHomework> findSubmitHomework1(String hid);
}
