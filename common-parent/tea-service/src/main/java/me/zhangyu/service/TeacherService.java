package me.zhangyu.service;

import me.zhangyu.model.Admin;
import me.zhangyu.model.Homework;
import me.zhangyu.model.Teacher;
import me.zhangyu.service.base.IBaseService;
import me.zhangyu.untils.PageModel;

import java.sql.SQLException;
/*
业务层接口
 */

public interface TeacherService extends IBaseService<Teacher> {
    PageModel findTeachersWithPage(int currentNum) throws SQLException;

    void addTeacher(Teacher teacher) throws SQLException;

    void delTeacherById(String id) throws SQLException;


    void addHomework(Homework homework) throws SQLException;
}
