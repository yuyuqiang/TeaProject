package me.zhangyu.service;

import me.zhangyu.model.Rar;
import me.zhangyu.model.Vedio;
import me.zhangyu.service.base.IBaseService;
import me.zhangyu.untils.PageModel;

import java.sql.SQLException;
import java.util.List;


public interface RarService extends IBaseService<Rar> {

    void addRar(Rar rar);

    List<Rar> findPrevRar();

    PageModel findRarWithPageByTeacher(int currentPageNum);

    void deleteRarByTeacher(String rId);

    PageModel findRarWithPage(int num);

    Rar findRarByRid(String id);

    void updateRar(Rar rar, int parseInt);
}
