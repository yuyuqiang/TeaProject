package me.zhangyu.service.impl;

import me.zhangyu.model.Teacher;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.TeacherService;
import me.zhangyu.service.base.BaseServiceImpl;
import me.zhangyu.untils.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {


    @Override
    public Teacher findById(int id) {
        return null;
    }

    @Override
    public Teacher findByUsername(String username) {
        return null;
    }

    @Override
    public Teacher findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public void insert(Teacher teacher) {

    }

    @Override
    public Teacher validateUserExist(String username) {
        return null;
    }

    @Override
    public PageModel findTeachersWithPage(int currentNum)throws SQLException {
        //1_创建PageModel对象,计算分页参数
        int totalRecords=teacherMapper.findTotalRecords();
        PageModel pm=new PageModel(currentNum,totalRecords,5);
        //2_为PageModel对象设置集合(当前页中的老师信息)
        //select * from t_tea limit ? , ?
        List<Teacher> list=teacherMapper.findTeachersWithPage(pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        //3_为PageModel对象设置url
        pm.setUrl("teacher/teaInfo.do");
        return pm;
    }

    @Override
    public void addTeacher(Teacher teacher)throws SQLException {
        teacherMapper.addTeacher(teacher);

    }
}
