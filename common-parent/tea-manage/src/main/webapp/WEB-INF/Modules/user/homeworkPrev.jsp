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
<body style="margin-left: 20px">


<%--  <div class="ui divided items" style="margin-top: 10px!important;">--%>
<%--    <c:forEach items="${list}"  var="hw">--%>
<%--     <div class="item">--%>
<%--        <div class="content">--%>
<%--            <a class="header" href="${pageContext.request.contextPath}/user/homeworkPrev.do?id=${hw.id}">--%>
<%--                    ${hw.h_name}--%>
<%--            </a>--%>
<%--            <div class="meta">--%>
<%--                <span class="cinema">开始时间：${hw.h_startTime}</span>--%>
<%--            </div>--%>
<%--            <div class="meta" style="margin-top: -20px;margin-left: 300px">--%>
<%--                <span class="cinema" style="color: #0e93d7">最后提交时间：${hw.h_subTime}</span>--%>
<%--            </div>--%>
<%--            <h4 style="margin-top: -20px;margin-left: 650px;color: #56c756">分数: ${hw.grade}</h4>--%>
<%--            <div class="description">--%>
<%--                <p>作业内容：${hw.h_content}</p>--%>
<%--            </div>--%>
<%--            <c:if test="${nowTime < hw.h_endTime.time}">--%>
<%--                <div class="extra" >--%>
<%--                    <a class="ui right floated primary button" href="${pageContext.request.contextPath}/user/homeworkDetail.do?h_name=${hw.h_name}">详情--%>
<%--                        <i class="right chevron icon"></i>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </c:if>--%>
<%--            <c:if test="${nowTime > hw.h_endTime.time}">--%>
<%--                <div class="extra" >--%>
<%--                    <a class="ui right floated primary button" href="${pageContext.request.contextPath}/user/homeworkDetail.do?h_name=${hw.h_name}">已结束--%>
<%--                        <i class="right chevron icon"></i>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </c:if>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--    </c:forEach>--%>
<%--  </div>--%>



<h3 style="margin-top: 10px">课堂作业</h3>

       <div class="ui four cards">
           <c:forEach items="${list}"  var="hw">
           <div class="ui card" style="margin-top: 20px;margin-left: 12px;width: 230px;">
               <div class="content">
                   <div class="header">
                               ${hw.h_name}
                   </div>
                   <div class="meta">
                       <c:if test="${nowTime < hw.h_endTime.time}">
                           <span class="category" style="color: blue">${hw.h_endTime}</span>
                       </c:if>

                       <c:if test="${nowTime > hw.h_endTime.time}">
                           <span class="category">已结束</span>
                       </c:if>
                       <c:if test="${hw.grade==0.0}">
                           <span class="right floated time" >未评分</span>
                       </c:if>
                       <c:if test="${hw.grade!= 0.0}">
                           <span class="right floated time" style="color: #56C756">${hw.grade}分</span>
                       </c:if>

                   </div>
               </div>
               <div class="content"style="height: 150px">
                   <h4 class="ui sub header">作业内容</h4>
                   <div class="ui small feed">
                       <div class="event">
                           <div class="content">
                                   ${hw.h_content}
                           </div>
                       </div>
                   </div>
               </div>
               <div class="extra content">
                   <a class="ui blue button" href="${pageContext.request.contextPath}/user/homeworkDetail.do?h_name=${hw.h_name}">详情
                   </a>
               </div>
           </div>
           </c:forEach>

       </div>







<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>



</body>

</html>
