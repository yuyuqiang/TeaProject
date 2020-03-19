<%@ page import="javax.xml.crypto.dom.DOMCryptoContext" %>
<%@ page import="me.zhangyu.model.User" %>
<%@ page import="me.zhangyu.service.IUserService" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<meta charset="UTF-8">
	<title>教学辅助系统后台登录</title>

	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/css/login.css" media="all">
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>

</head>
<body class="layui-bg-black">
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
	<h1>
		 <strong>教学辅助系统后台登录</strong>
		 <em>Management System</em>
	</h1>
  <form class="layui-form" action="<%=basePath%>/user/index.do" method="post">
	<div class="layui-user-icon larry-login">
		 <input type="text" placeholder="账号" name="username" class="login_txtbx"/>
	</div>
	<div class="layui-pwd-icon larry-login">
		 <input type="password" placeholder="密码" name="password" class="login_txtbx"/>
	</div>

    <div class="layui-submit larry-login">
<%--    	<input type="button" value="立即登陆" class="submit_btn" lay-filter="login"/>--%>
		<button class="submit_btn "  lay-filter="login">立即登录
			<a href="#"
			   onclick="Common.switchNavigation(this);"
			   data-url="${pageContext.request.contextPath}/user/index.do"></a>
		</button>


	</div>
  </form>
</div>

</body>
</html>