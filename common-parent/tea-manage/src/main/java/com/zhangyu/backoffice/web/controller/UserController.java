package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.*;
import me.zhangyu.service.IUserService;
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
    public  static  int id;
    public  static String uname;
    public  static String upsd;
    public static User user ;
    public static Homework homework;
    public static StudentSubmitHomework studentSubmitHomework;
    private String dirPath = "E:\\TeachingWebsite";

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

//    @RequestMapping("homeworkPrev")
//    public String findPrevhomework(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //1_调用业务层功能，返回存储着Vedio对象的集合
//        List<Homework> list=userService.findPrevHomework();//查询5个最新视频,返回集合
//        System.out.println("list66"+list);
//        //2_将集合放入request域对象内
//        request.setAttribute("list", list);
//        //3_转发到vedioPrev.jsp
//        return HOMEWORKPREV_PAGE;
//    }

    @RequestMapping("homeworkPrev")
    public String findPrevhomework(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1_调用业务层功能，返回存储着Vedio对象的集合
        int id = user.getId();
        System.out.println("hhhhhhhhhh"+id);
        List<StudentHomework> list= userService.findPreStudentHomework(id);
        System.out.println("list66"+list);
        //2_将集合放入request域对象内
        request.setAttribute("list", list);
        //3_转发到vedioPrev.jsp
        return HOMEWORKPREV_PAGE;
    }
//    @RequestMapping("homeworkPrev1")
//    public String findPrevhomework1(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //1_调用业务层功能，返回存储着Vedio对象的集合
//        List<Homework> list=userService.findPrevHomework();//查询5个最新视频,返回集合
//        System.out.println("list66"+list);
//        int h_id = studentSubmitHomework.getH_id();
//
//        //2_将集合放入request域对象内
//        request.setAttribute("list", list);
//        if(h_id==homework.getH_id()){
//            String subData = studentSubmitHomework.getSubData();
//            request.setAttribute("data",subData);
//        }
//        //3_转发到vedioPrev.jsp
//        return HOMEWORKPREV_PAGE;
//    }

    @RequestMapping("homeworkDetail")
    public String homeworkDetail(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //获取视频ID参数
        String h_name=request.getParameter("h_name");
        //调用业务层功能：根据视频ID查询对应的视频对象
        homework=userService.findHomeworkByid(h_name);
        studentSubmitHomework = new StudentSubmitHomework();
        int h_id = homework.getH_id();
        studentSubmitHomework=userService.findSubmitHomeworkByid(h_id);
        System.out.println(studentSubmitHomework);

        if(studentSubmitHomework==null){
            System.out.println("ooooo"+h_id);
            userService.submithomework(studentSubmitHomework,h_id);
        }
        //将查询到的视频对象放入request
        request.setAttribute("hw", homework);
        //转发到/site/vedio/vedioDtail.jsp
        return HOMEWORKDETAIL_PAGE;
    }

//    @RequestMapping("submitHomework")
//    public void studentSubmitHomework(MultipartFile uploadfile, HttpServletResponse response, HttpSession session, HttpServletRequest request){
//        //response.setHeader("content-type", "text/html;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
//        String wordPath = null;
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        //判断所上传文件是否存在
//        if(!uploadfile.isEmpty()){
//            //获取上传文件的原始名称
//            String originalFilename = uploadfile.getOriginalFilename();
//            //设置上传文件的保存地址目录
//            File filePath = new File(dirPath);
//            //如果保存文件的地址不存在，就先创建目录
//            if(!filePath.exists())filePath.mkdirs();
//            //使用UUID重新命名上传的文件名称（uuid_原始文件名称）
//            String newFilename = UUID.randomUUID()+"_"+originalFilename;
//            try {
//                //使用MultipartFile接口的方法完成文件上传到指定位置
//                uploadfile.transferTo(new File(dirPath+newFilename));
//            } catch (IllegalStateException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            wordPath = newFilename;
//        }
////        StudentWithHomework updateSWH=studentWithHomeworkService.queryStudentWithHomeworkByStudentIdAndH_ID(student_id, H_ID);
////        if(updateSWH==null){
////            StudentWithHomework studentWithHomework = new StudentWithHomework();
////            studentWithHomework.setH_ID(H_ID);
////            studentWithHomework.setStudent_id(student_id);
////            studentWithHomework.setContent(content);
////            studentWithHomework.setIsDone(1);
////            studentWithHomework.setWordFilePath(wordPath);
////            studentWithHomeworkService.addStudentWithHomework(studentWithHomework);
////        }else{
////            updateSWH.setContent(content);
////            updateSWH.setWordFilePath(wordPath);
////            studentWithHomeworkService.updateStudentWithHomeworkInformation(updateSWH);
////        }
////        session.removeAttribute("userinfor");
////        Student student = studentService.queryStudentById(student_id);
////        session.setAttribute("userinfor", student);
////        out.print("<script>alert('提交成功');window.location='/test5/studentQueryHomeworkDetail.action?id="+id+"'</script>");
////        out.flush();
////        out.close();
//
//    }
    /*
          学生提交作业
     */
    @RequestMapping("submitHomework")
    public String submitHomework(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Map<String,String> map=new HashMap<String,String>();//携带表单名称以及表单参数
        //携带studentSubmitHomework数据，向 service,dao进行传递
         studentSubmitHomework = new StudentSubmitHomework();
         StudentHomework studentHomework = new StudentHomework();

//        //1_创建DiskFiletemFactory对象设置允许上传文件大小
        DiskFileItemFactory fac=new DiskFileItemFactory();
        fac.setSizeThreshold(1024*1024*200); //允许上传文件的最大为200MB
//        //2_创建ServletFileUpload upload
        ServletFileUpload upload=new ServletFileUpload(fac);
//        //3_通过upload解析request,得到集合<FileItem>
//        // FileItem代表什么？工具就将请求体中每对分割线中间的内容封装为一个FileItem对象
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
                String value=item.getString();
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
        int h_id = homework.getH_id();
        int stu_id=user.getId();
        String h_name = homework.getH_name();
        String shw_content = request.getParameter("shw_content");
        studentSubmitHomework.setStu_id(stu_id);
        studentSubmitHomework.setIsSubmit(1);
        studentSubmitHomework.setShw_content(shw_content);

        //将MAP中的数据封装在Vedio对象上
        BeanUtils.populate(studentSubmitHomework, map);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        studentSubmitHomework.setSubData(sdf.format(new Date()));

        studentHomework.setH_id(h_id);
        studentHomework.setStu_id(stu_id);
        studentHomework.setH_subTime(sdf.format(new Date()));


        //6_将普通项的数据以及文件的位置传递到service,dao.进行数据的保存
         userService.updatesubmithomework(studentSubmitHomework,h_id);
         userService.updateStudentHomework(studentHomework,h_name);
         response.sendRedirect("homeworkPrev.do");
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


    @RequestMapping(EDIT)
    public String edit(){
        return UEDIT_PAGE;

    }


}
