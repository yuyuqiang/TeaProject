package me.zhangyu.service.impl;

import com.sun.deploy.net.HttpRequest;
import me.zhangyu.mapper.UserMapper;
import me.zhangyu.model.Homework;
import me.zhangyu.model.StudentHomework;
import me.zhangyu.model.StudentSubmitHomework;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.applet.Applet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    public List<Homework> findPrevHomework()throws SQLException {
        return userMapper.findPrevHomework();
    }

    @Override
    public Homework findHomeworkByid(String hId)throws SQLException {
        return userMapper.findHomeid(hId);

    }

    @Override
    public void submithomework(StudentSubmitHomework studentSubmitHomework,int h_id) {
        System.out.println("hahhahhahahahah");
        userMapper.submitHomework(studentSubmitHomework,h_id);
    }

    @Override
    public List<StudentHomework> findPreStudentHomework(int id) throws SQLException {
        return userMapper.findpreStudentHomework(id);
    }

    @Override
    public void updateStudentHomework(StudentHomework studentHomework,String h_name)throws   SQLException {
        userMapper.updateStudentHomework(studentHomework,h_name);
    }

    @Override
    public void updatesubmithomework(StudentSubmitHomework studentSubmitHomework, int h_id)throws SQLException {
        userMapper.updatesubmithomework(studentSubmitHomework,h_id);
    }

    @Override
    public StudentSubmitHomework findSubmitHomeworkByid(int h_id) {
        return userMapper.findSubmitHomeworkByid(h_id);
    }

    @Override
    public List<User> findList(Map<String, Object> queryMap) {
        return userMapper.findList(queryMap);
    }

    @Override
    public StudentSubmitHomework findSubmitHomeworkBySIdAndHId(int stu_id, int h_id) {
        return userMapper.findSubmitHomeworkBySIdAndHId(stu_id,h_id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public int add(User student) {
        return userMapper.add(student);
    }

    @Override
    public int edit(User student) {
        return userMapper.edit(student);
    }

    @Override
    public int delete(Long id) {
        return userMapper.delete(id);
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return userMapper.getTotal(queryMap);
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
    public User validateUserExist(String username) {
        //调用dao功能
        return userMapper.validateUserExist(username);
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
