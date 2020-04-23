package me.zhangyu.service.impl;


import me.zhangyu.model.ExamPaperAnswer;
import me.zhangyu.model.Question;
import me.zhangyu.service.ExamPaperAnswerService;
import me.zhangyu.service.QuestionService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExamPaperAnswerServiceImpl extends BaseServiceImpl<ExamPaperAnswer> implements ExamPaperAnswerService {


    @Override
    public ExamPaperAnswer findById(int id) {
        return null;
    }

    @Override
    public ExamPaperAnswer findByUsername(String username) {
        return null;
    }

    @Override
    public ExamPaperAnswer findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(ExamPaperAnswer examPaperAnswer) {

    }

    @Override
    public void insert(ExamPaperAnswer examPaperAnswer) {

    }

    @Override
    public ExamPaperAnswer validateUserExist(String username) {
        return null;
    }
/*
特有
 */
    @Override
    public int add(ExamPaperAnswer examPaperAnswer) {
        return examPaperAnswerMapper.add(examPaperAnswer);
    }

    @Override
    public int edit(ExamPaperAnswer examPaperAnswer) {
        return examPaperAnswerMapper.edit(examPaperAnswer);
    }

    @Override
    public List<ExamPaperAnswer> findList(Map<String, Object> queryMap) {
        return examPaperAnswerMapper.findList(queryMap);
    }

    @Override
    public int delete(Long id) {
        return examPaperAnswerMapper.delete(id);
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return examPaperAnswerMapper.getTotal(queryMap);
    }

    @Override
    public List<ExamPaperAnswer> findListByUser(Map<String, Object> queryMap) {
        return examPaperAnswerMapper.findListByUser(queryMap);
    }

    @Override
    public int submitAnswer(ExamPaperAnswer examPaperAnswer) {
        return examPaperAnswerMapper.submitAnswer(examPaperAnswer);
    }
}
