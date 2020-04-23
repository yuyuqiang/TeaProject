package com.zhangyu.backoffice.web.controller.base;

import org.omg.CORBA.PUBLIC_MEMBER;
import sun.management.snmp.jvmmib.JvmOSMeta;

import java.lang.reflect.ParameterizedType;

public abstract class BaseController<T> {
    //===============页面 ================
    public static  String EDIT_PAGE;//添加编辑页面
    public static  String INFO_PAGE;//列表界面
    public static  String MANAGE_PAGE;//管理界面
    public static  String PERSONINFO_PAGE;//个人信息
    public static  String DEFAULT_PAGE;//后台首页
    public static  String ALOGIN_PAGE;//后台登录
    public static  String WELCOMEEXAM_PAGE;//测试首页
    public static  String EXAMMANAGE_PAGE;//测试首页

    public static final String MANAGE = "manage";
    public static final String INFO = "info";
    public static final String EDIT = "edit";
    public static final String PERSONINFO ="personInfo";
    public static final String DEFAULT = "Default";
    public static final String ALOGIN = "adminlogin";
    public static final String WELCOMEEXAM = "welcomeExam";
    public static final String EXAMMANAGE = "examManage";


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
    public static  String HOMEWORKPREV_PAGE;
    public static  String HOMEWORKDETAIL_PAGE;

    public static final String INDEX = "index";
    public static final String LOGIN ="userlogin";
    public static final String VEDIO="vedioPrev";
    public static final String VEDIOALL="vedioAll";
    public static final String VEDIODETAIL="vedioDetail";
    public static final String PLAYVEDIO="playVedio";
    public static final String VEDIOUPDOWN="vedioUpdown";
    public static final String HOMEWORKPREV="homeworkPrev";
    public static final String HOMEWORKDETAIL="homeworkDetail";

    //老师页面
    public static  String TEAINFO_PAGE;//老师信息
    public static  String TEAADD_PAGE;//添加老师
    public static  String TEAINDEX_PAGE;//老师首页
    public static  String TEAMANAGE_PAGE;
    public static  String VEDIOTEAPREV_PAGE;
    public static  String VEDIOADD_PAGE;
    public static  String PUBLISHHOMEWORK_PAGE;
    public static  String TEAMESSAGEMANAGE_PAGE;
    public static  String MYTEAINFO_PAGE;
    public static  String TEAHOMEWORKPREV_PAGE;
    public static  String CHECKHOMEWORK_PAGE;



    public static final String TEAINFO = "teaInfo";
    public static final String TEAADD = "teacherAdd";
    public static final String TEAINDEX = "teaIndex";
    public static final String TEAMANAGE = "teaManage";
    public static final String VEDIOTEAPREV = "vedioTeaPrev";
    public static final String VEDIOADD = "vedioAdd";
    public static final String PUBLISHHOMEWORK = "publishHomework";
    public static final String TEAMESSAGEMANAGE = "teaMessageManage";
    public static final String MYTEAINFO = "myTeaInfo";
    public static final String TEAHOMEWORKPREV = "teaHomeworkPrev";
    public static final String CHECKHOMEWORK = "checkHomework";

    //测试
    public static String QUESTIONLIST_PAGE;


    public static final String QUESTIONLIST = "questionList";


    //论坛
    public static String TEACOMMERNTS_PAGE;
    public static String CHAT_INDEX_PAGE;

    public static final String TEACOMMENTS = "teacomments";
    public static final String CHAT_INDEX = "index";



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
        String modelName2 = "teacher";
        String modelName3 = "question";
        String modelName4 = "chat";

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
        WELCOMEEXAM_PAGE = modelName1 + "/" +WELCOMEEXAM;
        EXAMMANAGE_PAGE = modelName1 + "/" +EXAMMANAGE;

        VEDIO_PAGE = modelName1 + "/"+VEDIO;
        VEDIOALL_PAGE = modelName1 + "/"+VEDIOALL;
        VEDIODETAIL_PAGE=modelName1+"/"+VEDIODETAIL;
        PLAYVEDIO_PAGE=modelName1+"/"+PLAYVEDIO;
        VEDIOUPDOWN_PAGE=modelName1+"/"+VEDIOUPDOWN;
        HOMEWORKPREV_PAGE= modelName1+"/"+ HOMEWORKPREV;
        HOMEWORKDETAIL_PAGE= modelName1+"/"+ HOMEWORKDETAIL;


        TEAINFO_PAGE = modelName2+"/"+TEAINFO;
        TEAADD_PAGE = modelName2+"/"+TEAADD;
        TEAINDEX_PAGE = modelName2+"/"+TEAINDEX;
        TEAMANAGE_PAGE= modelName2+"/"+TEAMANAGE;
        VEDIOTEAPREV_PAGE= modelName2+"/"+VEDIOTEAPREV;
        VEDIOADD_PAGE= modelName2+"/"+VEDIOADD;
        PUBLISHHOMEWORK_PAGE= modelName2+"/"+PUBLISHHOMEWORK;
        TEAMESSAGEMANAGE_PAGE= modelName2+"/"+TEAMESSAGEMANAGE;
        MYTEAINFO_PAGE= modelName2+"/"+MYTEAINFO;
        TEAHOMEWORKPREV_PAGE= modelName2+"/"+TEAHOMEWORKPREV;
        CHECKHOMEWORK_PAGE= modelName2+"/"+CHECKHOMEWORK;

        QUESTIONLIST_PAGE = modelName3+"/"+QUESTIONLIST;

        TEACOMMERNTS_PAGE = modelName2+"/"+TEACOMMENTS;

        CHAT_INDEX_PAGE = modelName4+"/"+CHAT_INDEX;

    }
}
