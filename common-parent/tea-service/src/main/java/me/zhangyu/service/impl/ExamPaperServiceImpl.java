package me.zhangyu.service.impl;


import me.zhangyu.model.Exam;
import me.zhangyu.model.ExamPaper;
import me.zhangyu.service.ExamPaperService;
import me.zhangyu.service.ExamService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExamPaperServiceImpl extends BaseServiceImpl<ExamPaper> implements ExamPaperService {


    @Override
    public ExamPaper findById(int id) {
        return null;
    }

    @Override
    public ExamPaper findByUsername(String username) {
        return null;
    }

    @Override
    public ExamPaper findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(ExamPaper examPaper) {

    }

    @Override
    public void insert(ExamPaper examPaper) {

    }

    @Override
    public ExamPaper validateUserExist(String username) {
        return null;
    }

    /*
    特有
     */
    @Override
    public int add(ExamPaper examPaper) {
        return examPaperMapper.add(examPaper);
    }

    @Override
    public int edit(ExamPaper examPaper) {
        return examPaperMapper.edit(examPaper);
    }

    @Override
    public List<ExamPaper> findList(Map<String, Object> queryMap) {
        return examPaperMapper.findList(queryMap);
    }

    @Override
    public int delete(Long id) {
        return examPaperMapper.delete(id);
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return examPaperMapper.getTotal(queryMap);
    }

    @Override
    public List<ExamPaper> findHistory(Map<String, Object> queryMap) {
        return examPaperMapper.findHistory(queryMap);
    }

    @Override
    public Integer getHistoryTotal(Map<String, Object> queryMap) {
        return examPaperMapper.getHistoryTotal(queryMap);
    }

    @Override
    public ExamPaper find(Map<String, Object> queryMap) {
        return examPaperMapper.find(queryMap);
    }

    @Override
    public int submitPaper(ExamPaper examPaper) {
        return examPaperMapper.submitPaper(examPaper);
    }

    @Override
    public List<Map<String, Object>> getExamStats(Long examId) {
        return examPaperMapper.getExamStats(examId);
    }
}
