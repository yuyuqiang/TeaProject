package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("login")
    public String userlogin(HttpServletRequest request, HttpSession session, RedirectAttributes attributes)throws ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.validateUserExist(username);
        System.out.println("pppppppp"+user);
        if(null!=user && password.equals(user.getPassword())){
            session.setAttribute("user",user);
            System.out.println("1111111111");
            return INDEX_PAGE;
        }
        else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            System.out.println("mmmmmmmmmmmmmmmm");

        }
        return ULOGIN_PAGE;

    }

    @RequestMapping(INDEX)
    public String index(){
        return INDEX_PAGE;

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
        return UMANAGE_PAGE;

    }



    @RequestMapping(EDIT)
    public String edit(){
        return UEDIT_PAGE;

    }


}
