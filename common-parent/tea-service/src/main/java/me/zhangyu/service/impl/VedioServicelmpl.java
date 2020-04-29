package me.zhangyu.service.impl;

import me.zhangyu.model.Vedio;
import me.zhangyu.service.VedioService;
import me.zhangyu.service.base.BaseServiceImpl;
import me.zhangyu.untils.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class VedioServicelmpl extends BaseServiceImpl<Vedio> implements VedioService {
    @Override
    public Vedio findById(int id) {
        return null;
    }

    @Override
    public Vedio findByUsername(String username) {
        return null;
    }

    @Override
    public Vedio findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(Vedio vedio) {

    }

    @Override
    public void insert(Vedio vedio) {

    }

    @Override
    public Vedio validateUserExist(String username) {
        return null;
    }

    @Override
    public List<Vedio> findPrevVedio()throws SQLException {
        return vedioMapper.findPrevVedio();
    }

    @Override
    public PageModel findVedioWithPage(int num)throws SQLException{
        //创建PageModel对象，计算分页参数信息
        int totalRecords=vedioMapper.findTotalRecords();
        PageModel pm = new PageModel(num,totalRecords,5);
        //为PageModel关联集合，集合中存放当前页中的信息
        //调用DAO层查询当前页中的视频信息
        List<Vedio> list = vedioMapper.findVedioWithPage((num-1)*5,5);
        pm.setList(list);
        //为pagemodel关联URL属性
        pm.setUrl("vedio/vedioAll.do");
        return pm;
    }

    @Override
    public Vedio findVedioByVid(String vId)throws SQLException {
        //调用DAO层根据视频ID获取视频对象
        return vedioMapper.findVedioByVid(vId);
    }

    @Override
    public PageModel findVediosWithPageByTeacher(int currentPageNum)throws SQLException {
        //1_创建PageModel对象，计算分页参数
        int totalRecords=vedioMapper.findTotalRecords();//select count(*) from t_vedio
        PageModel pm=new PageModel(currentPageNum, totalRecords, 5);
        //2_为PageModel对象设置集合(当前页中的视频信息)
        //select * from t_vedio limit ? , ?
        List<Vedio> list=vedioMapper.findVediosWithPageByTeacher(pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        //3_为PageModel对象设置url (PageFile.jsp页面所需)
        pm.setUrl("vedio/findVediosWithPageByTeacher.do");
        return pm;
    }

    @Override
    public void deleteVedioByTeacher(String vId)throws SQLException {
        //调用DAO层，根据视频编号删除视频功能
        vedioMapper.deleteVedioByTeacher(vId);

    }

    @Override
    public void addVedio(Vedio vedio)throws SQLException {
        vedioMapper.addVedio(vedio);
    }

    @Override
    public int updateVedio(Vedio vedio,int id) {
        return vedioMapper.updateVedio(vedio,id);
    }
}
