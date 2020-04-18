package me.zhangyu.service.impl;


import me.zhangyu.model.Question;
import me.zhangyu.model.Subject;
import me.zhangyu.service.QuestionService;
import me.zhangyu.service.SubjectService;
import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SubjectServiceImpl extends BaseServiceImpl<Subject> implements SubjectService {


    @Override
    public Subject findById(int id) {
        return null;
    }

    @Override
    public Subject findByUsername(String username) {
        return null;
    }

    @Override
    public Subject findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(Subject subject) {

    }

    @Override
    public void insert(Subject subject) {

    }

    @Override
    public Subject validateUserExist(String username) {
        return null;
    }

    @Override
    public int add(Subject subject) {
        return subjectMapper.add(subject);
    }

    @Override
    public int edit(Subject subject) {
        return subjectMapper.edit(subject);
    }

    @Override
    public List<Subject> findList(Map<String, Object> queryMap) {
        return subjectMapper.findList(queryMap);
    }

    @Override
    public int delete(Long id) {
        return subjectMapper.delete(id);
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return subjectMapper.getTotal(queryMap);
    }

    @Override
    public Subject findById(Long id) {
        return subjectMapper.findById(id);
    }
}
