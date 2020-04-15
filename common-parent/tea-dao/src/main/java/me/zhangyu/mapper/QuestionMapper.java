package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QuestionMapper extends BaseMapper<Question> {
       int add(@Param("qu") Question question);
       int edit(Question question);
       List<Question> findList(Map<String, Object> queryMap);
       int delete(Long id);
       Integer getTotal(Map<String, Object> queryMap);
       Question findByTitle(String title);
       int getQuestionNumByType(Map<String, Long> queryMap);
       Question findById(Long id);

}
