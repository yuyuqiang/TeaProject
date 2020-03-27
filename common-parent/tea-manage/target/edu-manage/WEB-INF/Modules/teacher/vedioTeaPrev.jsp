<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>


</head>
<body>
  <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
    <tr bgcolor="#E7E7E7">
    </tr>
    <tr align="center" bgcolor="#FAFAF1" height="22">
        <td width="4%">序号</td>
        <td width="25%">标题</td>
        <td width="10%">附件</td>
        <td width="10%">操作</td>
    </tr>

    <c:forEach items="${page.list}" var="v"  varStatus="status">
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td bgcolor="#FFFFFF" align="center">
                    ${status.index+1}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${v.vedioName}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${v.vedioAttachment}
                &nbsp;&nbsp;&nbsp;
                <a href="#" onclick="down1('${v.vedioAttachment}','${v.attachmentOldName}')" style="font-size: 10px;color: red">down</a>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    <%--取消链接的默认行为 --%>
                <a href="javascript:void(0)" onclick="delVedio(${v.vedioId})"  class="pn-loperator">删除</a>

            </td>
        </tr>
    </c:forEach>

</table>
  <%@ include file="/WEB-INF/Modules/pageFile.jsp" %>

<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
    <tr>
        <td>
            <input href="javascript:void(0)" type="button" value="添加教学视频" style="width: 120px;" onclick="vedioAdd()" />
        </td>
    </tr>
</table>
</body>

<script>
    function delVedio(vId){
        //做删除视频之前的确认提示
        if(confirm("确认删除当前的视频吗?")){
            //向服务端发起请求，将当前正在删除的视频的编号发送到服务端
            location.href="${pageContext.request.contextPath}/vedio/deleteVedioByTeacher.do?id="+vId;
        }
    }

    function vedioAdd(){
            location.href="${pageContext.request.contextPath}/vedio/vedioAddUI.do";
    }
</script>
</html>
