
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>

    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/me.css"/>

    <style type="text/css">
        .c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
        .f-right{float:right}
        .f-left{float:left}
        .clear{clear:both}
    </style>



</head>
<body>
 <div id="wrapper">
    <div id="header"></div>
<%--    <div id="left">--%>
<%--        <jsp:include flush="true" page="/site/left.jsp"></jsp:include>--%>
<%--    </div>--%>
    <div id="right">
        <!-- 111 -->
        <h3>教学视频</h3>
        <hr>
        <div id="welcome">
            <div>
                <div class="c1-body">
                    <table width="100%" border="0">
                        <tr>
                            <td align="center">${vedio.vedioName}<hr/></td>
                        </tr>
                        <tr>
                            <td align="center" style="word-break:break-all;">视频介绍：
                                ${vedio.vedioPro}
                                <hr/>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">
                                <a href="${pageContext.request.contextPath}/vedio/vedioUpdown.do?id=${vedio.vedioId}" style="font-size: 13px;color: red">${vedio.vedioName}</a>
                                <a  class="pn-loperator" style="color: red"
                                        href="${pageContext.request.contextPath}/vedio/playVedio.do?id=${vedio.vedioId}" >播放</a>

                                <hr/>
                            </td>
                        </tr>
                        <tr>
                            <td align="center">发布时间:${vedio.uploadTime}<hr/></td>
                        </tr>
                    </table>
                </div>
            </div>
            <!-- <p class="more"><a href="#">more</a></p> -->
        </div>
        <!-- 111 -->
    </div>
    <div class="clear"> </div>

</div>
</body>
</html>
