package com.zhangyu.backoffice.web.controller.base;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.ParameterizedType;

public abstract class BaseController<T> {
    //===============页面 ================
    public static  String EDIT_PAGE;//添加编辑页面
    public static  String INFO_PAGE;//列表界面
    public static  String MANAGE_PAGE;//管理界面
    public static  String PERSONINFO_PAGE;//个人信息
    public static  String DEFAULT_PAGE;//后台首页
    public static  String ALOGIN_PAGE;//后台登录

    public static final String MANAGE = "manage";
    public static final String INFO = "info";
    public static final String EDIT = "edit";
    public static final String PERSONINFO ="personInfo";
    public static final String DEFAULT = "Default";
    public static final String ALOGIN = "adminlogin";

    public static  String INDEX_PAGE;//首页
    public static  String ULOGIN_PAGE;//登录
    public static  String UEDIT_PAGE;//添加编辑页面
    public static  String UMANAGE_PAGE;//管理界面

    /*
    视频
     */
    public static  String VEDIO_PAGE;//视屏界面
    public static  String VEDIOALL_PAGE;//所有视频
    public static  String VEDIODETAIL_PAGE;
    public static  String PLAYVEDIO_PAGE;
    public static  String VEDIOUPDOWN_PAGE;

    public static final String INDEX = "index";
    public static final String LOGIN ="userlogin";
    public static final String VEDIO="vedioPrev";
    public static final String VEDIOALL="vedioAll";
    public static final String VEDIODETAIL="vedioDetail";
    public static final String PLAYVEDIO="playVedio";
    public static final String VEDIOUPDOWN="vedioUpdown";





    public BaseController(){

//            //1.获取泛型真实类型
//            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//        System.out.println("===="+ type);
//            //2.把type类型赋值给Class类型
//            Class<?> modelClass = (Class<?>) type.getActualTypeArguments()[0];
//        System.out.println("===="+modelClass);
//            //3.定义页面的静态变量
//            String modelName = modelClass.getSimpleName().toLowerCase();
            String modelName = "admin";
            String modelName1 = "user";
            EDIT_PAGE = modelName + "/" + EDIT;
            INFO_PAGE = modelName + "/"+INFO;
            MANAGE_PAGE = modelName + "/" + MANAGE;
            PERSONINFO_PAGE=modelName+"/"+ PERSONINFO;
            DEFAULT_PAGE = modelName+"/"+DEFAULT;
            ALOGIN_PAGE = modelName+ "/"+ALOGIN;

            INDEX_PAGE = modelName1+"/"+INDEX;
            ULOGIN_PAGE = modelName1+"/"+LOGIN;
            UEDIT_PAGE = modelName1 + "/" + EDIT;
            UMANAGE_PAGE = modelName1 + "/" + MANAGE;

            VEDIO_PAGE = modelName1 + "/"+VEDIO;
            VEDIOALL_PAGE = modelName1 + "/"+VEDIOALL;
            VEDIODETAIL_PAGE=modelName1+"/"+VEDIODETAIL;
            PLAYVEDIO_PAGE=modelName1+"/"+PLAYVEDIO;
            VEDIOUPDOWN_PAGE=modelName1+"/"+VEDIOUPDOWN;



    }
}
