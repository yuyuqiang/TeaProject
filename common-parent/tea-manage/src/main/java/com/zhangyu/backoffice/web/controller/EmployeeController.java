package com.zhangyu.backoffice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @RequestMapping("manage")
    public String manage(){
        return "employee/manage";

    }

    @RequestMapping("info")
    public String info(){
        return "employee/info";

    }

    @RequestMapping("edit")
    public String edit(){
        return "employee/edit";

    }


}
