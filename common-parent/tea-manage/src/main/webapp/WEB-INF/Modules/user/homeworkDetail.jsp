<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/21
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <title>作业详情</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="stylesheet" herf="${pageContext.request.contextPath}/static/css/me.css">

</head>
<body>
 <form id="fm" action="${pageContext.request.contextPath}/user/submitHomework.do" name="formAdd" method="post" enctype="multipart/form-data">
     <div  style="margin-top: 15px">
      <div>
         <h3 >题目： ${hw.h_name}</h3>
      </div>
      <hr style="margin-top:15px;color: #eeeeee"/>
      <div style="margin-top: 15px">
          <p style="color: #0f9ae0">开始时间：${hw.h_startTime}</p>
      </div>
      <div style="margin-top: 10px">
          <p style="color: #f13124">结束时间：${hw.h_endTime}</p>
      </div>
      <hr style="margin-top:15px;color: #fafafa"/>
      <div style="margin-top: 15px">
          <p>描述：${hw.h_content}</p>
      </div>
      <hr style="margin-top:65px;color: #eee"/>
      <div class="ui form" style="width: 99%!important;">
          <div  class="field" style=" margin-left: 70px!important;margin-top: 15px!important;">
              <textarea rows="10" name="shw_content" cols="50" warp="virtual"></textarea>
          </div>
      </div>

      <div style="margin-left: 150px;margin-top: 20px;" >上传文件：</div>
      <div  style="height: 45px; margin-left: 230px;margin-top: -23px">
          <input type="file" name="homeOldname" id="homeOldname"/>
      </div>
      <div style="margin-top: -5px;margin-left: 70px">
          <button class="ui green button" id="sub_btn"  onclick="check();">提交</button>
      </div>
      <br />

  </div>
 </form>



<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>



</body>

<script>
    function check(){
        //获取编号，姓名，JS非空校验
        var name=$("#homeOldname").val();
        var nm=$.trim(name);
        if(null==nm||""==nm){
            alert("请上传文件");
            return;
        }
        //向服务端发起请求
        document.getElementById("fm").submit();
    }
</script>
</html>
