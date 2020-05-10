package me.zhangyu.service.impl;

import me.zhangyu.model.Rar;
import me.zhangyu.model.Vedio;
import me.zhangyu.service.RarService;
import me.zhangyu.service.base.BaseServiceImpl;
import me.zhangyu.untils.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class RarServicelmpl extends BaseServiceImpl<Rar> implements RarService {


    @Override
    public Rar findById(int id) {
        return null;
    }

    @Override
    public Rar findByUsername(String username) {
        return null;
    }

    @Override
    public Rar findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(Rar rar) {

    }

    @Override
    public void insert(Rar rar) {

    }

    @Override
    public Rar validateUserExist(String username) {
        return null;
    }


    @Override
    public void addRar(Rar rar) {
        rarMapper.addRar(rar);
    }

    @Override
    public List<Rar> findPrevRar() {
        return rarMapper.findPrevRar();
    }

    @Override
    public PageModel findRarWithPageByTeacher(int currentPageNum) {
        //1_创建PageModel对象，计算分页参数
        int totalRecords=rarMapper.findTotalRecords();//select count(*) from t_vedio
        PageModel pm=new PageModel(currentPageNum, totalRecords, 5);
        //2_为PageModel对象设置集合(当前页中的视频信息)
        //select * from t_vedio limit ? , ?
        List<Rar> list=rarMapper.findRarWithPageByTeacher(pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        //3_为PageModel对象设置url (PageFile.jsp页面所需)
        pm.setUrl("rar/findRarWithPageByTeacher.do");
        return pm;
    }

    @Override
    public void deleteRarByTeacher(String rId) {
        rarMapper.deleteRarByTeacher(rId);
    }

    @Override
    public PageModel findRarWithPage(int num) {
        //创建PageModel对象，计算分页参数信息
        int totalRecords=rarMapper.findTotalRecords();
        PageModel pm = new PageModel(num,totalRecords,5);
        //为PageModel关联集合，集合中存放当前页中的信息
        //调用DAO层查询当前页中的视频信息
        List<Rar> list = rarMapper.findRarWithPage((num-1)*5,5);
        pm.setList(list);
        //为pagemodel关联URL属性
        pm.setUrl("rar/rarPrev.do");
        return pm;
    }

    @Override
    public Rar findRarByRid(String id) {
        return rarMapper.findRarByRid(id);
    }

    @Override
    public void updateRar(Rar rar, int id) {
        rarMapper.updateRar(rar,id);
    }
}
