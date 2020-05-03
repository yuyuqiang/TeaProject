<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/21
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <%--    移动端预览设置--%>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/me.css">
    <style>
        #particles-js{
            width: 100%;
            height: 80%;
            position: relative;
            background-image: url(${pageContext.request.contextPath}/assets1/Images/index1.jpg);
            background-position: 50% 50%;
            background-size: cover;
            background-repeat: no-repeat;
            margin-left: auto;
            margin-right: auto;
        }

    </style>
</head>
<body >
  <div id="particles-js" >
     <div class="following bar">
         <div class="ui container">
             <div class="ui large secondary network menu inverted">
                 <div class="item">
                     <div class="ui logo shape">
                         <div class="sides">
                             <div class="active ui side">
                                 <img class="ui image" style="width: 90px;height: 90px" src="${pageContext.request.contextPath}/assets1/Images/logoko11.png">
                             </div>
                         </div>
                     </div>
                 </div>
                 <a class="view-ui item">
                     <i class="sidebar icon"></i> 菜单
                 </a>
                 <div class="right item">
                     <a href="${pageContext.request.contextPath}/user/login.do" class="ui inverted button">Log in</a>
                     <a class="ui inverted button" style="margin-left: 10px">Sign Up</a>
                 </div>
             </div>
         </div>
     </div>
    <div class="introduction">
        <div class="ui hidden divider"></div>
        <div class="ui hidden divider"></div>

        <h1 class="ui inverted header">
        <span class="library">
           Software Engineering
        </span>
            <div class="ui hidden divider"></div>

            <span style="font-size: 0.75em;">
                 《软件工程》教学辅助网站
            </span>
        </h1>
        <div class="ui hidden divider"></div>

        <a  class="ui huge inverted download button" onclick="openAdd()">
            Get Started
        </a >
        <a href="" class="ui huge inverted basic button">New in 2.4</a>
    </div>
  </div>
  <h2 style="margin-left: 40px;" >名师课堂</h2>
  <table style="margin-left: 100px">

      <c:forEach items="${subjectList}" var="subject" varStatus="status" >
          <c:if test="${(status.index+1) mod 3 !=1}">
              <td>
                  <div class="ui card"style="margin-left: 100px">
                      <div class="image" >
<%--                      <img  src="${pageContext.request.contextPath}/assets1/Images/logoko11.png">--%>
                          <img class="ui medium rounded image" style="width: 290px;height: 145px"src="${pageContext.request.contextPath}/${subject.image}">
                  </div>
                      <div class="content">
                          <a class="header">${subject.name}</a>
                          <div class="meta">
                              <span class="date">${subject.createTime}创建</span>
                          </div>
                          <div class="description">${subject.remark} </div>
                      </div>
                      <div class="extra content">
                          <a><i class="user icon"></i> ${subject.subNum}人加入 </a>
                      </div>
                  </div>
                  </br>
                  </br>
              </td>
          </c:if>
          <c:if test="${(status.index+1) mod 3==1}">
              <tr>
                  <td>
                      <div class="ui card">
                          <div class="image" >
<%--                              <img  src="${pageContext.request.contextPath}/assets1/Images/cardimg1.jpg">--%>
                                  <img class="ui medium rounded image"style="width: 290px;height: 145px" src="${pageContext.request.contextPath}/${subject.image}">

                          </div>
                          <div class="content">
                              <a class="header">${subject.name}</a>
                              <div class="meta">
                                  <span class="date">${subject.createTime}创建</span>
                              </div>
                              <div class="description">${subject.remark} </div>
                          </div>
                          <div class="extra content">
                              <a><i class="user icon"></i> ${subject.subNum}人加入 </a>
                          </div>
                      </div>
                      </br>
                      </br>
                  </td>
          </c:if>


      </c:forEach>
  </table>

  <!-- Begin of easyui-dialog -->

  <div class="ui modal">
      <i class="close icon"></i>
      <div class="header">
          请添加课程信息
      </div>

      <div class="actions">
          <div class="ui black deny button">
              Nope
          </div>
          <div class="ui positive right labeled icon button">
              Yep, that's me
              <i class="checkmark icon"></i>
          </div>
      </div>
  </div>

  <div class="ui inverted vertical footer segment">
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

 <script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
<script>


    $('#ui modal').modal(show());
    /**
     * Name 打开添加窗口
     */
    function openAdd(){
        $('#ui modal').modal(show());
        //$('#add-form').form('clear');
        $('#ui modal').dialog({
            closed: false,
            modal:true,
            title: "添加学科信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#add-dialog').dialog('close');
                }
            }],
            onBeforeOpen:function(){
                //$("#add-form input").val('');
            }
        });

    }

    /**
     *  添加记录
     */
    function add(){
        var validate = $("#add-form").form("validate");
        if(!validate){
            $.messager.alert("消息提醒","请检查你输入的数据!","warning");
            return;
        }
        var data = $("#add-form").serialize();
        $.ajax({
            url:'${pageContext.request.contextPath}/subject/add.do',
            dataType:'json',
            type:'post',
            data:data,
            success:function(data){
                if(data.type == 'success'){
                    $.messager.alert('信息提示','添加成功！','info');
                    $("#add-name").val('');
                    $("#add-remark").val('');
                    $('#add-dialog').dialog('close');
                    $('#data-datagrid').datagrid('reload');
                }else{
                    $.messager.alert('信息提示',data.msg,'warning');
                }
            }
        });
    }
</script>

</body>
</html>
