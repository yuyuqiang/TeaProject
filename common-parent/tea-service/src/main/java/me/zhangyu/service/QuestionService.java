package me.zhangyu.service;

import me.zhangyu.model.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    int add(Question question);
    int edit(Question question);
    List<Question> findList(Map<String, Object> queryMap);
    int delete(Long id);
    Integer getTotal(Map<String, Object> queryMap);
    Question findByTitle(String title);
    int getQuestionNumByType(Map<String, Long> queryMap);
    Question findById(Long id);
}
