<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="copyright" content="All Rights Reserved, Copyright (C) 2013, 猿来入此, Ltd." />
    <title>试题</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/home/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/home/css/layer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/home/css/other.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/home/css/validationEngine.jquery.css">
    <script src="${pageContext.request.contextPath}/static/home/js/jquery.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/home/js/baseutil.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/home/js/aes.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/home/js/pad-zeropadding-min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/home/js/layer.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/home/js/jquery.validationEngine.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/home/js/jquery.validationEngine-zh_CN.js" type="text/javascript"></script>

</head>
<body>

<div class="tm_main">


    <div class="tm_container">
        <div class="tm_navtitle">
            <h1>历史考试</h1>
            <span>历史考试，请选择以下列表中我参加过的考试进行详情查看。</span>
        </div>
    </div>

    <div class="tm_container">
        <form action="history_list.do" method="get">
            <div class="tm_searchbox">
                考试名称 :
                <input type="text" name="name" class="tm_txts" size="10" maxlength="20" value="${name }" /> &nbsp;
                <button class="tm_btns" type="submit">搜索</button>
            </div>

            <table width="100%" cellpadding="10" border="0" class="tm_table_list">
                <thead>
                <tr>
                    <th>考试名称</th>
                    <th>考试状态</th>
                    <th>考试时长</th>
                    <th>考试耗时</th>
                    <th>考试时间</th>
                    <th>考试专业</th>
                    <th>试卷得分</th>
                    <th>及格分数/卷面总分</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty historyList}">
                    <tr>
                        <td colspan="9">你还没有考过试!</td>
                    </tr>
                </c:if>

                <c:forEach items="${historyList }" var = "history">
                    <tr>
                        <td>${history.exam.name}</td>
                        <td>已批阅</td>
                        <td><span class="tm_label">${history.exam.avaliableTime}</span> 分钟</td>
                        <td><span class="tm_label">${history.useTime}</span> 分钟</td>
                        <td>
                            <fmt:formatDate value="${history.startExamTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                            <br/><fmt:formatDate value="${history.endExamTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td >${subject.name }</td>
                        <td>
                            <span class="tm_label">${history.score}</span>
                            <c:if test="${history.exam.passScore > history.score }">
                                <font color="red"><b>不及格</b></font>
                            </c:if>
                        </td>
                        <td >${history.exam.passScore }/${history.exam.totalScore }</td>
                        <td>
                            <a href="review_exam.do?examId=${history.exam.id }&examPaperId=${history.id}" target="_blank" class="tm_btn tm_btn_primary" style="text-decoration:none;color:white;" >回顾试卷</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
        <table width="100%" cellpadding="10" border="0" class="tm_table_list">
            <tfoot>
            <tr>
                <td>
                    <div class="tm_pager_foot">
                        <a href="history_list.do?page=${page - 1}" class="tm_btns" style="color:white;text-decoration:none;">上一页</a>&nbsp;&nbsp;&nbsp;<font size="5" color="red"><b>${page}</b></font>&nbsp;&nbsp;&nbsp;<a href="history_list.do?page=${page + 1}" class="tm_btns" style="color:white;text-decoration:none;">下一页</a>&nbsp;
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>


</div>
<script type="text/javascript">
    window.onload = function(){
        $(".tm_table_list tbody tr").mouseover(function(){
            $(this).attr("style","background:#f5f5f5");
        });
        $(".tm_table_list tbody tr").mouseout(function(){
            $(this).attr("style","background:#ffffff");
        });
    }
</script>
</body>


</html>
