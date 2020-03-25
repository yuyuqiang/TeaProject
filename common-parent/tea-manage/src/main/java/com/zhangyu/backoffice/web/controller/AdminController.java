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
    public String login() {
        return ALOGIN_PAGE;
    }

    @RequestMapping(DEFAULT)
    public String index(HttpServletRequest request ,HttpServletResponse response)throws ServletException, IOException{
        String adminname_in=request.getParameter("username");
        String adminpsd_in =request.getParameter("password");
        System.out.println("adminname:"+adminname_in+"adminpsd:"+adminpsd_in);

        Admin admin = adminService.findByUsername(adminname_in);
        adminname = admin.getAdminname();
        adminpsd = admin.getPassword();
        System.out.println("data："+adminname+" "+adminpsd);
        if(!adminname.equals(adminname_in)){
//            response.getWriter().println("密码错误");
            return ALOGIN_PAGE;
        }
        else{
            return DEFAULT_PAGE;
        }
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
