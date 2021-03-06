package me.zhangyu.model;

public class Vedio {
    private int vedioId;
    private String vedioName;
    private String vedioPro; //视频简介
    private String vedioAttachment; //视频附件名称
    private String image;
    private String imageAttachment;
    private String attachmentOldName; //视频附件原始名称
    private String uploadTime;//上传时间
    private String del;//视频是否删除
    private int downNum;

    public String getImageAttachment() {
        return imageAttachment;
    }

    public void setImageAttachment(String imageAttachment) {
        this.imageAttachment = imageAttachment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDownNum() {
        return downNum;
    }

    public void setDownNum(int downNum) {
        this.downNum = downNum;
    }

    public Vedio() {

    }

    public int getVedioId() {
        return vedioId;
    }

    public void setVedioId(int vedioId) {
        this.vedioId = vedioId;
    }

    public String getVedioName() {
        return vedioName;
    }

    public void setVedioName(String vedioName) {
        this.vedioName = vedioName;
    }

    public String getVedioPro() {
        return vedioPro;
    }

    public void setVedioPro(String vedioPro) {
        this.vedioPro = vedioPro;
    }

    public String getVedioAttachment() {
        return vedioAttachment;
    }

    public void setVedioAttachment(String vedioAttachment) {
        this.vedioAttachment = vedioAttachment;
    }

    public String getAttachmentOldName() {
        return attachmentOldName;
    }

    public void setAttachmentOldName(String attachmentOldName) {
        this.attachmentOldName = attachmentOldName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Vedio{" +
                "vedioId=" + vedioId +
                ", vedioName='" + vedioName + '\'' +
                ", vedioPro='" + vedioPro + '\'' +
                ", vedioAttachment='" + vedioAttachment + '\'' +
                ", attachmentOldName='" + attachmentOldName + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", del='" + del + '\'' +
                '}';
    }
}
