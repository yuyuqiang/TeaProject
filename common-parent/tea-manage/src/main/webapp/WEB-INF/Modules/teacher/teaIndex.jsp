<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta content="IT教育系统" name="keywords" />
    <meta content="IT教育系统" name="description" />
    <title>《软件工程》辅助教学系统</title>
    <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/bridging.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/common.js"></script>
</head>

<body>
<form id="form1" >
    <!--====这里放主导航====-->
    <div class="header">
        <div class="header_top">
            <header>
                <div class="header_logo">
                    <h1>《软件工程》教学辅助网站</h1>
                </div>
                <div class="header_tab">
                    <ul>
                        <li><h2 class="version"></h2></li>
                        <li><span class="header_hi">Hi,</span><span
                                class="header_usename">张钰</span>！</li>
                        <li><a href="javascript:void(0)" onclick="this.href='#'">注销</a></li>
                        <li class="rel"><a href="#" class="system_infor"
                                           id="system_infor" onclick="showMessageList();">系统消息(0)</a>
                            <div id="Div1" class="dn"></div></li>
                        <li class="password_nav"><a href="#"
                                                    class="change_password nav_current otherNavigation">修改密码</a></li>
                        <li><a href="#">帮助中心</a></li>
                    </ul>
                    <div class="cf"></div>
                </div>
                <div class="cf"></div>
            </header>
        </div>
        <div class="header_nav">
            <nav>
                <ul id="showMainNav" class="fix">
                    <li class="navContent nav_current">
                        <a href="#" class="showNav" id="user" data-name="main_iframe"
                           onclick="Common.switchNavigation(this);"
                           data-url="${pageContext.request.contextPath}/teacher/teaManage.do">我的信息</a>
                    </li>

                    <li class="navContent">
                        <a href="#" class="showNav" id="resource" data-name="main_iframe"
                           onclick="Common.switchNavigation(this);"
                           data-url="${pageContext.request.contextPath}/teacher/teaManage.do">教学管理</a>
                    </li>

                    <li class="navContent">
                    <a href="#" class="showNav" id="salary" data-name="main_iframe"
                       onclick="Common.switchNavigation(this);"
                       data-url="${pageContext.request.contextPath}/salary/manage.do">社区</a>
                </li>
                </ul>
            </nav>
        </div>
    </div>

    <!--====下面是主要内容区域====-->
    <div id="main_iframe"
         class="index_mainIfram_position  mainIfram_position">
        <iframe class="main_iframe" id="home_iframe" frameborder="0"
                border="0" src="${pageContext.request.contextPath}/teacher/teaManage.do"></iframe>
    </div>

</form>
</body>
</html>
