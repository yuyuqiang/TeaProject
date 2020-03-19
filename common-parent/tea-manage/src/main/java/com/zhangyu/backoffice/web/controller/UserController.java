package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 创建请求处理类
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService userService;
    public  static  int id;

//    @RequestMapping("login")
//    public String login(){
//        System.out.println(".....");
//        return "login";
//    }

    //登录
    @RequestMapping( "login")
    public String login(String username){

        User user = userService.findByUsername(username);
        System.out.println("pppppppppppppppppppp"+user);
//        if (userService.get(user) != null){
////            System.out.println(admin.getNumber());
////            System.out.println( adminService.getAdminByNumber(admin.getNumber()));
//
//            User user1 = userService.findById(user.getId());
//            id = user1.getId();
//           // 设置属性的名称及内容
//            session.setAttribute("id",user1.getId());
//            session.setAttribute("password",user1.getPassword().trim());
//            session.setAttribute("username",user1.getUsername().trim());
//            System.out.println("1234567889");
//            System.out.println("!!!!!!!!!!!!!!!!!!!!"+user1);
//
//            return "Default";
//        }else {
//            return "login";
//        }
        return "login";
    }

    @RequestMapping("index")
    public String index(){
        System.out.println(".....");

        return "Default";
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
