package com.zhangyu.backoffice.web.controller;

import com.zhangyu.backoffice.web.controller.base.BaseController;
import me.zhangyu.model.Vedio;
import me.zhangyu.service.VedioService;
import me.zhangyu.untils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("vedio")
public class VedioController extends BaseController<Vedio> {
    @Autowired
    private VedioService vedioService;

    @RequestMapping(VEDIO)
    public String findPrevVedio(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1_调用业务层功能，返回存储着Vedio对象的集合
       List<Vedio> list=vedioService.findPrevVedio();//查询5个最新视频,返回集合
        //2_将集合放入request域对象内
        request.setAttribute("list", list);
        //3_转发到vedioPrev.jsp
        return VEDIO_PAGE;
    }
    @RequestMapping(VEDIOALL)
    public String findVedioWithpage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1_接受当前页参数
        int num=Integer.parseInt(request.getParameter("num"));
        System.out.println("aaaaaaaaa"+num);
        //2_调用业务层功能，返回PageModel
        PageModel pm=vedioService.findVedioWithPage(num);
        //  为什么是PageModel?:
        //   由于当前的功能时分页查询，除了查询当前页中的视频信息之外，还需要获得分页参数信息
        //   如果仅仅是当前页中的视频，用一个集合就可以实现。但是分页参数比较繁杂，所以用PageModel工具类携带这类数据
        //3_将PageModel放入request
        request.setAttribute("page", pm);
        //4_转发到vedioAll.jsp
        return VEDIOALL_PAGE;
    }

    @RequestMapping(VEDIODETAIL)
    public String findVedioByVid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取视频ID参数
        String vId=request.getParameter("id");
        //调用业务层功能：根据视频ID查询对应的视频对象
        Vedio vedio=vedioService.findVedioByVid(vId);
        //将查询到的视频对象放入request
        request.setAttribute("vedio", vedio);
        //转发到/site/vedio/vedioDtail.jsp
        return VEDIODETAIL_PAGE;
    }
    @RequestMapping(PLAYVEDIO)
    public String playVedioById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取到视频id
        String vId=request.getParameter("id");
        //将视频id传递给service,调用service功能，返回视频对象
        Vedio vedio=vedioService.findVedioByVid(vId);
        //将返回的视频对象放入request
        request.setAttribute("vedio", vedio);
        //转发到/play/playVedio.jsp
        return PLAYVEDIO_PAGE;
    }


    @RequestMapping(VEDIOUPDOWN)
    public String downloadVedio(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接受客户端视频的id
        String id=request.getParameter("id");
        //调用service功能，根据视频的id获取视频对象
        Vedio vedio=vedioService.findVedioByVid(id);
        //获取到项目下upload目录的绝对路径
        String realPath = request.getServletContext().getRealPath("/WEB-INF/Modules/upload/");
        //实例化一个File代表，代表待下载的视频。
        File file=new File(realPath,vedio.getVedioAttachment());

     //   DownLoadUtils.setConentType(request, vedio.getVedioAttachment(), response);
        //通过response对象设置一对消息头
        response.setHeader("Content-disposition", "attachment;filename="+vedio.getVedioAttachment());

        //通过File获取输入流
        InputStream is=new FileInputStream(file);
        //通过response获取到输出流
        OutputStream os = response.getOutputStream();

     //   将输入流中的数据刷出到输出流中
            IOUtils.copy(is, os);
            IOUtils.closeQuietly (is);
            IOUtils.closeQuietly(os);

        //由于当前功能是在实现下载，是不需要转发到任意页面。数据直接从服务端的servlet通过response获取到的字节输出流将数据发送到客户端即可。
        return null;
    }

}
