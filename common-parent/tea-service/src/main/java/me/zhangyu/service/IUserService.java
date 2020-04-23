package me.zhangyu.service;

import me.zhangyu.model.Homework;
import me.zhangyu.model.StudentHomework;
import me.zhangyu.model.StudentSubmitHomework;
import me.zhangyu.model.User;
import me.zhangyu.service.base.IBaseService;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/*
业务层接口
 */

public interface IUserService extends IBaseService<User> {
    //特有
    public Boolean login(String username, String password);
    List<User> getUser(int id);
    List<User> selectAllUser();
    User get(User user);
    User saveUser(User user);
    boolean deleteByNumber(String number);
    User searchByNumber(String number);

    List<Homework> findPrevHomework() throws SQLException;

    Homework findHomeworkByid(String hId) throws SQLException;


    void submithomework(StudentSubmitHomework studentSubmitHomework,int h_id);

    List<StudentHomework> findPreStudentHomework() throws SQLException;

    void updateStudentHomework(StudentHomework studentHomework,String h_name) throws SQLException;

    void updatesubmithomework(StudentSubmitHomework studentSubmitHomework, int h_id) throws SQLException;

    StudentSubmitHomework findSubmitHomeworkByid(int h_id);

    public List<User> findList(Map<String, Object> queryMap);
}
