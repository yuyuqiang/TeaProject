package me.zhangyu.service.impl;


import me.zhangyu.model.Question;
import me.zhangyu.service.QuestionService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuestionServiceImpl extends BaseServiceImpl<Question> implements QuestionService {


    @Override
    public int add(Question question) {
        return questionMapper.add(question);
    }

    @Override
    public int edit(Question question) {
        return questionMapper.edit(question);
    }

    @Override
    public List<Question> findList(Map<String, Object> queryMap) {
        return questionMapper.findList(queryMap);
    }

    @Override
    public int delete(Long id) {
        return questionMapper.delete(id);    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return questionMapper.getTotal(queryMap);
    }

    @Override
    public Question findByTitle(String title) {
        return questionMapper.findByTitle(title);
    }

    @Override
    public int getQuestionNumByType(Map<String, Long> queryMap) {
        return questionMapper.getQuestionNumByType(queryMap);
    }

    @Override
    public Question findById(Long id) {
        return questionMapper.findById(id);
    }

    @Override
    public Question findById(int id) {
        return null;
    }

    @Override
    public Question findByUsername(String username) {
        return null;
    }

    @Override
    public Question findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(Question question) {

    }

    @Override
    public void insert(Question question) {

    }

    @Override
    public Question validateUserExist(String username) {
        return null;
    }
}
