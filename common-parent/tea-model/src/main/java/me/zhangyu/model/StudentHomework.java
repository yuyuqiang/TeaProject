package me.zhangyu.model;

import java.sql.Timestamp;

public class StudentHomework {
    private int id;
    private int stu_id;
    private int h_id;
    private String h_name;
    private Timestamp h_startTime;
    private String h_subTime;
    private double grade;
    private String h_content;
    private Long subjectId;
    private Timestamp h_endTime;
    public Long getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Timestamp getH_endTime() {
        return h_endTime;
    }

    public void setH_endTime(Timestamp h_endTime) {
        this.h_endTime = h_endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public Timestamp getH_startTime() {
        return h_startTime;
    }

    public void setH_startTime(Timestamp h_startTime) {
        this.h_startTime = h_startTime;
    }

    public String getH_subTime() {
        return h_subTime;
    }

    public void setH_subTime(String h_subTime) {
        this.h_subTime = h_subTime;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getH_content() {
        return h_content;
    }

    public void setH_content(String h_content) {
        this.h_content = h_content;
    }

    @Override
    public String toString() {
        return "StudentHomework{" +
                "id=" + id +
                ", stu_id=" + stu_id +
                ", h_name='" + h_name + '\'' +
                ", h_startTime=" + h_startTime +
                ", h_subTime='" + h_subTime + '\'' +
                ", grade=" + grade +
                ", h_content='" + h_content + '\'' +
                '}';
    }
}
