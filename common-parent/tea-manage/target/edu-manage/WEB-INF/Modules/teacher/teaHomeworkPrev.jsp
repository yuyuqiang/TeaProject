<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/7
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <title>作业</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="stylesheet" herf="${pageContext.request.contextPath}/static/css/me.css">
</head>
<body>
 <form id="fm" action="${pageContext.request.contextPath}/teacher/publishHomeworkUI.do" name="formAdd" method="post" enctype="multipart/form-data">

  <table class="ui celled padded table">
    <thead>
    <tr align="center"><th class="single line">序号</th>
        <th>作业题目</th>
        <th>发布时间</th>
        <th>结束时间</th>
        <th>提交详情</th>
    </tr></thead>
    <tbody>
     <c:forEach items="${list}"  var="hw" varStatus="status">
      <tr align="center">
        <td>
            <h3 class="ui center aligned header"style="width: 5%">${status.index+1}</h3>
        </td>
        <td class="single line" style="width: 30%">${hw.h_name} </td>
        <td class="single line"style="width: 30%">${hw.h_startTime} </td>
        <td class="single line"style="width: 30%">${hw.h_endTime} </td>
        <td width="15%" bgcolor="#FFFFFF" align="center">
            <a href="#" onclick="checkHomework(${hw.h_id})" >查看</a>
        </td>
      </tr>
     </c:forEach>
    </tbody>
      <tfoot class="full-width">
      <tr>
          <th></th>
          <th colspan="4">
              <div class="ui right floated small primary labeled icon button" id="publish_btn" onclick="check();">
                  <i class="file alternate icon"></i>
                  <span>发布作业</span>
              </div>
          </th>
      </tr>
      </tfoot>
  </table>
 </form>
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
</body>
<script>
    function check(){
        //向服务端发起请求
        document.getElementById("fm").submit();
    }
    function checkHomework(hid){
        window.location.href="${pageContext.request.contextPath}/teacher/checkHomework.do?id="+hid;
    }
</script>
</html>
