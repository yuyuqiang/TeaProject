package me.zhangyu.service;

import me.zhangyu.model.Admin;
import me.zhangyu.model.User;
import me.zhangyu.service.base.IBaseService;

import java.sql.SQLException;
import java.util.List;
/*
业务层接口
 */

public interface AdminService extends IBaseService<Admin> {
    Admin adminLogin(String um, String up)throws SQLException;
    //特有


}
