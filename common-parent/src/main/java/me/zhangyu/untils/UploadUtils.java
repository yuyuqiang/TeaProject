package me.zhangyu.untils;

public class UploadUtils {
    /**
     * 获取随机名称
     * @param realName 真实名称
     * @return uuid
     */
    public static String getUUIDName(String realName){
        //realname  可能是 11.mp4
        //获取后缀名
        int index = realName.lastIndexOf(".");

        String uuidName=UUIDUtils.getId();
        System.out.println("bbbbbbbb"+uuidName+realName.substring(index+1));
        return uuidName+realName.substring(index);

    }

    /**
     * 获取文件真实名称
     * @param name
     * @return
     */
    public static String getRealName(String name){
        // c:/upload/1.jpg    1.jpg
        //获取最后一个"/"
        int index = name.lastIndexOf("\\");
        return name.substring(index+1);
    }

    /**
     * 获取文件目录
     * @param name 文件名称
     * @return 目录
     */
    public static String getDir(String name){
        int i = name.hashCode();
        String hex = Integer.toHexString(i);
        int j=hex.length();
        for(int k=0;k<8-j;k++){
            hex="0"+hex;
        }
        return "/"+hex.charAt(0)+"/"+hex.charAt(1);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //String s="G:\\day17-基础加强\\resource\\1.jpg";
        String s="1.jgp";
        String realName = getRealName(s);
        //System.out.println(realName);

        String uuidName = getUUIDName(realName);
        //System.out.println(uuidName);

        String dir = getDir(realName);
        System.out.println(dir);


    }
}
