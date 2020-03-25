package me.zhangyu.service.impl;

import me.zhangyu.model.Admin;
import me.zhangyu.model.User;
import me.zhangyu.service.AdminService;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {


    @Override
    public Admin findById(int id) {
        return null;
    }

    @Override
    public Admin findByUsername(String username) {
        System.out.println("11111111111"+username);
        return adminMapper.findByUsername(username);
    }

    @Override
    public Admin findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(Admin admin) {

    }

    @Override
    public void insert(Admin admin) {

    }

    @Override
    public Admin validateUserExist(String username) {
        return null;
    }
}
