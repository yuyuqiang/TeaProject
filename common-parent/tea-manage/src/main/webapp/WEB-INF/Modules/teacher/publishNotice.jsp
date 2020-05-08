<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/30
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <title>发布公告</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link href="https://cdn.bootcss.com/semantic-ui-calendar/0.0.8/calendar.css" rel="stylesheet">

</head>
<body>
 <form id="fm" action="${pageContext.request.contextPath}/teacher/publishHomework.do" method="post">
     <div class="ui segment" >
         <div class="ui modal">
             <div class="header">Header</div>
             <div class="content">
                 <p></p>
             </div>
             <div class="actions">
                 <div class="ui approve button">Approve</div>
                 <div class="ui button">Neutral</div>
                 <div class="ui cancel button">Cancel</div>
             </div>
         </div>
     </div>

 </form>

 <script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
 <script src="https://cdn.bootcss.com/semantic-ui-calendar/0.0.8/calendar.js"></script>
</body>
<script>
    $('.ui.modal')
        .modal('show')
    ;
</script>


</html>
