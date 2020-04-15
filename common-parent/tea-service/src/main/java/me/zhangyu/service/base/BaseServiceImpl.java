package me.zhangyu.service.base;

import me.zhangyu.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    //统一管理dao
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected AdminMapper adminMapper;
    @Autowired
    protected VedioMapper vedioMapper;
    @Autowired
    protected TeacherMapper teacherMapper;
    @Autowired
    protected QuestionMapper questionMapper;


}
