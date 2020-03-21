<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <meta charset="UTF-8">
    <title>教学辅助网站后台管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/css/adminstyle.css" media="all">
    <link id="layuicss-skinlayercss" rel="stylesheet" href="${pageContext.request.contextPath}/manager01/common/layui/css/modules/layer/default/layer.css?v=3.0.11110" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin" id="layui_layout">
    <!-- 顶部区域 -->
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <!-- logo区域 -->
            <div class="admin-logo-box">
                <a class="logo" href="http://www.kuxuebao.net" title="logo">后台管理系统</a>
                <div class="larry-side-menu">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </div>
            </div>
            <!-- 顶级菜单区域 -->
            <div class="layui-larry-menu">
                <ul class="layui-nav clearfix">
                    <li class="layui-nav-item layui-this">
                        <a href="javascirpt:;"><i class="iconfont icon-wangzhanguanli"></i>内容管理</a>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascirpt:;"><i class="iconfont icon-ht_expand"></i>扩展模块</a>
                    </li>
                </ul>
            </div>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
                <li class="layui-nav-item">
                    账户名：张钰
                </li>

                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/user/login.do">
                        <i class="iconfont icon-exit"></i>
                        退出</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧侧边导航开始 -->
    <div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
            <!-- 左侧菜单 -->
            <ul class="layui-nav layui-nav-tree">


                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/main.do">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>后台首页</span>
                    </a>
                </li>

<%--                <li class="layui-nav-item layui-nav-itemed">--%>
<%--                    <a class="" href="javascript:;">管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="<%=basePath%>/user/personInfo.do">用户管理</a></dd>--%>
<%--                        <dd><a href="<%=basePath%>/user/page404.do">404</a></dd>--%>

<%--                    </dl>--%>
<%--                </li>--%>
                <!-- 个人信息 -->
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli" ></i>
                        <span>我的面板</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;"data-url="${pageContext.request.contextPath}/admin/personInfo.do">
                                <i class="iconfont icon-geren1" data-icon="icon-geren1"></i>
                                <span>个人信息</span>
                            </a>
                        </dd>
                        <dd>
                                                    <a href="javascript:;" data-url="${pageContext.request.contextPath}/user/changepwd.do">
                                                        <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                                                        <span>修改密码</span>
                                                    </a>
                                                </dd>
                                                <dd>
                                                    <a href="javascript:;" data-url="${pageContext.request.contextPath}/user/myloginfo.do">
                                                        <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                                        <span>日志信息</span>
                                                    </a>
                                                </dd>
                    </dl>
                </li>

                <!-- 内容管理 -->
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-wenzhang1" ></i>
                        <span>内容管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="${pageContext.request.contextPath}/user/page404.do">
                                <i class="iconfont icon-lanmuguanli" data-icon='icon-lanmuguanli'></i>
                                <span>404页面</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;">
                                <i class="iconfont icon-wenzhang2" data-icon='icon-wenzhang2'></i>
                                <span>所有资源列表</span>
                            </a>
                        </dd>

                        <dd>
                            <a href="javascript:;">
                                <i class="iconfont icon-pinglun1" data-icon='icon-pinglun1'></i>
                                <span>评论管理</span>
                            </a>
                        </dd>

                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <!-- 左侧侧边导航结束 -->
    <!-- 右侧主体内容 -->
    <div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2499ee;">
        <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
            <div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i class="larry-icon larry-weibiaoti6-copy"></i> </div>
            <ul class="layui-tab-title">
                <li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
            </ul>
            <div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i class="larry-icon larry-right"></i></div>
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
                        <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a></dd>
                        <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content"style="min-height:150px;height: 426px" >
                <div class="layui-tab-item layui-show">
                    <iframe class="larry-iframe" data-id='0' src="${pageContext.request.contextPath}/user/main.do" style="height: 426px"></iframe>
                </div>

                <div class="layui-tab-item layui-show">
                    <iframe  class="larry-iframe" data-id="1" src="${pageContext.request.contextPath}/user/personInfo.do"  style="height: 426px;"></iframe>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- 加载js文件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/manager01/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager01/js/larry.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manager01/js/index.js"></script>



</body>
</html>