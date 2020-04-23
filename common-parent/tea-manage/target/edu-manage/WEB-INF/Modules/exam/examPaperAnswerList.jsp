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
<%--        <div class="wu-toolbar-button">--%>
<%--          --%>
<%--        </div>--%>
        <div class="wu-toolbar-search">
            <label>所属考试:</label>
            <select id="search-exam" class="easyui-combobox" panelHeight="200px" style="width:120px">
                <option value="-1">全部</option>
                <c:forEach items="${examList}" var="exam">
                    <option value="${exam.id}">${exam.name}</option>
                </c:forEach>
            </select>
            <label>所属考生:</label>
            <select id="search-student" class="easyui-combobox" panelHeight="200px" style="width:120px">
                <option value="-1">全部</option>
                <c:forEach items="${studentList}" var="user">
                    <option value="${user.id}">${user.username}</option>
                </c:forEach>
            </select>
            <label>所属试题:</label>
            <select id="search-question" class="easyui-combobox" panelHeight="300px" style="width:120px">
                <option value="-1">全部</option>
                <c:forEach items="${questionList}" var="question">
                    <option value="${question.id}">${question.title}</option>
                </c:forEach>
            </select>
            <a href="#" id="search-btn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
        </div>
    </div>
    <!-- End of toolbar -->
    <table id="data-datagrid" class="easyui-datagrid" toolbar="#wu-toolbar"></table>
</div>
</body>
<script type="text/javascript">


    //搜索按钮监听
    $("#search-btn").click(function(){
        var option = {};
        var examId = $("#search-exam").combobox('getValue');
        if(examId != -1){
            option.examId = examId;
        }
        var studentId = $("#search-student").combobox('getValue');
        if(studentId != -1){
            option.studentId = studentId;
        }
        var questionId = $("#search-question").combobox('getValue');
        if(questionId != -1){
            option.questionId = questionId;
        }
        $('#data-datagrid').datagrid('reload',option);
    });



    /**
     * 载入数据
     */
    $('#data-datagrid').datagrid({
        url:'list.do',
        rownumbers:true,
        singleSelect:true,
        pageSize:20,
        pagination:true,
        multiSort:true,
        fitColumns:true,
        idField:'id',
        treeField:'name',
        nowrap:false,
        fit:true,
        columns:[[
            { field:'chk',checkbox:true},
            { field:'examId',title:'所属考试',width:180,formatter:function(value,index,row){
                    var examList = $("#search-exam").combobox("getData");
                    console.log(examList);
                    console.log(value);
                    for(var i=0;i<examList.length;i++){
                        if(examList[i].value == value)return examList[i].text;
                    }
                    return value;
                }},
            { field:'examPaperId',title:'试卷ID',width:200},
            { field:'questionId',title:'所属试题',width:200,formatter:function(value,index,row){
                    var questionList = $("#search-question").combobox("getData");
                    for(var i=0;i<questionList.length;i++){
                        if(questionList[i].value == value)return questionList[i].text;
                    }
                    return value;
                }},
            { field:'studentId',title:'所属考生',width:180,formatter:function(value,index,row){
                    var studentList = $("#search-student").combobox("getData");
                    for(var i=0;i<studentList.length;i++){
                        if(studentList[i].value == value)return studentList[i].text;
                    }
                    return value;
                }},
            { field:'answer',title:'提交答案',width:200},
            { field:'isCorrect',title:'是否正确',width:200,formatter:function(value,index,row){
                    if(value == 0) return '错误';
                    return '正确';
                }},
        ]]
    });
</script>
</html>
