package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper extends BaseMapper<Admin> {
      Admin adminLogin(@Param("um")String um, @Param("up")String up);

      Admin validateUserExist(@Param("username")String username);

//    List<Admin> getUser(@Param("param") Map map);
//
//    Admin selectUser(@Param("param") Admin admin);
//    Admin saveUser(@Param("param")Admin admin);
//
//    List<Admin> selectAllUser();
}
