package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Subject;
import me.zhangyu.service.ExamPaperService;
import me.zhangyu.service.ExamService;
import me.zhangyu.service.SubjectService;
import me.zhangyu.untils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建请求处理类
 */
@Controller
@EnableWebMvc
@RequestMapping("statis")
public class StatisController {

    @Autowired
    private ExamService examService;
    @Autowired
    private ExamPaperService examPaperService;
    /**
     * 成绩统计页面
     * @param model
     * @return
     */
    @RequestMapping(value="exam_stats",method=RequestMethod.GET)
    public ModelAndView stats(ModelAndView model){
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 99999);
        model.addObject("examList", examService.findList(queryMap));
        model.setViewName("exam/exam_statis");
        return model;
    }

    /**
     * 根据考试信息统计结果
     * @param examId
     * @return
     */
    @RequestMapping(value="get_stats",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getStats(Long examId){
        Map<String, Object> ret = new HashMap<String, Object>();
        if(examId == null){
            ret.put("type", "error");
            ret.put("msg", "选择要统计的考试信息！");
            return ret;
        }
        List<Map<String, Object>> examStats = examPaperService.getExamStats(examId);
        ret.put("type", "success");
        ret.put("msg", "统计成功！");
        ret.put("studentList", getListByMap(examStats, "sname"));
        ret.put("studentScore", getListByMap(examStats, "score"));
        return ret;
    }

    private List<Object> getListByMap(List<Map<String, Object>> mapList,String key){
        List<Object> ret = new ArrayList<Object>();
        for(Map<String, Object> map:mapList){
            ret.add(map.get(key));
        }
        return ret;
    }
}
