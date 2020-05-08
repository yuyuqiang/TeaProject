package me.zhangyu.service;

import me.zhangyu.model.*;
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

    List<StudentHomework> findPreStudentHomework(int id) throws SQLException;

    void updateStudentHomework(StudentHomework studentHomework,String h_name) throws SQLException;

    void updatesubmithomework(StudentSubmitHomework studentSubmitHomework, int h_id) throws SQLException;

    StudentSubmitHomework findSubmitHomeworkByid(int h_id);

    public List<User> findList(Map<String, Object> queryMap);

    StudentSubmitHomework findSubmitHomeworkBySIdAndHId(int stu_id, int h_id);
    public User findByName(String name);

    public int add(User student);
    public int edit(User student);
    public int delete(Long id);
    public Integer getTotal(Map<String, Object> queryMap);

    List<Notice> findNoticeList();

    Notice findNoticeByid(int id);
}
