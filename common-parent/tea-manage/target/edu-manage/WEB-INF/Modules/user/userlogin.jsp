<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/21
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="stylesheet" herf="${pageContext.request.contextPath}/static/css/me.css">
</head>
<body>

<br>
<br>
<br>
<br>
<br>
<br>

<div class="m-container-small m-padded-tb-massive" style="max-width:60em !important;">
    <div class="ur container"style="padding-left: 30em !important;">
        <div class="ui middle aligned center aligned grid">
            <div class="column">
                <h2 class="ui teal image header">
                    <div class="content">
                        《软件工程》教学辅助系统
                    </div>
                </h2>
                <form class="ui large form" name="ThisForm" method="post" action="" id="fm">
                    <div class="ui stacked segment">
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="user icon"></i>
                                <input type="text"id="username" name="username" placeholder="用户名">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="lock icon"></i>
                                <input type="password"id="password" name="password" placeholder="密码">
                            </div>
                        </div>
                        <div>
                            <div class="ui fluid large teal submit button" id="btnLogin" style="width:299px!important;" onclick='check1()'>登  录</div>
                            <%--                            <h5 style="font-family: 微软雅黑 ;margin-left: 193px;margin-top: -27px">类型：</h5>--%>

                            <%--                               <select class="INPUT_text" name="userType" style="height:20px;width:80px;margin-left: 310px;margin-top: -33px">--%>
                            <%--                                       <option value="0"selected="selected">老师</option>--%>
                            <%--                                       <option value="1">学生</option>--%>
                            <%--                                      </select>--%>
                            <select class="ui dropdown"name="userType" style="width:80px!important;margin-left: 308px;margin-top: -40px">

                                <option value="0">老师</option>
                                <option value="1">学生</option>
                            </select>

                        </div>
                    </div>

                    <div class="ui error mini message"></div>
                    <%--                    <div class="ui mini message" th:unless="${strings.isEmpty(message)}" th:text="${message}"></div>--%>


                </form>

            </div>
        </div>

    </div>

</div>



<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>

<%--<script>--%>
<%--    $(function(){--%>
<%--        //页面加载完毕--%>
<%--        //获取id为username的文本框，为其绑定失去焦点事件--%>
<%--        $("#username").blur(function(){--%>
<%--            //获取到用户输入的学号信息，如果为空提示请录入学号--%>
<%--            var um=$("#username").val();//获取到文本框的值--%>
<%--            var username=$.trim(um);--%>

<%--            if(null!=username&&""!=username){--%>
<%--                //向服务端发起ajax请求，将用户录入的学号信息发送到服务端--%>
<%--                $.post("${pageContext.request.contextPath}/user/login.do",{"username":username},function(data){--%>
<%--                    //打印服务端响应回客户端的数据--%>

<%--                    console.log(data);--%>

<%--                    if(data=="yes"){--%>
<%--                        $("#stuNumMsg").html("");--%>

<%--                    }--%>

<%--                    if(data=="no"){--%>
<%--                        $("#stuNumMsg").html("不存在此户名,请录入合适用户名");--%>

<%--                    }--%>
<%--                });--%>
<%--            }else{--%>
<%--                //如果为空提示请录入学号--%>
<%--                alert("请输入学号");--%>
<%--            }--%>
<%--        });--%>


<%--        //获取id为btnLogin登录按钮，为其绑定点击事件--%>
<%--        $("#btnLogin").click(function(){--%>
<%--            //校验用户名和密码不能为空--%>
<%--            //获取用户名--%>
<%--            var username=$("#username").val();--%>
<%--            //获取密码--%>
<%--            var password=$("#password").val();--%>
<%--            //截取字符串--%>
<%--            var um=$.trim(username);--%>
<%--            var up=$.trim(password);--%>
<%--            if(null==um||""==um){--%>
<%--                alert("请输入合法的学号");--%>
<%--                return false;--%>
<%--            }--%>

<%--            if(null==up||""==up){--%>
<%--                alert("请输入合法的密码");--%>
<%--                return false;--%>
<%--            }--%>

<%--            //利用JS实现登录--%>
<%--            document.getElementById("fm").submit();--%>

<%--        });--%>

<%--    });--%>

<%--    // function logout(){--%>
<%--    //     //用户确认提示--%>
<%--    //     if(confirm("确定要退出吗?")){--%>
<%--    //         location.href="/czjf_system/StuServlet?method=stuLogout";--%>
<%--    //     }--%>
<%--    // }--%>


<%--</script>--%>

<script>

    function check1(){
        $('.ui.form').form({
            fields : {
                username : {
                    identifier: 'username',
                    rules: [{
                        type : 'empty',
                        prompt: '请输入用户名'
                    }]
                },
                password : {
                    identifier: 'password',
                    rules: [{
                        type : 'empty',
                        prompt: '请输入密码'
                    }]
                }
            }
        });

        //判断用户选择的类型
        if(document.ThisForm.userType.value=="0"){

            //向老师模块进行提交
            document.getElementById("fm").action="${pageContext.request.contextPath}/teacher/teaLogin.do";
        }

        if(document.ThisForm.userType.value=="1"){
            //向学生模块进行提交

            document.getElementById("fm").action="${pageContext.request.contextPath}/user/login.do";

        }
        document.getElementById("fm").submit();
    }
</script>

</body>
</html>
