package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Exam;
import me.zhangyu.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ExamMapper extends BaseMapper<Exam> {


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
