package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Homework;
import me.zhangyu.model.StudentHomework;
import me.zhangyu.model.StudentSubmitHomework;
import me.zhangyu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    List<User> getUser(@Param("param") Map map);

    User selectUser(@Param("param") User user);
    User saveUser(@Param("param")User user);

    List<User> selectAllUser();

    User validateUserExist(String username);


    List<Homework> findPrevHomework();

    Homework findHomeid(@Param("hId") String hId);

    void submitHomework(@Param("ssh") StudentSubmitHomework studentSubmitHomework,@Param("h_id")int h_id);

    List<StudentHomework> findpreStudentHomework();

    void updateStudentHomework(@Param("sh") StudentHomework studentHomework,@Param("h_name") String h_name);

    void updatesubmithomework(@Param("upssh") StudentSubmitHomework studentSubmitHomework,@Param("h_id") int h_id);

    StudentSubmitHomework findSubmitHomeworkByid(@Param("h_id") int h_id);
}
