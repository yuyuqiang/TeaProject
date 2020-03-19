package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    List<User> getUser(@Param("param") Map map);

    User selectUser(@Param("param") User user);
    User saveUser(@Param("param")User user);

    List<User> selectAllUser();




}
