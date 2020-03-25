package me.zhangyu.service.impl;

import me.zhangyu.model.Teacher;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.TeacherService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
