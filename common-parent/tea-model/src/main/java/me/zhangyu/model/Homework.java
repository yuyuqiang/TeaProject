package me.zhangyu.model;

import java.sql.Timestamp;

public class Homework {
    private int H_id;
    private int T_id;
    private String H_name;
    private String H_content;
    private Timestamp H_startTime;
    private Timestamp H_endTime;

    public Homework(){}

    public int getH_id() {
        return H_id;
    }

    public void setH_id(int h_id) {
        H_id = h_id;
    }

    public String getH_name() {
        return H_name;
    }

    public void setH_name(String h_name) {
        H_name = h_name;
    }

    public String getH_content() {
        return H_content;
    }

    public void setH_content(String h_content) {
        H_content = h_content;
    }

    public Timestamp getH_startTime() {
        return H_startTime;
    }

    public void setH_startTime(Timestamp h_startTime) {
        H_startTime = h_startTime;
    }

    public Timestamp getH_endTime() {
        return H_endTime;
    }

    public void setH_endTime(Timestamp h_endTime) {
        H_endTime = h_endTime;
    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "H_id=" + H_id +
                ", H_name='" + H_name + '\'' +
                ", H_content='" + H_content + '\'' +
                ", H_startTime=" + H_startTime +
                ", H_endTime=" + H_endTime +
                '}';
    }
}
