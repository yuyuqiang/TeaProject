package com.zhangyu.backoffice.web.controller.base;

import java.lang.reflect.ParameterizedType;

public abstract class BaseController<T> {
    //===============页面 ================
    public static  String EDIT_PAGE;//添加编辑页面
    public static  String INFO_PAGE;//列表界面
    public static  String MANAGE_PAGE;//管理界面
    public static  String PERSONINFO_PAGE;//个人信息
    public static  String DEFAULT_PAGE;//后台首页

    public static final String MANAGE = "manage";
    public static final String INFO = "info";
    public static final String EDIT = "edit";
    public static final String PERSONINFO ="personInfo";
    public static final String DEFAULT = "Default";



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
            EDIT_PAGE = modelName + "/" + EDIT;
            INFO_PAGE = modelName + "/"+INFO;
            MANAGE_PAGE = modelName + "/" + MANAGE;
            PERSONINFO_PAGE=modelName+"/"+ PERSONINFO;
            DEFAULT_PAGE = modelName+"/"+DEFAULT;

    }
}
