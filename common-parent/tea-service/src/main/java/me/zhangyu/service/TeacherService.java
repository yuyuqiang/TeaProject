package me.zhangyu.service;

import me.zhangyu.model.*;
import me.zhangyu.service.base.IBaseService;
import me.zhangyu.untils.PageModel;

import java.sql.SQLException;
import java.util.List;
/*
业务层接口
 */

public interface TeacherService extends IBaseService<Teacher> {
    PageModel findTeachersWithPage(int currentNum) throws SQLException;

    void addTeacher(Teacher teacher) throws SQLException;

    void delTeacherById(String id) throws SQLException;


    void addHomework(Homework homework) throws SQLException;

    void addStudentHomework(StudentHomework studentHomework) throws SQLException;

    Teacher teacherLogin(String um, String up);

    void updateTeacher(Teacher t) throws SQLException;

    List<Homework> findPrevHomework(int t_id);

    List<StudentSubmitHomework> findSubmitHomework(String hid) throws SQLException;
}
