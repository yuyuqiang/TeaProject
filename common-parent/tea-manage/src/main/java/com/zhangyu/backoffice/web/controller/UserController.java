package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 创建请求处理类
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService userService;
    public  static  int id;
    public  static String uname;
    public  static String upsd;

    //登录
    @RequestMapping( "login")
    public String login() {


        return "login";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request ,HttpServletResponse response)throws ServletException, IOException{
        String uname_in=request.getParameter("username");
        String upsd_in =request.getParameter("password");
        System.out.println("uname:"+uname_in+"upsd:"+upsd_in);

        User user = userService.findByUsername(uname_in);
        uname = user.getUsername();
        upsd = user.getPassword();
        System.out.println("data："+uname+" "+upsd);
        if(!upsd.equals(upsd_in)){
//            response.getWriter().println("密码错误");
            return "login";
        }
        else{
            return "Default";
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

    @RequestMapping("personInfo")
    public String personInfo(){
        System.out.println(".....");
        return "personInfo";
    }

    @RequestMapping("find")
    public String find(int id){
        System.out.println(".....");
        User user = userService.findById(id);
        System.out.println(user);
        return "Default";
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
