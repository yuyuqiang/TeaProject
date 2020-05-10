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
<form action="${pageContext.request.contextPath}/rar/addRar.do" name="formAdd" method="post" enctype="multipart/form-data">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">

        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                课件标题：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" id="rarName" name="rarName" style="width: 360px;"/>
            </td>
        </tr>

        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                附件上传：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="file" name="araName" id="araName" style="width: 360px;"/>
            </td>
        </tr>

        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                &nbsp;
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="submit" value="提交" onclick="return check()"/>&nbsp;
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function check(){
        //获取视频标题，介绍，非空检验
        var name=$("#araName").val();
        //截取空格
        var nm=$.trim(name);

        if(null==nm||""==nm){
            alert("标题不能为空");
            return false; //如果return false 会对表单进行提交
        }
        return true;
    }
</script>
</html>
