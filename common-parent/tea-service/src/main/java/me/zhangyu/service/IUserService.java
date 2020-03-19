package me.zhangyu.service;

import me.zhangyu.model.User;
import me.zhangyu.service.base.IBaseService;

import java.util.List;
/*
业务层接口
 */

public interface IUserService extends IBaseService<User> {
    //特有
    public User login(String username, String password);
    List<User> getUser(int id);
    List<User> selectAllUser();
    User get(User user);
    User saveUser(User user);
    boolean deleteByNumber(String number);
    User searchByNumber(String number);
}
