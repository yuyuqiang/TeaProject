<%@ page import="javax.xml.crypto.dom.DOMCryptoContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>教学辅助系统后台登录</title>

	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/css/login.css" media="all">
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>
	<link rel="shortcut icon" href="#" />
</head>
<body class="layui-bg-black">
  <div class="layui-canvs"></div>
  <div class="layui-layout layui-layout-login">
	<h1>
		 <strong>教学辅助系统后台登录</strong>
		 <em>Management System</em>
	</h1>
    <form name="ThisForm" action="${pageContext.request.contextPath}/admin/adminLogin.do" method="post" id="fm">
	   <div class="layui-user-icon larry-login">
		 <input type="text" id="username" placeholder="账号" name="username" class="login_txtbx"/>
	   </div>
	   <div class="layui-pwd-icon larry-login">
		 <input type="password" id="password" placeholder="密码" name="password" class="login_txtbx"/>
	   </div>

        <div class="layui-submit larry-login">
<%--    	  <input id="login_btn" type="button" class="submit_btn" value="立即登陆" onclick='check1()' lay-filter="login"/>--%>
		<button class="submit_btn "  lay-filter="login">立即登录
			<a href="#"
			   onclick="Common.switchNavigation(this);"
			   data-url="${pageContext.request.contextPath}/admin/adminLogin.do"></a>
		</button>
		</div>
		<div>
			<span id="stuNumMsg" style="color:red;font-size:15px;align-content: center">${msg}</span>
		</div>
     </form>
  </div>
</body>
<%--<script>--%>
<%--	    $(function(){--%>
<%--	        //页面加载完毕--%>
<%--	        //获取id为username的文本框，为其绑定失去焦点事件--%>
<%--	        $("#username").blur(function(){--%>
<%--	            //获取到用户输入的账户信息，如果为空提示请录入学号--%>
<%--	            var um=$("#username").val();//获取到文本框的值--%>
<%--	            var username=$.trim(um);--%>
<%--	            if(null!=username&&""!=username){--%>
<%--	                //向服务端发起ajax请求，将用户录入的学号信息发送到服务端--%>
<%--	                $.post("${pageContext.request.contextPath}/admin/login.do",{"username":username},function(data){--%>
<%--	                    //打印服务端响应回客户端的数据--%>
<%--	                    console.log(data);--%>

<%--	                    if(data=="yes"){--%>
<%--	                        $("#stuNumMsg").html("");--%>

<%--	                    }--%>

<%--	                    if(data=="no"){--%>
<%--	                        $("#stuNumMsg").html("不存在此户名,请录入合适用户名");--%>

<%--	                    }--%>
<%--	                });--%>
<%--	            }else{--%>
<%--	                //如果为空提示请录入学号--%>
<%--	                alert("请输入学号");--%>
<%--	            }--%>
<%--	        });--%>

<%--			//获取id为btnLogin登录按钮，为其绑定点击事件--%>
<%--			$("login_btn").click(function(){--%>
<%--				//校验用户名和密码不能为空--%>
<%--				//获取用户名--%>
<%--				var username=$("#username").val();--%>
<%--				//获取密码--%>
<%--				var password=$("#password").val();--%>
<%--				//截取字符串--%>
<%--				var um=$.trim(username);--%>
<%--				var up=$.trim(password);--%>
<%--				if(null==um||""==um){--%>
<%--					alert("请输入合法的学号");--%>
<%--					return false;--%>
<%--				}--%>

<%--				if(null==up||""==up){--%>
<%--					alert("请输入合法的密码");--%>
<%--					return false;--%>
<%--				}--%>

<%--				//利用JS实现登录--%>
<%--				document.getElementById("fm").submit();--%>

<%--			});--%>
<%--		});--%>

<%--	 function check1() {--%>
<%--		 //校验用户名和密码不能为空--%>
<%--		 //获取用户名--%>
<%--		 var username=$("#username").val();--%>
<%--		 //获取密码--%>
<%--		 var password=$("#password").val();--%>
<%--		 //截取字符串--%>
<%--		 var um=$.trim(username);--%>
<%--		 var up=$.trim(password);--%>
<%--		 if(null==um||""==um){--%>
<%--			 alert("请输入合法的学号");--%>
<%--			 return false;--%>
<%--		 }--%>

<%--		 if(null==up||""==up){--%>
<%--			 alert("请输入合法的密码");--%>
<%--			 return false;--%>
<%--		 }--%>

<%--		 //利用JS实现登录--%>
<%--		 document.getElementById("fm").submit();--%>

<%--	 }--%>

<%--</script>--%>
</html>