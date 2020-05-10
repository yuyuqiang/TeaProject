package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;
import me.zhangyu.model.Rar;
import me.zhangyu.model.Vedio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RarMapper extends BaseMapper<Rar> {


    void addRar(@Param("rar") Rar rar);

    List<Rar> findPrevRar();


    int findTotalRecords();

    List<Rar> findRarWithPageByTeacher(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    void deleteRarByTeacher(@Param("rId") String rId);

    List<Rar> findRarWithPage(@Param("i") int i,@Param("j") int i1);

    Rar findRarByRid(@Param("id") String id);

    void updateRar(@Param("rar") Rar rar, @Param("id") int id);
}
