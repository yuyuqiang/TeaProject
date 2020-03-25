package me.zhangyu.mapper;

import me.zhangyu.mapper.base.BaseMapper;

import me.zhangyu.model.Vedio;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface VedioMapper extends BaseMapper<Vedio> {

    List<Vedio> findPrevVedio();

    List<Vedio> findVedioWithPage(@Param("i") int i, @Param("j") int j);

    int findTotalRecords();

    Vedio findVedioByVid(@Param("vId")String vId);
}
