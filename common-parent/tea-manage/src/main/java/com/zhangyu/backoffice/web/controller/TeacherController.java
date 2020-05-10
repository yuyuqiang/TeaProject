package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.*;
import me.zhangyu.service.IUserService;
import me.zhangyu.service.SubjectService;
import me.zhangyu.service.TeacherService;
import me.zhangyu.untils.Page;
import me.zhangyu.untils.PageModel;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 创建请求处理类
 */
@Controller
@RequestMapping("teacher")
public class TeacherController extends BaseController<Teacher> {

    @Autowired
    private TeacherService teacherService;
    public static Homework homework;
    public Teacher teacher;
    public static  int t_id ;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private IUserService userService;

    @RequestMapping("teaLogin")
    public String teacherLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取账户和密码
        String um = request.getParameter("username");
        String up = request.getParameter("password");
        //调用业务层登录功能,   返回teacher对象
        teacher=teacherService.teacherLogin(um,up);
        if(null==teacher) {
            //如果teacher对象为空， 登录失败，向request放入提示信息 ,转发到login.jsp页面
            request.setAttribute("msg", "账户密码不匹配");
            return ULOGIN_PAGE;
        }else {
            //如果teacher对象不为空 ,登录成功，向session放入teacher对象,重定向到/atea/index.jsp
            request.getSession().setAttribute("teacher", teacher);
            response.sendRedirect("teaIndex.do");
            return null;
        }
    }



    @RequestMapping("teaIndex")
    public String index(HttpServletRequest request)
    {
        request.setAttribute("username",teacher.getTeaRealName());

        return TEAINDEX_PAGE;
    }


    @RequestMapping("teaInfo")
    //findTeachersWithPage
    public String findTeachersWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前页
        int currentNum=Integer.parseInt(request.getParameter("num"));
        //调用业务层功能，返回PageModel对象
        PageModel pm=teacherService.findTeachersWithPage(currentNum);
        //将PageModel对象放入request
        request.setAttribute("page", pm);
        //转发到jsp
        return TEAINFO_PAGE;
    }


    @RequestMapping("teacherAddUI")
    public String teaADD(){
        return TEAADD_PAGE;
    }

    //addTeacher
    @RequestMapping("addTeacher")
    public String addTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接受参数
        String teaNum=request.getParameter("teaNum");
        String teaRealName=request.getParameter("teaRealName");
        String teaSex=request.getParameter("teaSex");
        String teaAge=request.getParameter("teaAge");
        String loginName=request.getParameter("loginName");
        String loginPwd=request.getParameter("loginPwd");
        Teacher teacher=new Teacher();
        teacher.setTeaNum(teaNum);
        teacher.setTeaRealName(teaRealName);
        teacher.setTeaSex(teaSex);
        teacher.setTeaAge(teaAge);
        teacher.setLoginName(loginName);
        teacher.setLoginPwd(loginPwd);
        //调用业务层添加老师功能
        teacherService.addTeacher(teacher);
        //重定向到查询老师信息功能
        response.sendRedirect("teaInfo.do?num=1");
        return null;
    }

    @RequestMapping("delTeacher")
    public String delTeacherById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取待删除老师的编号
        String id= request.getParameter("id");
        //调用业务层删除老师功能
        System.out.println("delid:"+id);
        teacherService.delTeacherById(id);
        //重定向到/TeacherServlet?method=findTeachersWithPage
        response.sendRedirect("teaInfo.do?num=1");
        return null;
    }

    //updateTeacher
    @RequestMapping("updateTeacher")
    public String updateTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String num=request.getParameter("teaNum");
        String name=request.getParameter("teaRealname");
        String sex=request.getParameter("teaSex");
        String teaAge=request.getParameter("teaAge");
        String loginName=request.getParameter("loginName");
        String loginPwd=request.getParameter("loginPwd");
        String teaId=request.getParameter("teaId");
        Teacher t=new Teacher();
        t.setTeaId(Integer.parseInt(teaId));
        t.setTeaNum(num);
        t.setTeaRealName(name);
        t.setTeaSex(sex);
        t.setTeaAge(teaAge);
        t.setLoginName(loginName);
        t.setLoginPwd(loginPwd);

        teacherService.updateTeacher(t);
        return  "updateSuccess";
    }

    /**
     * 老师发布作业
     * */
    @RequestMapping("publishHomework")
    public String teacherPublishHomeworkInformation(HttpServletResponse response,HttpSession session,HttpServletRequest request) throws SQLException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Date time=null;
        Timestamp startTime=null;
        Timestamp endTime=null;
        String subjectId = request.getParameter("subjectId");
        System.out.println("sub111;"+subjectId);
        String H_name = request.getParameter("H_name");
        String H_startTime = request.getParameter("H_startTime");
        String H_endTime = request.getParameter("H_endTime");
        String H_content = request.getParameter("H_content");
        System.out.println("作业："+H_name+H_startTime+H_endTime+H_content);
        try {
            // 说明：//将字符串转换成时间 将C#时间戳，格式为：/Date(-62135596800000)，转换为js时间。
            time = dateFormat.parse(H_startTime.replace('T', ' '));
            startTime = new Timestamp(time.getTime());
            time = dateFormat.parse(H_endTime.replace('T', ' '));
            endTime = new Timestamp(time.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        homework=new Homework();
        StudentHomework studentHomework = new StudentHomework();
        Date now = new Date();
        DateFormat dateFormat2 = new SimpleDateFormat("dd HH:mm:ss", Locale.ENGLISH);
        homework.setH_startTime(startTime);
        homework.setH_endTime(endTime);
        homework.setH_name(H_name);
        homework.setH_content(H_content);
        homework.setT_id(teacher.getTeaId());
        homework.setSubjectId(Long.valueOf(subjectId));


        studentHomework.setH_name(H_name);
        studentHomework.setH_startTime(startTime);
        studentHomework.setH_content(H_content);
        studentHomework.setH_endTime(endTime);
        studentHomework.setSubjectId(Long.valueOf(subjectId));

        response.setHeader("content-type", "text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        teacherService.addHomework(homework);

        teacherService.addStudentHomework(studentHomework);
        response.sendRedirect("teaHomeworkPrev.do");
        return null;
    }
    @RequestMapping("teaHomeworkPrev")
    public String teaHomeworkPrev(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //1_调用业务层功能，返回存储着Vedio对象的集合
        t_id = teacher.getTeaId();
        List<Homework> list=teacherService.findPrevHomework(t_id);//查询5个最新视频,返回集合
        System.out.println("list"+list);
        //2_将集合放入request域对象内
        request.setAttribute("list", list);
        return TEAHOMEWORKPREV_PAGE;
    }

    @RequestMapping("checkHomework")
    public String checkHomework(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String hid= request.getParameter("id");
        List<StudentSubmitHomework> list=teacherService.findSubmitHomework(hid);
        List<StudentSubmitHomework> list1=teacherService.findSubmitHomework1(hid);
        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
        return CHECKHOMEWORK_PAGE;
    }

    @RequestMapping(value = "studentHomeworkDown",produces={"application/json;charset=utf-8"})
    public ResponseEntity<byte[]> studentHomeworkDown(HttpServletResponse response, HttpSession session, HttpServletRequest request) throws IOException, SQLException {
        String id = request.getParameter("id");
        StudentSubmitHomework studentSubmitHomework = teacherService.findSubmitHomeworkByid(id);

        String fileName = studentSubmitHomework.getHomeAttachment();
        //指定要下载的文件所在路径
        //String path = "E:/TeachingWebsite/";
        String path = "E:/TeachingWebsite/TeaProject/common-parent/tea-manage/target/edu-manage/WEB-INF/Modules/upload/";
        //创建该文件对象
        File file = new File(path+File.separator+fileName);
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
        //定义以流的方式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

    }

    @RequestMapping("teacherSubmitGrade")
    public String teacherSubmitGrade(HttpServletRequest request, HttpServletResponse response)throws Exception{
         String grade = request.getParameter("grade");
         double d_grade = Double.parseDouble(grade);
         int hid = Integer.parseInt(request.getParameter("hid"));
         int id = Integer.parseInt(request.getParameter("id"));
         int sid = Integer.parseInt(request.getParameter("sid"));

         StudentSubmitHomework studentSubmitHomework = new StudentSubmitHomework();
         StudentHomework studentHomework = new StudentHomework();

         studentSubmitHomework.setGrade(d_grade);
         studentHomework.setGrade(d_grade);

         teacherService.updateStudentGrade(studentSubmitHomework,id);
         teacherService.updateStudentHomeworkGrade(studentHomework,hid,sid);

         response.sendRedirect("checkHomework.do?id="+hid);
        return null;
    }

    @RequestMapping("teaMessageManage")
    public String teaMessageManage(HttpServletRequest request){
        List<Notice> list=userService.findNoticeList();
        request.setAttribute("list", list);

        return TEAMESSAGEMANAGE_PAGE;
    }

    @RequestMapping("myTeaInfoUI")
    public String myTeaInfo(){

        return MYTEAINFO_PAGE;
    }

    @RequestMapping("publishHomeworkUI")
    public ModelAndView list(ModelAndView model){
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 99999);
        model.addObject("subjectList", subjectService.findList(queryMap));
        model.setViewName("teacher/publishHomework");
        return model;
    }

    /**
     * 考生列表页面
     * @param model
     * @return
     */
    @RequestMapping(value="list",method= RequestMethod.GET)
    public ModelAndView list1(ModelAndView model){
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 99999);
        model.addObject( "subjectList", subjectService.findList(queryMap));
        model.setViewName("teacher/studentList");
        return model;
    }

    /**
     * 模糊搜索分页显示列表查询
     * @param username
     * @param page
     * @return
     */
    @RequestMapping(value="list",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(
            @RequestParam(name="username",defaultValue="") String username,
            @RequestParam(name="subjectId",required=false) Long subjectId,
            Page page
    ){
        Map<String, Object> ret = new HashMap<String, Object>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("username", username);
        if(subjectId != null){
            queryMap.put("subjectId", subjectId);
        }
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        ret.put("rows", userService.findList(queryMap));
        ret.put("total", userService.getTotal(queryMap));
        return ret;
    }

    /**
     * 添加考生
     * @param student
     * @return
     */
    @RequestMapping(value="add",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(User student){
        Map<String, String> ret = new HashMap<String, String>();
        if(student == null){
            ret.put("type", "error");
            ret.put("msg", "请填写正确的考生信息!");
            return ret;
        }
        if(StringUtils.isEmpty(student.getUsername())){
            ret.put("type", "error");
            ret.put("msg", "请填写考生用户名!");
            return ret;
        }
        if(StringUtils.isEmpty(student.getPassword())){
            ret.put("type", "error");
            ret.put("msg", "请填写考生密码!");
            return ret;
        }

        //添加之前判断登录名是否存在
        if(isExistName(student.getUsername(), -1l)){
            ret.put("type", "error");
            ret.put("msg", "该登录账号已经存在!");
            return ret;
        }
        if(userService.add(student) <= 0){
            ret.put("type", "error");
            ret.put("msg", "添加失败，请联系管理员!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "添加成功!");
        return ret;
    }

    /**
     * 编辑考生
     * @param student
     * @return
     */
    @RequestMapping(value="edit",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(User student){
        Map<String, String> ret = new HashMap<String, String>();
        if(student == null){
            ret.put("type", "error");
            ret.put("msg", "请填写正确的学科信息!");
            return ret;
        }
        if(StringUtils.isEmpty(student.getUsername())){
            ret.put("type", "error");
            ret.put("msg", "请填写考生用户名!");
            return ret;
        }
        if(StringUtils.isEmpty(student.getPassword())){
            ret.put("type", "error");
            ret.put("msg", "请填写考生密码!");
            return ret;
        }

        //编辑之前判断登录名是否存在
        if(isExistName(student.getUsername(), (long) student.getId())){
            ret.put("type", "error");
            ret.put("msg", "该登录账号已经存在!");
            return ret;
        }
        if(userService.edit(student) <= 0){
            ret.put("type", "error");
            ret.put("msg", "编辑失败，请联系管理员!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "编辑成功!");
        return ret;
    }

    /**
     * 删除考生
     * @param id
     * @return
     */
    @RequestMapping(value="delete",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(Long id){
        Map<String, String> ret = new HashMap<String, String>();
        if(id == null){
            ret.put("type", "error");
            ret.put("msg", "请选择要删除的数据!");
            return ret;
        }
        try {
            if(userService.delete(id) <= 0){
                ret.put("type", "error");
                ret.put("msg", "删除失败，请联系管理员!");
                return ret;
            }
        } catch (Exception e) {
            // TODO: handle exception
            ret.put("type", "error");
            ret.put("msg", "该考生下存在考试信息，不能删除!");
            return ret;
        }

        ret.put("type", "success");
        ret.put("msg", "删除成功!");
        return ret;
    }

    /**
     * 判断用户名是否存在
     * @param name
     * @param id
     * @return
     */
    private boolean isExistName(String name,Long id){
        User student = userService.findByName(name);
        if(student == null)return false;
        if(student.getId() == id.longValue())return false;
        return true;
    }


    @RequestMapping(TEAMANAGE)
    public String teaManage(){
        return TEAMANAGE_PAGE;
    }

    @RequestMapping("teacomments")
    public String teacomments(){
        return TEACOMMERNTS_PAGE;
    }

    @RequestMapping("comments")
    public String comments(){
        return "comments";
    }

    /**
     * 聊天主页
     */
    @RequestMapping(value = "chat")
    public ModelAndView getIndex(ModelAndView model,HttpSession session){
        session.setAttribute("username",teacher.getTeaRealName());
        model.addObject("username",teacher.getTeaRealName());
        ModelAndView view = new ModelAndView("chat/index");
        return view;
    }

    /**
     * 公告
     */
    @RequestMapping(value = "publishNotice")
    public String publishNotice(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String noticeName = request.getParameter("noticeName");
        String noticeContent = request.getParameter("noticeContent");
        System.out.println("vvv"+noticeContent+noticeName);
        Notice notice = new Notice();
        notice.setCreateTime(new Date());
        notice.setNoticeContent(noticeContent);
        notice.setNoticeName(noticeName);
        teacherService.publishNotice(notice);
        response.sendRedirect("teaIndex.do");
       return null;
    }


}
