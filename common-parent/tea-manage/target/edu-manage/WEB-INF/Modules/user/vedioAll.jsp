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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/me.css"/>
    <style type="text/css">
        .c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
        .f-right{float:right}
        .f-left{float:left}
        .clear{clear:both}

    </style>
</head>

<body  style="margin-left: 20px">
<%--<div>--%>
<%--    <h3>教学视频</h3>--%>
<%--    <hr>--%>
<%--    <div id="welcome">--%>
<%--        <div>--%>
<%--            <div class="c1-body">--%>

<%--                <c:forEach  items="${page.list}" var="v">--%>
<%--                    <div class="c1-bline" style="padding:7px 0px;">--%>
<%--                        <div class="f-left">--%>
<%--                            <img src="${pageContext.request.contextPath}/assets1/Images/head-mark4.gif"--%>
<%--                                 align="middle"--%>
<%--                                 class="img-vm" border="0"/>--%>
<%--                            <a href="${pageContext.request.contextPath}/vedio/vedioDetail.do?id=${v.vedioId}">--%>
<%--                                    ${v.vedioName}--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="f-right">${v.uploadTime}</div>--%>
<%--                        <div class="clear"></div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--                <%@ include file="/WEB-INF/Modules/pageFile.jsp" %>--%>
<%--                <div class="pg-3"></div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--&lt;%&ndash;        <p class="more"><a href="${pageContext.request.contextPath}/vedio/pageVedio.do&num=1">more</a></p>&ndash;%&gt;--%>

<%--    </div>--%>
<%--</div>--%>
<div>
    <h3 style="margin-top: 10px">教学视频</h3>

    <%--  <c:forEach  items="${page.list}" var="v">--%>
    <%--    <div class="ui special cards">--%>
    <%--        <div class="card">--%>
    <%--            <div class="blurring dimmable image" style="height: 100px!important;">--%>
    <%--                <div class="ui dimmer">--%>
    <%--                    <div class="content">--%>
    <%--                        <div class="center">--%>
    <%--                           <a href="">--%>
    <%--                               <i class="play icon"></i>--%>
    <%--                           </a>--%>
    <%--&lt;%&ndash;                            <div class="ui inverted button">添加好友</div>&ndash;%&gt;--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--&lt;%&ndash;                <img src="E:\TeachingWebsite\TeaProject\common-parent\tea-manage\src\main\webapp\WEB-INF\Modules\upload\\${v.imageAttachment}">&ndash;%&gt;--%>
    <%--                <img src="${pageContext.request.contextPath}/assets1/upload/${v.imageAttachment}">--%>
    <%--            </div>--%>
    <%--            <div class="content">--%>
    <%--                <a class="header"> ${v.vedioName}</a>--%>
    <%--                <div class="meta">--%>
    <%--                    <span class="date">更新于${v.uploadTime}</span>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <div class="extra content">--%>
    <%--                <a><i class="users icon"></i> ${v.downNum} 已查看 </a>--%>
    <%--                <i class="download icon"></i>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--     </div>--%>
    <%--  </c:forEach>--%>
    <c:forEach  items="${page.list}" var="v">

        <div class="ui divided items">
            <div class="item" >
                <div class="ui special cards">
                    <div class="blurring dimmable image" style="height: 160px;width: 300px">
                        <div class="ui dimmer">
                            <div class="content">
                                <div class="content">

                                    <a href="${pageContext.request.contextPath}/vedio/playVedio.do?id=${v.vedioId}" >
                                        <i class="play big icon"></i>
                                    </a>
                                        <%--                           <button class="ui icon button">--%>
                                        <%--                                  <i class="play huge icon"></i>--%>
                                        <%--                           </button>--%>
                                </div>

                            </div>
                        </div>
                        <img style="height: 160px;width: 300px" src="${pageContext.request.contextPath}/assets1/upload/${v.imageAttachment}">
                    </div>
                </div>
                <div class="content" style="margin-left: 40px">
                    <a class="header">${v.vedioName}</a>
                    <div class="meta">
                        <span class="cinema">更新于${v.uploadTime}</span>
                    </div>
                    <div class="description">
                        <p>${v.vedioPro}</p>
                    </div>
                    <div class="extra">
                        <div href="" class="ui right floated primary button" onclick="down(${v.vedioId})">下载 <i class="right download icon"></i> </div>
                        <div class="ui label">VEDIO</div>
                        <div class="ui label"><i class="users icon"></i> ${v.downNum} 人查看</div>
                    </div>
                </div>
            </div>

            <div class="item" style="margin-top: 20px">
                <div class="content">
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>

<script>
    $('.special.cards .image').dimmer({
        on: 'hover'
    });
    function down(vid) {
        location.href="${pageContext.request.contextPath}/vedio/vedioUpdown.do?id="+vid;
    }
</script>

</body>

</html>
