<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>教学视频</title>

    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/me.css"/>
    <style type="text/css">
        .c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
        .f-right{float:right}
        .f-left{float:left}
        .clear{clear:both}
    </style>
</head>
<body>
   <div>
       <h3>教学视频</h3>
       <hr>
       <div id="welcome">
           <div>
               <div class="c1-body">

                   <c:forEach items="${list}"  var="v">
                       <div class="c1-bline" style="padding:7px 0px;">
                           <div class="f-left">
                               <img src="${pageContext.request.contextPath}/assets1/Images/head-mark4.gif"
                                    align="middle"
                                    class="img-vm" border="0"/>
                               <a href="${pageContext.request.contextPath}/vedio/vedioDetail.do?id=${v.vedioId}">
                                       ${v.vedioName}
                               </a>
                           </div>
                           <div class="f-right">${v.uploadTime}</div>
                           <div class="clear"></div>
                       </div>
                   </c:forEach>

                   <div class="pg-3"></div>
               </div>
           </div>
           <p class="more"><a href="${pageContext.request.contextPath}/vedio/vedioAll.do?num=1" >more</a></p>

       </div>
   </div>


</body>
</html>
