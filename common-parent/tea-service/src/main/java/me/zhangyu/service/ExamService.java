package me.zhangyu.service;


import me.zhangyu.model.Exam;

import java.util.List;
import java.util.Map;

public interface ExamService {

     int add(Exam exam);
     int edit(Exam exam);
     List<Exam> findList(Map<String, Object> queryMap);
     int delete(Long id);
     Integer getTotal(Map<String, Object> queryMap);
     List<Exam> findListByUser(Map<String, Object> queryMap);
     Integer getTotalByUser(Map<String, Object> queryMap);
     Exam findById(Long id);
     int updateExam(Exam exam);

}
