<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 21:28
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

                <c:forEach  items="${page.list}" var="v">
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
                <%@ include file="/WEB-INF/Modules/pageFile.jsp" %>
<%--                <div style="text-align: center;">--%>
<%--                    共${page.totalPageNum}页/第${page.currentPageNum}页--%>
<%--                    <a href="${pageContext.request.contextPath}/vedio/vedioAll.do?num=1">首页</a>--%>
<%--                    <a href="${pageContext.request.contextPath}/vedio/vedioAll.do?num=${page.prevPageNum}">上一页</a>--%>

<%--                    <c:forEach begin="${page.startPage}"  end="${page.endPage}" var="i">--%>
<%--                        <a href="${pageContext.request.contextPath}/vedio/vedioAll.do?num=${i}">${i}</a>--%>
<%--                    </c:forEach>--%>

<%--                    <a href="${pageContext.request.contextPath}/vedio/vedioAll.do?num=${page.nextPageNum}">下一页</a>--%>
<%--                    <a href="${pageContext.request.contextPath}/vedio/vedioAll.do?num=${page.totalPageNum}">末页</a>--%>

<%--                    <input type="text" name="pagenum" id="pagenum" size="1"/>--%>
<%--                    <input type="button" value="前往" onclick="jump()"/>--%>
<%--                    <script type="text/javascript">--%>
<%--                        function jump(){--%>
<%--                            var totalPage=${page.totalPageNum};--%>
<%--                            //获取用户输入内容--%>
<%--                            var pagenum=document.getElementById("pagenum").value;--%>
<%--                            //如果用户输入的是字母，提示请输入合法的数字--%>
<%--                            //如果用户输入是数字，但是大于总页数，提示请输入合法的页数--%>
<%--                            var reg =/^[1-9][0-9]{0,1}$/;--%>
<%--                            if(!reg.test(pagenum)){--%>
<%--                                //不是一个有效数字--%>
<%--                                alert("请输入符合规定的数字");--%>
<%--                                return ;--%>
<%--                            } if(parseInt(pagenum)>parseInt(${page.totalPageNum})){--%>
<%--                                //超过了总页数--%>
<%--                                alert("不能大于总页数");--%>
<%--                                return;--%>
<%--                            }--%>
<%--                            //如果输入的是数字，而且小于总页数，跳转到指定的页数--%>
<%--                           window.location.href="${pageContext.request.contextPath}/vedio/vedioAll.do?num="+pagenum;--%>
<%--                        }--%>
<%--                    </script>--%>
<%--                </div>--%>

                <div class="pg-3"></div>
            </div>
        </div>
<%--        <p class="more"><a href="${pageContext.request.contextPath}/vedio/pageVedio.do&num=1">more</a></p>--%>

    </div>
</div>


</body>
</html>
