<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/21
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
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

  <c:forEach items="${list}"  var="hw">
   <div class="ui divided items" style="margin-top: 10px!important;">

     <div class="item">
        <div class="content">
            <a class="header" href="${pageContext.request.contextPath}/user/homeworkPrev.do?id=${hw.H_id}">
                    ${hw.H_name}
            </a>
            <div class="meta">
                <span class="cinema">${hw.H_startTime}</span>
            </div>
            <div class="description">
                <p>${hw.H_content}</p>
            </div>
            <div class="extra">
                <div class="ui right floated primary button">详情 <i class="right chevron icon"></i> </div>
            </div>
        </div>
    </div>
  </div>
  </c:forEach>




<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>



</body>
</html>
