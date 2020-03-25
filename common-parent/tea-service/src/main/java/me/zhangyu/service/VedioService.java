package me.zhangyu.service;

import me.zhangyu.model.Vedio;
import me.zhangyu.service.base.IBaseService;
import me.zhangyu.untils.PageModel;

import java.sql.SQLException;
import java.util.List;


public interface VedioService extends IBaseService<Vedio> {
      List<Vedio> findPrevVedio() throws SQLException;
      PageModel findVedioWithPage(int num) throws SQLException;

      Vedio findVedioByVid(String vId) throws SQLException;
}