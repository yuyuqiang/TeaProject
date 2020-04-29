<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>404</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/global.css" media="all">
</head>
<body class="childrenBody">
	<div style="text-align: center; padding:11% 0;">
		<i class="layui-icon" style="line-height:26rem; font-size:26rem; color: #393D50;"></i>
		<p style="font-size: 20px; font-weight: 300; color: #3e8cff;" onclick="login()">请重新登录账号!</p>
	</div>

</body>
<script>
	function login() {
		location.href="${pageContext.request.contextPath}/user/login.do"
	}
</script>
</html>