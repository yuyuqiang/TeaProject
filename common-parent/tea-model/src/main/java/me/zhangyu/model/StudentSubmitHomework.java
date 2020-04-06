package me.zhangyu.model;

import java.sql.Timestamp;

public class StudentSubmitHomework {
    private int id;
    private int h_id;
    private int stu_id;
    private double grade;
    private String homeAttachment;
    private String homeOldname;
    private int isSubmit;
    private String subData;
    private String shw_content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getHomeAttachment() {
        return homeAttachment;
    }

    public void setHomeAttachment(String homeAttachment) {
        this.homeAttachment = homeAttachment;
    }

    public String getHomeOldname() {
        return homeOldname;
    }

    public void setHomeOldname(String homeOldname) {
        this.homeOldname = homeOldname;
    }

    public int getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(int isSubmit) {
        this.isSubmit = isSubmit;
    }

    public String getSubData() {
        return subData;
    }

    public void setSubData(String subData) {
        this.subData = subData;
    }

    public String getShw_content() {
        return shw_content;
    }

    public void setShw_content(String shw_content) {
        this.shw_content = shw_content;
    }

    @Override
    public String toString() {
        return "StudentSubmitHomework{" +
                "id=" + id +
                ", h_id=" + h_id +
                ", stu_id=" + stu_id +
                ", grade=" + grade +
                ", homeAttachment='" + homeAttachment + '\'' +
                ", homeOldname='" + homeOldname + '\'' +
                ", isSubmit=" + isSubmit +
                ", subData='" + subData + '\'' +
                ", shw_content='" + shw_content + '\'' +
                '}';
    }
}
