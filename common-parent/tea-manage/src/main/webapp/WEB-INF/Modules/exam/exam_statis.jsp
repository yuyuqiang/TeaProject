<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="copyright" content="All Rights Reserved, Copyright (C) 2013, 猿来入此, Ltd." />
    <title>试题</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/easyui/1.3.4/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/css/wu.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/css/icon.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/easyui/1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/easyui/1.3.4/src/jquery.tabs.js"></script>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="wu-toolbar">

        <div class="wu-toolbar-search">
            <label>考试列表:</label>
            <select id="search-exam" class="easyui-combobox" panelHeight="auto" style="width:120px">
                <option value="-1">全部</option>
                <c:forEach items="${examList}" var="exam">
                    <option value="${exam.id}">${exam.name}</option>
                </c:forEach>
            </select>
            <a href="#" id="search-btn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
        </div>
    </div>

    <div class="easyui-accordion" style="width:950px;height:450px;">
        <div title="成绩统计图表展示" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
            <div id="main" style="width: 880px;height:560px;"></div>
        </div>
    </div>

    <!-- End of easyui-dialog -->
    <script src="${pageContext.request.contextPath}/static/easyui/js/echarts.min.js"></script>
    <script type="text/javascript">

        //基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据

        $("#search-btn").click(function(){
            var examId = $("#search-exam").combobox('getValue');
            if(examId == -1){
                $.messager.alert('信息提示','请选择要统计的考试！','info');
                return;
            }
            $.ajax({
                type: "POST",
                url: "get_stats.do",
                dataType: "json",
                data: {"examId":examId},
                success: function(data){
                    if(data.type == 'success'){
                        var option = {
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {
                                    type: 'cross',
                                    crossStyle: {
                                        color: '#999'
                                    }
                                }
                            },
                            xAxis: {
                                type: 'category',
                                data: data.studentList
                            },
                            yAxis: {
                                type: 'value'
                            },
                            series: [{
                                data: data.studentScore,
                                type: 'line'
                            }]
                        };
                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);
                    }else{
                        alert(data.msg);
                    }
                },
                error: function(){
                    //$(".tm_btn_primary").text('登录');
                    alert('系统忙，请稍后再试');
                    window.location.reload();
                }
            });
        });

    </script>

</div>
</body>

</html>
