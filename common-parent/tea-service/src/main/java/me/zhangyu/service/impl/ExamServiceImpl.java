package me.zhangyu.service.impl;


import me.zhangyu.model.Exam;

import me.zhangyu.service.ExamService;

import me.zhangyu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExamServiceImpl extends BaseServiceImpl<Exam> implements ExamService {


    @Override
    public int add(Exam exam) {
        return examMapper.add(exam);    }

    @Override
    public int edit(Exam exam) {
        return examMapper.edit(exam);
    }

    @Override
    public List<Exam> findList(Map<String, Object> queryMap) {
        return examMapper.findList(queryMap);    }

    @Override
    public int delete(Long id) {
        return examMapper.delete(id);    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return examMapper.getTotal(queryMap);
    }

    @Override
    public List<Exam> findListByUser(Map<String, Object> queryMap) {
        return examMapper.findListByUser(queryMap);
    }

    @Override
    public Integer getTotalByUser(Map<String, Object> queryMap) {
        return examMapper.getTotalByUser(queryMap);
    }

    @Override
    public Exam findById(Long id) {
        return examMapper.findById(id);
    }

    @Override
    public int updateExam(Exam exam) {
        return examMapper.updateExam(exam);
    }

    @Override
    public Exam findById(int id) {
        return null;
    }

    @Override
    public Exam findByUsername(String username) {
        return null;
    }

    @Override
    public Exam findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(Exam exam) {

    }

    @Override
    public void insert(Exam exam) {

    }

    @Override
    public Exam validateUserExist(String username) {
        return null;
    }




}
