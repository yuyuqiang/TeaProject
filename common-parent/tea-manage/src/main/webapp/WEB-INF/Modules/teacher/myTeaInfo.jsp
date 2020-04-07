<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/6
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />

</head>

<body>
  <form action="${pageContext.request.contextPath}/teacher/updateTeacher.do" name="formAdd" method="post">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="${pageContext.request.contextPath}/images/wbg.gif" class='title'><span>个人信息</span></td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                编号：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="teaNum" size="20" value="${teacher.teaNum}" readonly="readonly"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                姓名：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="teaRealname" size="20" value="${teacher.teaRealName}"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                性别：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <c:if test="${teacher.teaSex=='男'}">
                    <input type="radio" name="teaSex" value="男" checked="checked"/>男

                    <input type="radio" name="teaSex" value="女"/>女
                </c:if>
                <c:if test="${teacher.teaSex=='女'}">
                    <input type="radio" name="teaSex" value="男" />男

                    <input type="radio" name="teaSex" value="女" checked="checked"/>女
                </c:if>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                年龄：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="teaAge" size="20" value="${teacher.teaAge}"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                账号：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="loginName" size="20" value="${teacher.loginName}" readonly="readonly"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                密码：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="loginPwd" size="20" value="${teacher.loginPwd}"/>
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">

            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" name="teaId" value="${teacher.teaId}"/>
                <input type="submit" value="修改"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>