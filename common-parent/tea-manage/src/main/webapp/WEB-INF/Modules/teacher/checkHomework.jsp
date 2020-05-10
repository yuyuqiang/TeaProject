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
<body style="margin-left: 20px;margin-top: 20px">
 <form id="fm" action="${pageContext.request.contextPath}/teacher/publishHomeworkUI.do" name="formAdd" method="post" enctype="multipart/form-data">
     <h4>未评分</h4>
     <table class="ui celled table">
         <thead>
         <tr align="center"><th>序号</th>
             <th>学号</th>
             <th>作业备注</th>
             <th>附件</th>
             <th>成绩</th>
             <th>操作</th>
         </tr></thead>
         <tbody>
          <c:forEach items="${list}"  var="hw" varStatus="status">
           <tr align="center">
             <td data-label="序号" style="width: 5%">${status.index+1}</td>
             <td data-label="学号">${hw.stu_id}</td>
             <td data-label="作业">${hw.shw_content}</td>
             <td data-label="附件">
                 <a href="${pageContext.request.contextPath}/teacher/studentHomeworkDown.do?id=${hw.id}" style="font-size: 13px;color: #3e8cff">${hw.homeOldname}</a>
             </td>
             <td data-label="成绩">${hw.grade}</td>
             <td  data-label="评分" >
                 <a href="#" name="rating" id="rating" onclick="rating(${hw.h_id},${hw.id},${hw.stu_id})" >评分</a>
             </td>
           </tr>
          </c:forEach>
         </tbody>
     </table>
     <h4>已评分</h4>
     <table class="ui celled table">
         <thead>
         <tr align="center"><th>序号</th>
             <th>学号</th>
             <th>作业备注</th>
             <th>附件</th>
             <th>成绩</th>
             <th>操作</th>
         </tr></thead>
         <tbody>
         <c:forEach items="${list1}"  var="hw" varStatus="status">
             <tr align="center">
                 <td data-label="序号" style="width: 5%">${status.index+1}</td>
                 <td data-label="学号">${hw.stu_id}</td>
                 <td data-label="作业">${hw.shw_content}</td>
                 <td data-label="附件">
                     <a href="${pageContext.request.contextPath}/teacher/studentHomeworkDown.do?id=${hw.id}" style="font-size: 13px;color: #3e8cff">${hw.homeOldname}</a>
                 </td>
                 <td data-label="成绩">${hw.grade}</td>
                 <td  data-label="评分" >
                     <a href="#" name="rating1" id="rating1" onclick="rating(${hw.h_id},${hw.id},${hw.stu_id})" >评分</a>
                 </td>
             </tr>
         </c:forEach>
         </tbody>
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
    function rating(hid,id,sid) {
        var grade;
        grade = window.prompt("请录入学生成绩：")
        window.location.href="${pageContext.request.contextPath}/teacher/teacherSubmitGrade.do?grade="+grade+"&hid="+hid+"&id="+id+"&sid="+sid;
    }
</script>
</html>
