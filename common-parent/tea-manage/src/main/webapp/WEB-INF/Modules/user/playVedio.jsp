<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/24
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://cdn.bootcss.com/html5media/1.1.8/html5media.js"></script></head>
<body>

<h4 style="margin-left:100px;">教学资料>教学视频>${vedio.vedioName}</h4>
<div style="width:784px; margin:0 auto;border:3px solid #73a6c3;">
    <div style="width:100%; height:100%; margin-top:0px;border:0px solid green;padding:1px">
        <video width="100%" height="100%" controls="controls">

            <source type="video/mp4"
<%--                    src="E:/TeachingWebsite/TeaProject/common-parent/tea-manage/target/edu-manage/WEB-INF/Modules/upload/${vedio.vedioAttachment}"--%>
                    src="${pageContext.request.contextPath}/assets1/upload/${vedio.vedioAttachment}"
            />
        </video>
    </div>
</div>

</body>
</html>
