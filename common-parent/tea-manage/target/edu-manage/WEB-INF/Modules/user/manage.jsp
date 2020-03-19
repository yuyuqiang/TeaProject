<!DOCTYPE html>
<html>
<head>
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/Styles/bridging.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manager01/css/adminstyle.css" media="all">
	<link id="layuicss-skinlayercss" rel="stylesheet" href="${pageContext.request.contextPath}/manager01/common/layui/css/modules/layer/default/layer.css?v=3.0.11110" media="all">
</head>
<body>
    <form id="form1">
    <div class="main">


	<!-- 左侧侧边导航开始 -->
	<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
		<div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
			<!-- 左侧菜单 -->
			<ul class="layui-nav layui-nav-tree">
				<li class="layui-nav-item layui-this">
					<a href="#" class="subNavigation" id="A001010"
					   data-name="common_iframe" onclick="Common.switchNavigation(this);"
					   data-url="${pageContext.request.contextPath}/user/personInfo.do">
						<i class="iconfont icon-geren1" data-icon="icon-geren1"></i>
						<span>个人信息</span>
					</a>
				</li>

				<li class="layui-nav-item">
					<a href="javascript:;">
						<i class="iconfont icon-jiaoseguanli" ></i>
						<span>用户信息</span>
					z	<em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="#" class="subNavigation" id="A001012"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/user/personInfo.do">学生信息</a>
						</dd>
						<dd>
							<a href="#" class="subNavigation" id="A001013"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/user/info.do">教师信息</a>
						</dd>
					</dl>
				</li>


				<li class="layui-nav-item layui-this">
					<a href="#" class="subNavigation" id="A001014"
					   data-name="common_iframe" onclick="Common.switchNavigation(this);"
					   data-url="${pageContext.request.contextPath}/user/personInfo.do">
						<i class="iconfont icon-wenzhang1" ></i>
						<span>资源管理</span>
					</a>
				</li>

				<li class="layui-nav-item">
					<a href="javascript:;">
						<i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
						<span>测试</span>
						<em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="#" class="subNavigation" id="A001016"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/user/personInfo.do">测试题库</a>
						</dd>
						<dd>
							<a href="#" class="subNavigation" id="A001017"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/user/info.do">测试成绩</a>
						</dd>
					</dl>
				</li>

			</ul>
		</div>
	</div>

	<!-- 左侧侧边导航结束 -->
        <!--====这里是弹出层的内容====-->
		<div id="common_iframe" class="maincontent">
			<iframe class="common_iframe" id="A001010_iframe" frameborder="0" border="0" src="${pageContext.request.contextPath}/user/personInfo.do"></iframe>
		</div>
    </div>
    </form>

	<!-- 加载js文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/manager01/common/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/manager01/js/larry.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/manager01/js/index.js"></script>


</body>
</html>

