package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.ExamPaper;
import me.zhangyu.model.ExamPaperAnswer;
import me.zhangyu.service.*;
import me.zhangyu.untils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;


/**
 * 创建请求处理类
 */
@Controller
@EnableWebMvc
@RequestMapping("exampaperanswer")
public class ExamPaperAnswerController extends BaseController<ExamPaperAnswer> {

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ExamService examService;
    @Autowired
    private QuestionService questionService;

    /**
     * 试卷答题列表页面
     * @param model
     * @return
     */
    @RequestMapping(value="list",method=RequestMethod.GET)
    public ModelAndView list(ModelAndView model){
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 99999);
        model.addObject("examList", examService.findList(queryMap));
        model.addObject("studentList", userService.findList(queryMap));
        model.addObject("questionList", questionService.findList(queryMap));
        model.setViewName("exam/examPaperAnswerList");
        return model;
    }

    /**
     * 模糊搜索分页显示列表查询
//     * @param name
     * @param page
     * @return
     */
    @RequestMapping(value="list",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(
            @RequestParam(name="examId",required=false) Long examId,
            @RequestParam(name="studentId",required=false) Long studentId,
            @RequestParam(name="questionId",required=false) Long questionId,
            Page page
    ){
        Map<String, Object> ret = new HashMap<String, Object>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        if(examId != null){
            queryMap.put("examId", examId);
        }
        if(studentId != null){
            queryMap.put("studentId", studentId);
        }
        if(questionId != null){
            queryMap.put("questionId", questionId);
        }
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        ret.put("rows", examPaperAnswerService.findList(queryMap));
        ret.put("total", examPaperAnswerService.getTotal(queryMap));
        return ret;
    }

}
