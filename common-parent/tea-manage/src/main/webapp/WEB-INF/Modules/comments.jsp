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
<body>

 <script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
</body>
<div class="ui comments">
    <h3 class="ui dividing header">Comments</h3>
    <div class="comment">
        <a class="avatar">
            <img src="/images/avatar/small/matt.jpg">
        </a>
        <div class="content">
            <a class="author">Matt</a>
            <div class="metadata">
                <span class="date">今天下午 5:42</span>
            </div>
            <div class="text">太赞了！ </div>
            <div class="actions">
                <a class="reply">Reply</a>
            </div>
        </div>
    </div>
    <div class="comment">
        <a class="avatar">
            <img src="/images/avatar/small/elliot.jpg">
        </a>
        <div class="content">
            <a class="author">Elliot Fu</a>
            <div class="metadata">
                <span class="date">昨天上午12:30</span>
            </div>
            <div class="text">
                <p>這對我的研究是非常有用.謝謝!</p>
            </div>
            <div class="actions">
                <a class="reply">Reply</a>
            </div>
        </div>
        <div class="comments">
            <div class="comment">
                <a class="avatar">
                    <img src="/images/avatar/small/jenny.jpg">
                </a>
                <div class="content">
                    <a class="author">Jenny Hess</a>
                    <div class="metadata">
                        <span class="date">刚刚</span>
                    </div>
                    <div class="text">艾略特你永远是多么正确 :) </div>
                    <div class="actions">
                        <a class="reply">Reply</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="comment">
        <a class="avatar">
            <img src="/images/avatar/small/joe.jpg">
        </a>
        <div class="content">
            <a class="author">Joe Henderson</a>
            <div class="metadata">
                <span class="date">5 天以前</span>
            </div>
            <div class="text">老兄，这太棒了。非常感谢。 </div>
            <div class="actions">
                <a class="reply">Reply</a>
            </div>
        </div>
    </div>
    <form class="ui reply form">
        <div class="field">
            <textarea></textarea>
        </div>
        <div class="ui blue labeled submit icon button"><i class="icon edit"></i> Add Reply </div>
    </form>
</div>
</html>
