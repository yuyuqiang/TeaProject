package me.zhangyu.service.impl;

import com.sun.deploy.net.HttpRequest;
import me.zhangyu.mapper.UserMapper;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.applet.Applet;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {


    @Override
    public Boolean login(String username, String password) {

        return true;
    }

    @Override
    public List<User> getUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public User get(User user) {
        System.out.println("++++++++++++++nihao");
        System.out.println("iiiiiiiiiiii"+user.getUsername().trim());
        if(!user.getUsername().equals("") && !user.getPassword().equals("")){
            return userMapper.selectUser(user);
    }
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public boolean deleteByNumber(String number) {
        return false;
    }

    @Override
    public User searchByNumber(String number) {
        return null;
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void insert(User user) {

    }
}
