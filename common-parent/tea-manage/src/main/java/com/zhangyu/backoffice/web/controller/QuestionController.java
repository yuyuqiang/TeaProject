package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Question;
import me.zhangyu.service.AdminService;
import me.zhangyu.service.QuestionService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建请求处理类
 */
@Controller
@EnableWebMvc
@RequestMapping("question")
public class QuestionController extends BaseController<Question> {

    @Autowired
    private QuestionService questionService;


    /**
     * 试题列表页面
     * @param model
     * @return
     */
    @RequestMapping(value="questionList",method= RequestMethod.GET)
    public ModelAndView list(ModelAndView model){
         model.setViewName("question/questionList");
         return model;
    }

    /**
     * 模糊搜索分页显示列表查询
     * @param title
     * @param page
     * @return
     */
    @RequestMapping(value="questionList",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(
            @RequestParam(name="title",defaultValue="") String title,
            @RequestParam(name="questionType",required=false) Integer questionType,
            Page page
    ){
        Map<String, Object> ret = new HashMap<String, Object>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("title", title);
        if(questionType != null){
            queryMap.put("questionType", questionType);
        }
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        ret.put("rows", questionService.findList(queryMap));
        ret.put("total", questionService.getTotal(queryMap));
        return ret;
    }

    /**
     * 添加试题
     * @param question
     * @return
     *
     */
    @RequestMapping(value="add",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(Question question){
        Map<String, String> ret = new HashMap<String, String>();
        if(question == null){
            ret.put("type", "error");
            ret.put("msg", "请填写正确的试题信息!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getTitle())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题题目lll!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getAnswer())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题正确答案!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getAttrA())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题选项A!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getAttrB())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题选项B!");
            return ret;
        }
        question.setCreateTime(new Date());
        System.out.println("kkkkkkkkkllllllll");
        if(questionService.add(question) <= 0){
            ret.put("type", "error");
            ret.put("msg", "添加失败，请联系管理员!");
            return ret;
        }
        System.out.println("llllllllllllllllll");
        ret.put("type", "success");
        ret.put("msg", "添加成功!");
        return ret;
    }

    /**
     * 编辑试题
     * @param question
     * @return
     */
    @RequestMapping(value="edit",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(Question question){
        Map<String, String> ret = new HashMap<String, String>();
        if(question == null){
            ret.put("type", "error");
            ret.put("msg", "请填写正确的试题信息!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getTitle())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题题目!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getAnswer())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题正确答案!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getAttrA())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题选项A!");
            return ret;
        }
        if(StringUtils.isEmpty(question.getAttrB())){
            ret.put("type", "error");
            ret.put("msg", "请填写试题选项B!");
            return ret;
        }
        if(questionService.edit(question) <= 0){
            ret.put("type", "error");
            ret.put("msg", "编辑失败，请联系管理员!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "编辑成功!");
        return ret;
    }

    /**
     * 删除试题
     * @param id
     * @return
     */
    @RequestMapping(value="delete",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(Long id){
        Map<String, String> ret = new HashMap<String, String>();
        if(id == null){
            ret.put("type", "error");
            ret.put("msg", "请选择要删除的数据!");
            return ret;
        }
        try {
            if(questionService.delete(id) <= 0){
                ret.put("type", "error");
                ret.put("msg", "删除失败，请联系管理员!");
                return ret;
            }
        } catch (Exception e) {
            // TODO: handle exception
            ret.put("type", "error");
            ret.put("msg", "该试题下存在考试信息，不能删除!");
            return ret;
        }

        ret.put("type", "success");
        ret.put("msg", "删除成功!");
        return ret;
    }

}
