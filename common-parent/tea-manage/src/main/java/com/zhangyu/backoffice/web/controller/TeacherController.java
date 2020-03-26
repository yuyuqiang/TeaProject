package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Teacher;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.TeacherService;
import me.zhangyu.untils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 创建请求处理类
 */
@Controller
@RequestMapping("teacher")
public class TeacherController extends BaseController<Teacher> {

    @Autowired
    private TeacherService teacherService;


    @RequestMapping("teaInfo")
    //findTeachersWithPage
    public String findTeachersWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前页
        int currentNum=Integer.parseInt(request.getParameter("num"));
        //调用业务层功能，返回PageModel对象
        PageModel pm=teacherService.findTeachersWithPage(currentNum);
        //将PageModel对象放入request
        request.setAttribute("page", pm);
        //转发到jsp
        return TEAINFO_PAGE;
    }

    @RequestMapping("teacherAddUI")
    public String teaADD(){
        return TEAADD_PAGE;
    }

    //addTeacher
    @RequestMapping("addTeacher")
    public String addTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接受参数
        String teaNum=request.getParameter("teaNum");
        String teaRealName=request.getParameter("teaRealName");
        String teaSex=request.getParameter("teaSex");
        String teaAge=request.getParameter("teaAge");
        String loginName=request.getParameter("loginName");
        String loginPwd=request.getParameter("loginPwd");
        System.out.println("hhhhhhhhhh"+teaNum);
        Teacher teacher=new Teacher();
        teacher.setTeaNum(teaNum);
        teacher.setTeaRealName(teaRealName);
        teacher.setTeaSex(teaSex);
        teacher.setTeaAge(teaAge);
        teacher.setLoginName(loginName);
        teacher.setLoginPwd(loginPwd);
        //调用业务层添加老师功能
        teacherService.addTeacher(teacher);
        //重定向到查询老师信息功能
        response.sendRedirect("teacher/teaInfo.do?num=1");
        return null;
    }


}
