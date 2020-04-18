package me.zhangyu.service;

import me.zhangyu.model.Question;
import me.zhangyu.model.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectService {

     int add(Subject subject);
     int edit(Subject subject);
     List<Subject> findList(Map<String, Object> queryMap);
     int delete(Long id);
     Integer getTotal(Map<String, Object> queryMap);
     Subject findById(Long id);

}
