package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Rar;
import me.zhangyu.model.Vedio;
import me.zhangyu.service.RarService;
import me.zhangyu.service.VedioService;
import me.zhangyu.untils.DownLoadUtils;
import me.zhangyu.untils.PageModel;
import me.zhangyu.untils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("rar")
public class RarController extends BaseController<Vedio> {
    @Autowired
    private RarService rarService;
    @Autowired
    private VedioService vedioService;

    @RequestMapping("rarAddUI")
    public ModelAndView list(ModelAndView model){
        model.setViewName("teacher/raradd");
        return model;
    }

    //addVedio
    @RequestMapping("addRar")
    public String addVedio(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,String> map=new HashMap<String,String>();//携带表单名称以及表单参数
        Rar rar=new Rar();
        DiskFileItemFactory fac=new DiskFileItemFactory();
        fac.setSizeThreshold(1024*1024*200); //允许上传文件的最大为200MB
        //2_创建ServletFileUpload upload
        ServletFileUpload upload=new ServletFileUpload(fac);
        upload.setHeaderEncoding("UTF-8");
        //3_通过upload解析request,得到集合<FileItem>
        // FileItem代表什么？工具就将请求体中每对分割线中间的内容封装为一个FileItem对象
        List<FileItem> list=upload.parseRequest(request);

        // Collection<MultipartFile> files = fileMap.values();
        //4_遍历集合
        for (FileItem item : list) {
            //5_判断当前FileItem是普通项还是上传项？
            //什么是普通项：表单中的普通字段，非上传字段
            //什么是上传项：表单中包含file组件上传项，携带着上传到服务端文件
            //item.isFormField()  ;;判断当前的item是否是表单项目
            if(item.isFormField()) {
                //普通项
                //如果是普通项：获取到对应的表单名称和表单内容     Eg: vedioName<__>333333333
                String name=item.getFieldName();
                String value=item.getString("UTF-8");

                System.out.println("lllllllllllll"+name+value); //vedioName  vedioProSystem.out.println("mmmmmmmmmmmmmmm"+value); //1111       22222
                map.put(item.getFieldName(), value);
            }else {


                //如果是上传项：在服务端指定目录/upload/ 创建一个文件，将上传项中文件的二进制数据输出到创建好的文件中
                //获取到文件名称
                String fName=item.getName();
                System.out.println("文件名称"+fName); //11.mp4
                //获取服务端upload真实路径
                int index = fName.lastIndexOf(".");
                String suffix =fName.substring(index);
                System.out.println("ggggggg"+suffix);
                String realPath="E:\\TeachingWebsite\\TeaProject\\common-parent\\tea-manage\\src\\main\\webapp\\assets1\\upload\\";

                String uuidName= UploadUtils.getUUIDName(fName);

                //XXXXXX.mp4
                //在服务端指定路径下创建文件
                File f=new File(realPath,uuidName);
                System.out.println("bbbbb"+f);
                if(!f.exists()) {
                    f.createNewFile();
                    //创建文件此时其中没有内容
                }
                item.write(f);//将上传到服务端的文件中的二进制数据输出到文件中
                map.put("rarAttachment", fName);
                map.put("rarRealname", uuidName);
            }

        }




        BeanUtils.populate(rar, map);
        System.out.println("ssssssssssssss"+rar);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        rar.setUploadTime(sdf.format(new Date()));

        System.out.println("sss"+rar);
        rarService.addRar(rar);

        response.sendRedirect("findRarWithPageByTeacher.do?num=1");
        return null;
    }

    //findVediosWithPageByTeacher
    @RequestMapping("findRarWithPageByTeacher")
    public String findRarWithPageByTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前页
        int currentPageNum=Integer.parseInt(request.getParameter("num"));
        //调用业务层功能:带分页形式查询视频信息，返回PageModel(1_当前页中的视频信息2_计算好的分页参数3_url)
        PageModel pm=rarService.findRarWithPageByTeacher(currentPageNum);
        //将PageModel放入reqest
        request.setAttribute("page", pm);
        //转发到vedioMana.jsp
        return "teacher/RarTeaPrev";
    }


    @RequestMapping("deleteRarByTeacher")
    public String deleteVedioByTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取待删除视频的编号
        String rId=request.getParameter("id");
        System.out.println("iiii"+rId);
        //调用业务层功能，根据视频编号删除视频
        rarService.deleteRarByTeacher(rId);
        //重定向到查询全部商品路径
        response.sendRedirect("findRarWithPageByTeacher.do?num=1");
        return null;
    }



    @RequestMapping("rarPrev")
    public String findRarByRid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int num=Integer.parseInt(request.getParameter("num"));
        PageModel pm=rarService.findRarWithPage(num);
        request.setAttribute("page", pm);
        return "user/rarPrev";
    }

    @RequestMapping("rarUpdown")
    public String downloadVedio(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接受客户端视频的id
        String id=request.getParameter("id");
        //调用service功能，根据视频的id获取视频对象
        Rar rar=rarService.findRarByRid(id);
        System.out.println("kk"+id);
       //获取到项目下upload目录的绝对路径
          String realPath="E:\\TeachingWebsite\\TeaProject\\common-parent\\tea-manage\\src\\main\\webapp\\assets1\\upload\\";

        System.out.println("llllllll"+realPath);
        //实例化一个File代表，代表待下载的视频。
        File file=new File(realPath,rar.getRarRealname());
        //通过response对象设置一对消息头
        DownLoadUtils.setConentType(request, rar.getRarRealname(), response);


        //通过File获取输入流
        InputStream is=new FileInputStream(file);
        //通过response获取到输出流
        OutputStream os = response.getOutputStream();

        //   将输入流中的数据刷出到输出流中
        IOUtils.copy(is, os);
        IOUtils.closeQuietly (is);
        IOUtils.closeQuietly(os);

        rar.setDownNum(rar.getDownNum()+1);
        rarService.updateRar(rar,Integer.parseInt(id));
        //由于当前功能是在实现下载，是不需要转发到任意页面。数据直接从服务端的servlet通过response获取到的字节输出流将数据发送到客户端即可。
        return null;
    }



}
