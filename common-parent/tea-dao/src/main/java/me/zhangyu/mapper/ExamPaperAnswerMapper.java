package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Exam;
import me.zhangyu.model.ExamPaperAnswer;

import java.util.List;
import java.util.Map;

public interface ExamPaperAnswerMapper extends BaseMapper<ExamPaperAnswer> {
    public int add(ExamPaperAnswer examPaperAnswer);
    public int edit(ExamPaperAnswer examPaperAnswer);
    public List<ExamPaperAnswer> findList(Map<String, Object> queryMap);
    public int delete(Long id);
    public Integer getTotal(Map<String, Object> queryMap);
    public List<ExamPaperAnswer> findListByUser(Map<String, Object> queryMap);
    public int submitAnswer(ExamPaperAnswer examPaperAnswer);



}
