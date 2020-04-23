package me.zhangyu.service;


import me.zhangyu.model.Exam;
import me.zhangyu.model.ExamPaper;

import java.util.List;
import java.util.Map;

public interface ExamPaperService {

     public int add(ExamPaper examPaper);
     public int edit(ExamPaper examPaper);
     public List<ExamPaper> findList(Map<String, Object> queryMap);
     public int delete(Long id);
     public Integer getTotal(Map<String, Object> queryMap);
     public List<ExamPaper> findHistory(Map<String, Object> queryMap);
     public Integer getHistoryTotal(Map<String, Object> queryMap);
     public ExamPaper find(Map<String, Object> queryMap);
     public int submitPaper(ExamPaper examPaper);
     public List<Map<String,Object>> getExamStats(Long examId);

}
