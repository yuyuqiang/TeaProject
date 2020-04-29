<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/30
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <title>发布作业</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link href="https://cdn.bootcss.com/semantic-ui-calendar/0.0.8/calendar.css" rel="stylesheet">
    <style type="text/css">
        .zuo{width:80px;text-align:right;margin-left: 40px;}
    </style>
</head>
<body>
 <form id="fm" action="${pageContext.request.contextPath}/teacher/publishHomework.do" method="post">
    <div>
        <div class="zuo"style="margin-top: 25px!important;">题目：</div>
        <div class="ui input" style=" margin-left: 120px!important;margin-top: -40px!important;">
            <input type="text"name="H_name" id="H_name" >
        </div>
        <div class="zuo"style="margin-top: 25px!important;">所属专业：</div>
        <select class="ui dropdown"name="subjectId"id ="subjectId" style="width:200px!important;margin-left: 120px;margin-top: -40px">
            <c:forEach items="${subjectList}" var="subject">
                <option value="${subject.id}" name="subjectId">${subject.name}</option>
            </c:forEach>
        </select>

        <div class="ui calendar H_startTime" style="margin-top: 25px!important;margin-left: 10px;">
            <label class="zuo">开始时间：</label>
            <div class="ui input right icon">
                <i class="calendar icon"></i>
                <input type="text"style="margin-left:-2px!important;" placeholder="选择开始时间"  name="H_startTime" id="H_startTime" >
            </div>
        </div>
        <div class="ui calendar H_endTime"style="margin-top: 25px!important;margin-left: 10px;">
            <label class="zuo">结束时间：</label>
            <div class="ui input right icon">
                <i class="calendar icon"></i>
                <input type="text"style="margin-left:-2px!important;"  placeholder="选择结束时间"  name="H_endTime" id="H_endTime">
            </div>
        </div>
        <br />
        <hr style="margin-top:20px;color: #bababa"/>
        <br />
        <div class="zuo"style="margin-top: 25px!important;">内容：</div>
        <div class="ui form" style="width: 60%!important;">
            <div  class="field" style=" margin-left: 120px!important;margin-top: -40px!important;">
                <textarea rows="10" name="H_content" cols="50" warp="virtual"></textarea>
            </div>

        </div>
        <div class="ui blue submit button" id="submit_btn" onclick="check();" style="margin-left: 120px!important;margin-top: 15px!important;">提交</div>
    </div>
 </form>

 <script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
 <script src="https://cdn.bootcss.com/semantic-ui-calendar/0.0.8/calendar.js"></script>
</body>

<script>
     $('.H_startTime').calendar({
        type: 'datetime',//datatime年月日时分  data就是年月日
        ampm: false,//默认会有 上午，下午，或者AM PM，false就会没有默认的PM AM上午下午；文档写的是中文要在text里设置，但是我写的时候本地好好的是英文，但是一上线就成了中文，如 9:00 上午，所以该处设置成了false
        endCalendar: $('.end_time'),//开始时间选好后，会调起结束时间，而且结束时间不会大于开始时间
        formatter: { // 自定义日期的格式
            date: function(date, settings) {
                if (!date) return '';
                var year  = date.getFullYear();
                var month = date.getMonth() + 1;
                var day   = date.getDate();
                month = month < 10 ? '0'+month : month;
                day   = day   < 10 ? '0'+day : day;
                return year + '-' + month + '-' + day;//不写时分hours minute也会返回
            }
        }
    });
     $('.H_endTime').calendar({
         type: 'datetime',
         ampm: false,
         startCalendar: $('.start_time'),
         formatter: { // 自定义日期的格式
             date: function(date, settings) {
                 if (!date) return '';
                 var year  = date.getFullYear();
                 var month = date.getMonth() + 1;
                 var day   = date.getDate();
                 month = month < 10 ? '0'+month : month;
                 day   = day   < 10 ? '0'+day   : day;
                 return year + '-' + month + '-' + day;
             }
         }
     });
     function check(){
        //获取编号，姓名，JS非空校验
        var name=$("#H_name").val();
        var startTime=$("#H_startTime").val();
        var endTime=$("#H_endTime").val();

        var nm=$.trim(name);
        var st=$.trim(startTime);
        var et=$.trim(endTime);

        if(null==nm||""==nm){
            alert("请输入题目");
            return;
        }
        if(null==st||""==st){
            alert("请输入开始时间");
            return;
        }
        if(null==et||""==et){
            alert("请输入结束时间");
            return;
        }

        //向服务端发起请求
        document.getElementById("fm").submit();
    }
</script>

</html>
