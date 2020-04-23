package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Question;
import me.zhangyu.model.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SubjectMapper extends BaseMapper<Subject> {
        int add(Subject subject);
        int edit(Subject subject);
        List<Subject> findList(Map<String, Object> queryMap);
        int delete(Long id);
        Integer getTotal(Map<String, Object> queryMap);
        Subject findById(Long id);


}
