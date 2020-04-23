package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.ExamPaper;

import java.util.List;
import java.util.Map;


public interface ExamPaperMapper extends BaseMapper<ExamPaperMapper> {

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
