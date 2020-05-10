package me.zhangyu.model;

public class Rar {
    private int id;
    private String rarName;
    private String rarAttachment;
    private String rarRealname;
    private String uploadTime;
    private int downNum;

    public int getDownNum() {
        return downNum;
    }

    public void setDownNum(int downNum) {
        this.downNum = downNum;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRarName() {
        return rarName;
    }

    public void setRarName(String rarName) {
        this.rarName = rarName;
    }

    public String getRarAttachment() {
        return rarAttachment;
    }

    public void setRarAttachment(String rarAttachment) {
        this.rarAttachment = rarAttachment;
    }

    public String getRarRealname() {
        return rarRealname;
    }

    public void setRarRealname(String rarRealname) {
        this.rarRealname = rarRealname;
    }
}
