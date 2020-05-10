package me.zhangyu.service.base;

import me.zhangyu.mapper.*;
import me.zhangyu.model.ExamPaperAnswer;
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

    @Autowired
    protected ExamMapper examMapper;

    @Autowired
    protected SubjectMapper subjectMapper;

    @Autowired
    protected ExamPaperMapper examPaperMapper;

    @Autowired
    protected ExamPaperAnswerMapper examPaperAnswerMapper;

    @Autowired
    protected RarMapper rarMapper;





}
