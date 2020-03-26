package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Admin;
import me.zhangyu.model.User;
import me.zhangyu.service.AdminService;
import me.zhangyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建请求处理类
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController<User> {

    @Autowired
    private AdminService adminService;

    public  static  int id;
    public  static String adminname;
    public  static String adminpsd;

    //登录
    @RequestMapping( "login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //获取到页面提交到服务端的数据学号
//        String um=request.getParameter("username");
//        //调用业务层功能：验证用户是否已经存在，返回学生对象
//        Admin admin=adminService.validateUserExist(um);
//        //根据返回的学生是否为空判断仓库中是否有已经存在的账户
//        if(null==admin) {
//            //仓库中不存在当前学号
//            response.setCharacterEncoding("GB2312");
//            response.getWriter().print("no");
//
//        }else {
//            //仓库中存在当前学号
//            response.getWriter().print("yes");
//        }
//        //由于本次功能是由ajax发起的，不需要进行转发
//        return null;
        return ALOGIN_PAGE;
    }

    @RequestMapping( "adminLogin")
    public String successLogin(HttpServletRequest request, HttpServletResponse response)throws Exception {

        //获取 学号
        String um=request.getParameter("username");
        //获取 密码
        String up=request.getParameter("password");
        //调用业务层登录功能，返回学生对象
        Admin admin = adminService.adminLogin(um,up);;
        if(null!=admin) {
            //如果返回的学生不为空，说明登录成功，向session中放入学生信息 ,重定向到/site/index.jsp
            request.getSession().setAttribute("admin",admin);
            response.sendRedirect("Default.do");
            return null;
        }else {
            //如果返回的学生空，说明登录失败，向request域对象放入提示信息，转发到/site/index.jsp
            request.setAttribute("msg", "密码有误");
            return ALOGIN_PAGE;
        }

    }



//
//    @RequestMapping(DEFAULT)
//    public String index(HttpServletRequest request ,HttpServletResponse response)throws ServletException, IOException{
//        String adminname_in=request.getParameter("username");
//        String adminpsd_in =request.getParameter("password");
//        System.out.println("adminname:"+adminname_in+"adminpsd:"+adminpsd_in);
//
//        Admin admin = adminService.findByUsername(adminname_in);
//        adminname = admin.getAdminname();
//        adminpsd = admin.getPassword();
//        System.out.println("data："+adminname+" "+adminpsd);
//        if(!adminname.equals(adminname_in) || !adminpsd.equals(adminpsd_in)){
////            response.getWriter().println("密码错误");
//            return ALOGIN_PAGE;
//        }
//        else {
//            return DEFAULT_PAGE;
//        }
//
//    }

    @RequestMapping("Default")
    public String index(){
        System.out.println(".....");
        return DEFAULT_PAGE;
    }
    @RequestMapping("page404")
    public String page404(){
        System.out.println(".....");
        return "page404";
    }
    @RequestMapping("main")
    public String main(){
        System.out.println(".....");
        return "main";
    }

    @RequestMapping(PERSONINFO)
    public String personInfo(){
        System.out.println(".....");
        return PERSONINFO_PAGE;
    }

    @RequestMapping(MANAGE)
    public String manage(){
        return MANAGE_PAGE;

    }

    @RequestMapping(INFO)
    public String info(){
        return INFO_PAGE;

    }

    @RequestMapping(EDIT)
    public String edit(){
        return EDIT_PAGE;

    }


}
