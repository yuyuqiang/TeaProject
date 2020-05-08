<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="IT教育系统" name="keywords" />
    <meta content="IT教育系统" name="description" />
    <title>《软件工程》辅助教学系统</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/bridging.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/common.js"></script>
</head>

<body style="background: #f5f5f5;">
<%--<form id="form1" >--%>
<%--    <!--====这里放主导航====-->--%>
<%--    <div class="header">--%>
<%--        <div class="header_nav">--%>
<%--            <nav>--%>
<%--                <ul id="showMainNav" class="fix">--%>

<%--                    <li class="navContent nav_current">--%>
<%--                        <a href="#" class="showNav" id="user" data-name="main_iframe"--%>
<%--                           onclick="Common.switchNavigation(this);"--%>
<%--                           data-url="${pageContext.request.contextPath}/user/manage.do">教学资料</a>--%>
<%--                    </li>--%>

<%--                    <li class="navContent">--%>
<%--                        <a href="#" class="showNav" id="exam" data-name="main_iframe"--%>
<%--                           onclick="Common.switchNavigation(this);"--%>
<%--                           data-url="${pageContext.request.contextPath}/user/examManage.do">在线测试</a>--%>
<%--                    </li>--%>
<%--                    <li class="navContent">--%>
<%--                        <a href="#" class="showNav" id="chat" data-name="main_iframe"--%>
<%--                           onclick="Common.switchNavigation(this);"--%>
<%--                           data-url="${pageContext.request.contextPath}/user/chat.do">聊天室</a>--%>
<%--                    </li>--%>

<%--                </ul>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--    </div>--%>

<div class="ui borderless main menu fixed" style="position: fixed; top: 0px; left: auto; z-index: 10;height: 65px">
    <div style="margin-top: 20px">
        <img  style="width: 180px;height:50px;margin-top: -17px"   src="${pageContext.request.contextPath}/assets1/Images/favicon.png">
    </div>
    <div class="ui text container" style="margin-left: 40px!important;">
        <a href="#" class="item" id="user" data-name="main_iframe"
           onclick="Common.switchNavigation(this);"
           data-url="${pageContext.request.contextPath}/user/manage.do">教学资料</a>

        <a href="#" class="item" id="exam" data-name="main_iframe"
           onclick="Common.switchNavigation(this);"
           data-url="${pageContext.request.contextPath}/user/examManage.do">在线测试</a>

        <a href="#" class="item" id="chat" data-name="main_iframe"
           onclick="Common.switchNavigation(this);"
           data-url="${pageContext.request.contextPath}/user/chat.do">聊天室</a>

    </div>
    <div style="margin-top: 20px;margin-right: 30px" >
        <h2 class="version"></h2>
        <img class="ui avatar image" style="height: 40px;width: 40px" src="${pageContext.request.contextPath}/assets1/Images/touxiang.jpg">
        <span class="header_hi">Hi,</span><span
            class="header_usename">${username}</span>！
        <a href="javascript:void(0)" onclick="this.href='#'">退出</a>
    </div>

</div>
<div class="ui borderless main menu placeholder" style="display: block; visibility: hidden;">
    <div class="ui text container">
    </div>
</div>


<!--====下面是主要内容区域====-->
    <div  id="main_iframe" class="index_mainIfram_position  mainIfram_position">
        <iframe class="main_iframe" id="home_iframe" frameborder="0"
                border="0" src="${pageContext.request.contextPath}/user/manage.do"></iframe>
    </div>
<%--</form>--%>

<div class="ui inverted vertical footer segment"style="height: 150px!important;">
    <div class="ui container">
        <div class="ui stackable inverted divided equal height stackable grid">
            <div class="three wide column">
                <h4 class="ui inverted header">About</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Sitemap</a>
                    <a href="#" class="item">Contact Us</a>
                    <a href="#" class="item">Religious Ceremonies</a>
                    <a href="#" class="item">Gazebo Plans</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header">Services</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Banana Pre-Order</a>
                    <a href="#" class="item">DNA FAQ</a>
                    <a href="#" class="item">How To Access</a>
                    <a href="#" class="item">Favorite X-Men</a>
                </div>
            </div>
            <div class="seven wide column">
                <h4 class="ui inverted header">Footer Header</h4>
                <p>Extra space for a call to action inside the footer that could help re-engage users.</p>
            </div>
        </div>
    </div>
</div>



</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
</html>
