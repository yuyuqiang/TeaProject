package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.*;
import me.zhangyu.service.*;
import me.zhangyu.untils.DateFormatUtil;
import me.zhangyu.untils.DownLoadUtils;
import me.zhangyu.untils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 创建请求处理类
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService userService;

    @Autowired
    private ExamService examService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ExamPaperService examPaperService;

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;
    public  static  int id;
    public  static String uname;
    public  static String upsd;
    public static User user ;
    public static Homework homework;
    public static StudentSubmitHomework studentSubmitHomework;
    private String dirPath = "E:\\TeachingWebsite";
    private int pageSize = 10;

    @RequestMapping("login")
    public String userlogin(HttpServletRequest request, HttpSession session, RedirectAttributes attributes)throws ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user = userService.validateUserExist(username);
        System.out.println("pppppppp"+user);
        if(null!=user && password.equals(user.getPassword())){
            session.setAttribute("user",user);
            return INDEX_PAGE;
        }
        else {
            attributes.addFlashAttribute("message","用户名或密码错误");

        }
        return ULOGIN_PAGE;

    }


    @RequestMapping("homeworkPrev")
    public String findPrevhomework(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(user==null){
            response.sendRedirect("page404.do");
        }
        int subjectId = user.getSubjectId();
        List<StudentHomework> list= userService.findPreStudentHomework(subjectId);
        request.setAttribute("list", list);
        request.setAttribute("nowTime",System.currentTimeMillis());
        System.out.println("lll"+System.currentTimeMillis());
        return HOMEWORKPREV_PAGE;
    }


    @RequestMapping("homeworkDetail")
    public String homeworkDetail(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //获取视频ID参数
        String h_name=request.getParameter("h_name");
        //调用业务层功能：根据视频ID查询对应的视频对象
        homework=userService.findHomeworkByid(h_name);
        //将查询到的视频对象放入request
        request.setAttribute("hw", homework);
        request.setAttribute("nowTime",System.currentTimeMillis());
        //转发到/site/vedio/vedioDtail.jsp
        return HOMEWORKDETAIL_PAGE;
    }


    /*
          学生提交作业
     */
    @RequestMapping("submitHomework")
    public String submitHomework(HttpServletRequest request, HttpServletResponse response)throws Exception{
        int h_id = homework.getH_id();
        int stu_id=user.getId();
        String h_name = homework.getH_name();
        String value =null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        if (System.currentTimeMillis()<homework.getH_endTime().getTime()){
            Map<String,String> map=new HashMap<String,String>();//携带表单名称以及表单参数
            //携带studentSubmitHomework数据，向 service,dao进行传递
            studentSubmitHomework = new StudentSubmitHomework();
            StudentHomework studentHomework = new StudentHomework();

            //1_创建DiskFiletemFactory对象设置允许上传文件大小
            DiskFileItemFactory fac=new DiskFileItemFactory();
            fac.setSizeThreshold(1024*1024*200); //允许上传文件的最大为200MB
            //2_创建ServletFileUpload upload
            ServletFileUpload upload=new ServletFileUpload(fac);
            //3_通过upload解析request,得到集合<FileItem>
            // FileItem代表什么？工具就将请求体中每对分割线中间的内容封装为一个FileItem对象
            List<FileItem> list=upload.parseRequest(request);


            for (FileItem item : list) {
                //5_判断当前FileItem是普通项还是上传项？
                //什么是普通项：表单中的普通字段，非上传字段
                //什么是上传项：表单中包含file组件上传项，携带着上传到服务端文件
                //item.isFormField()  ;;判断当前的item是否是表单项目
                if(item.isFormField()) {
                    //普通项
                    //如果是普通项：获取到对应的表单名称和表单内容     Eg: vedioName<__>333333333
                    String name=item.getFieldName();
                    value=item.getString("UTF-8");
                    System.out.println("lllllllllllll"+name);
                    System.out.println("mmmmmmmmmmmmmmm"+value);
                    map.put(item.getFieldName(), item.getString());
                }else {
                    //如果是上传项：在服务端指定目录/upload/ 创建一个文件，将上传项中文件的二进制数据输出到创建好的文件中
                    //获取到文件名称
                    String fName=item.getName();
                    System.out.println("文件名称"+fName);
                    //获取服务端upload真实路径
                    String realPath= request.getSession().getServletContext().getRealPath("/WEB-INF/Modules/upload/");
                    //String realPath = "//src/main/webapp/WEB-INF/Modules/upload//";
                    String uuidName= UploadUtils.getUUIDName(fName);

                    //在服务端指定路径下创建文件
                    File f=new File(realPath,uuidName);
                    System.out.println("bbbbb"+f);
                    if(!f.exists()) {
                        f.createNewFile();
                        //创建文件此时其中没有内容
                    }
                    item.write(f);//将上传到服务端的文件中的二进制数据输出到文件中
                    map.put("homeAttachment", uuidName);
                    map.put("homeOldname", fName);
                }

            }
            studentHomework.setH_id(h_id);
            studentHomework.setStu_id(stu_id);
            studentHomework.setH_subTime(sdf.format(new Date()));
            userService.updateStudentHomework(studentHomework,h_name);

            studentSubmitHomework  = userService.findSubmitHomeworkBySIdAndHId(stu_id,h_id);
            System.out.println("hhhj"+userService.findSubmitHomeworkBySIdAndHId(stu_id,h_id));
            if (studentSubmitHomework==null){
                studentSubmitHomework = new StudentSubmitHomework();
                //将MAP中的数据封装在对象上
                BeanUtils.populate(studentSubmitHomework, map);
                studentSubmitHomework.setStu_id(stu_id);
                studentSubmitHomework.setIsSubmit(1);
                studentSubmitHomework.setH_id(h_id);
                studentSubmitHomework.setShw_content(value);
                studentSubmitHomework.setSubData(sdf.format(new Date()));
                userService.submithomework(studentSubmitHomework,h_id);

            }else{
                BeanUtils.populate(studentSubmitHomework, map);
                studentSubmitHomework.setShw_content(value);
                studentSubmitHomework.setSubData(sdf.format(new Date()));
                userService.updatesubmithomework(studentSubmitHomework,h_id);
            }

            response.sendRedirect("homeworkPrev.do");
       }else
        {
            response.sendRedirect("homeworkPrev.do");
        }
        return null;

    }


    @RequestMapping("homeworkPrevUI")
    public String homeworkprevUI(){
        return HOMEWORKPREV_PAGE;

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

//    @RequestMapping("welcomeExam")
//    public String welcomeExam(){
//        return WELCOMEEXAM_PAGE;
//    }

    /**
     * 考生中心欢迎页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "welcomeExam",method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView model, HttpServletRequest request){
        model.addObject("title", "考生中心");
        System.out.println("user:lll"+user+user.getSubjectId());
        //user = (User) request.getSession().getAttribute("student");
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("subjectId", user.getSubjectId());
        queryMap.put("startTime", DateFormatUtil.getDate("yyyy-MM-dd hh:mm:ss", new Date()));
        queryMap.put("endTime", DateFormatUtil.getDate("yyyy-MM-dd hh:mm:ss", new Date()));
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 10);
        model.addObject("examList", examService.findListByUser(queryMap));
        System.out.println("88888"+queryMap+examService.findListByUser(queryMap));
        queryMap.remove("subjectId");
        queryMap.put("studentId", user.getId());
        System.out.println("history:"+queryMap);
        model.addObject("historyList", examPaperService.findHistory(queryMap));
        System.out.println("history:"+queryMap+examPaperService.findHistory(queryMap));
        model.addObject("subject", subjectService.findById((long) user.getSubjectId()));
        model.setViewName("user/welcomeExam");
        return model;
    }

    /**
     * 获取当前学生正在进行的考试信息
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "exam_list",method = RequestMethod.GET)
    public ModelAndView exameList(ModelAndView model,
                                  @RequestParam(name="name",defaultValue="") String name,
                                  @RequestParam(name="page",defaultValue="1") Integer page,
                                  HttpServletRequest request){
      //  Student student = (Student)request.getSession().getAttribute("student");
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("subjectId", user.getSubjectId());
        queryMap.put("name", name);
        queryMap.put("offset", getOffset(page, pageSize));
        queryMap.put("pageSize", pageSize);
        model.addObject("examList", examService.findListByUser(queryMap));
        model.addObject("name", name);
        model.addObject("subject", subjectService.findById((long) user.getSubjectId()));
        model.setViewName("user/exam_list");
        if(page < 1)page = 1;
        model.addObject("page", page);
        model.addObject("nowTime", System.currentTimeMillis());
        return model;
    }

    /**
     * 获取当前学生考过的考试信息
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "history_list",method = RequestMethod.GET)
    public ModelAndView historyList(ModelAndView model,
                                    @RequestParam(name="name",defaultValue="") String name,
                                    @RequestParam(name="page",defaultValue="1") Integer page,
                                    HttpServletRequest request){
       // Student student = (Student)request.getSession().getAttribute("student");
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("name", name);
        queryMap.put("studentId", user.getId());
        queryMap.put("offset", getOffset(page, pageSize));
        queryMap.put("pageSize", pageSize);
        model.addObject("historyList", examPaperService.findHistory(queryMap));
        model.addObject("name", name);
        model.addObject("subject", subjectService.findById((long) user.getSubjectId()));
        model.setViewName("user/history_list");
        if(page < 1)page = 1;
        model.addObject("page", page);
        return model;
    }

    /**
     *
     * @param model
     * @param examPaperId
     * @param request
     * @return
     */
    @RequestMapping(value = "/review_exam",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model,Long examId,Long examPaperId,HttpServletRequest request){
       // Student student = (Student)request.getSession().getAttribute("student");
        Exam exam = examService.findById(examId);
        if(exam == null){
            model.setViewName("/exam/error");
            model.addObject("msg", "当前考试不存在!");
            return model;
        }
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("examId", examId);
        queryMap.put("studentId", user.getId());
        //根据考试信息和学生信息获取试卷
        ExamPaper examPaper = examPaperService.find(queryMap);
        if(examPaper == null){
            model.setViewName("exam/error");
            model.addObject("msg", "当前考试不存在试卷");
            return model;
        }
        if(examPaper.getStatus() == 0){
            model.setViewName("exam/error");
            model.addObject("msg", "您还没有考过这门考试！");
            return model;
        }
        queryMap.put("examPaperId", examPaper.getId());
        List<ExamPaperAnswer> findListByUser = examPaperAnswerService.findListByUser(queryMap);
        model.addObject("title", exam.getName()+"-回顾试卷");
        model.addObject("singleQuestionList", getExamPaperAnswerList(findListByUser, Question.QUESTION_TYPE_SINGLE));
        model.addObject("muiltQuestionList", getExamPaperAnswerList(findListByUser, Question.QUESTION_TYPE_MUILT));
        model.addObject("chargeQuestionList", getExamPaperAnswerList(findListByUser, Question.QUESTION_TYPE_CHARGE));
        model.addObject("exam", exam);
        model.addObject("examPaper", examPaper);
        model.addObject("singleScore", Question.QUESTION_TYPE_SINGLE_SCORE);
        model.addObject("muiltScore", Question.QUESTION_TYPE_MUILT_SCORE);
        model.addObject("chargeScore", Question.QUESTION_TYPE_CHARGE_SCORE);
        model.addObject("singleQuestion", Question.QUESTION_TYPE_SINGLE);
        model.addObject("muiltQuestion", Question.QUESTION_TYPE_MUILT);
        model.addObject("chargeQuestion", Question.QUESTION_TYPE_CHARGE);
        model.setViewName("user/review_exam");
        return model;
    }

    /**
     * 返回指定类型的试题
     * @param examPaperAnswers
     * @param questionType
     * @return
     */
    private List<ExamPaperAnswer> getExamPaperAnswerList(List<ExamPaperAnswer> examPaperAnswers,int questionType){
        List<ExamPaperAnswer> newExamPaperAnswers = new ArrayList<ExamPaperAnswer>();
        for(ExamPaperAnswer examPaperAnswer:examPaperAnswers){
            if(examPaperAnswer.getQuestion().getQuestionType() == questionType){
                newExamPaperAnswers.add(examPaperAnswer);
            }
        }
        return newExamPaperAnswers;
    }




    @RequestMapping("examManage")
    public String examManage(){
        return EXAMMANAGE_PAGE;
    }


    @RequestMapping(EDIT)
    public String edit(){
        return UEDIT_PAGE;

    }

    /**
     * 计算数据库查询游标位置
     * @param page
     * @param pageSize
     * @return
     */
    private int getOffset(int page,int pageSize){
        if(page < 1)page = 1;
        return (page - 1) * pageSize;
    }


    @RequestMapping("chat_index")
    public String chat_index(){
        return CHAT_INDEX_PAGE;
    }

    /**
     * 聊天主页
     */
    @RequestMapping(value = "chat")
    public ModelAndView getIndex(ModelAndView model){
        model.addObject("userid",user.getId());
        ModelAndView view = new ModelAndView("chat/index");
        return view;
    }


}
