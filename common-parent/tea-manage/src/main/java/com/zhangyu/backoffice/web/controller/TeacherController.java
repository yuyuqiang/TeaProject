package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Teacher;
import me.zhangyu.model.User;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 创建请求处理类
 */
@Controller
@RequestMapping("teacher")
public class TeacherController extends BaseController<Teacher> {

    @Autowired
    private TeacherService teacherService;


}
