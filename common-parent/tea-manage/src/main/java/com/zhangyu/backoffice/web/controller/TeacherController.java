package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Homework;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

        response.sendRedirect("teaInfo.do?num=1");
        return null;
    }

    @RequestMapping("delTeacher")
    public String delTeacherById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取待删除老师的编号
        String id= request.getParameter("id");
        //调用业务层删除老师功能
        System.out.println("delid:"+id);
        teacherService.delTeacherById(id);

        //重定向到/TeacherServlet?method=findTeachersWithPage
        response.sendRedirect("teaInfo.do?num=1");
        return null;
    }

    /**
     * 老师发布作业
     * */
    @RequestMapping("publishHomework")
    public String teacherPublishHomeworkInformation(HttpServletResponse response,HttpSession session,HttpServletRequest request) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Date time=null;
        Timestamp startTime=null;
        Timestamp endTime=null;
        String H_name = request.getParameter("H_name");
        String H_startTime = request.getParameter("H_startTime");
        String H_endTime = request.getParameter("H_endTime");
        String H_content = request.getParameter("H_content");
        System.out.println("作业："+H_name+H_startTime+H_endTime+H_content);
        try {
            // 说明：//将字符串转换成时间 将C#时间戳，格式为：/Date(-62135596800000)，转换为js时间。
            time = dateFormat.parse(H_startTime.replace('T', ' '));
            startTime = new Timestamp(time.getTime());
            time = dateFormat.parse(H_endTime.replace('T', ' '));
            endTime = new Timestamp(time.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Homework homework=new Homework();
        Date now = new Date();
        DateFormat dateFormat2 = new SimpleDateFormat("dd HH:mm:ss", Locale.ENGLISH);

        homework.setH_startTime(startTime);
        homework.setH_endTime(endTime);
        homework.setH_name(H_name);
        homework.setH_content(H_content);
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        teacherService.addHomework(homework);
//        teacherCommodityHomework.setH_ID(Integer.parseInt(H_ID));
//        if(teacherCommodityHomeworkService.addTeacherCommodityHomework(teacherCommodityHomework)>0){
//            session.removeAttribute("userinfor");
//            Teacher teacher = teacherService.queryTeacherById(teacher_id);
//            session.setAttribute("userinfor", teacher);
//            out.print("<script>alert('发布成功');window.location='/test5/teacherIndex.action'</script>");
//            out.flush();
//            out.close();
//        }else{
//            out.print("<script>alert('发布出现问题，发布失败');window.location='/test5/teacherIndex.action'</script>");
//            out.flush();
//            out.close();
//        }
        return null;
    }

    @RequestMapping("publishHomeworkUI")
    public String teacherPublishHomework(){
        return PUBLISHHOMEWORK_PAGE;
    }


    @RequestMapping("teaLogin")
    public String index(){
        return TEAINDEX_PAGE;
    }
    @RequestMapping(TEAMANAGE)
    public String teaManage(){
        return TEAMANAGE_PAGE;
    }


}
