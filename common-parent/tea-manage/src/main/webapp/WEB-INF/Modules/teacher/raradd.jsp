<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/27
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
</head>
<body >
<form action="${pageContext.request.contextPath}/vedio/addVedio.do" name="formAdd" method="post" enctype="multipart/form-data">

</form>
</body>
<script>
    function check(){
        //获取视频标题，介绍，非空检验
        var name=$("#vedioName").val();
        var pro=$("#vedioPro").val();
        //截取空格
        var nm=$.trim(name);
        var pr=$.trim(pro);

        if(null==nm||""==nm){
            alert("标题不能为空");
            return false; //如果return false 会对表单进行提交
        }

        if(null==pr||""==pr){
            alert("介绍不能为空");
            return false; //如果return false 会对表单进行提交
        }
        return true;
    }
</script>
</html>
