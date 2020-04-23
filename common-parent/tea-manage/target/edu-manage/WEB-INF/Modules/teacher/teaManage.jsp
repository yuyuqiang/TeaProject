﻿<!DOCTYPE html>
<html>
<head>
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/bridging.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/common.js"></script>
</head>
<body>
    <form id="form1">
    <div class="main">
        <div class="sidbar" id="sidbar">
            <div class="sub_nav">
                <h2><p class="systemIcon">教学资料</p></h2>
                <div class="switch_subNav">
                    <ul id="show_iframe" class="switch_nav">
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001010"
                               data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/vedio/findVediosWithPageByTeacher.do?num=1">教学视频管理</a>
						</li>
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001011"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/vedio/vedioPrev.do">教学课件管理</a>
						</li>
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001012"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/teacher/teaHomeworkPrev.do">作业管理</a>
						</li>
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001013"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/question/questionList.do">试题管理</a>
						</li>
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001014"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/subject/list.do">章节管理</a>
						</li>
						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001015"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/exam/list.do">考试列表</a>
						</li>

						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001016"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/exampaper/list.do">试卷管理</a>
						</li>

						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001017"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/exampaperanswer/list.do">答题列表</a>
						</li>

						<li class="nav_current">
							<a href="#" class="subNavigation" id="A001018"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/statis/exam_stats.do">图标统计</a>
						</li>

                    </ul>
                </div>
            </div>
        </div>
        <!--====这里是弹出层的内容====-->
		<div id="common_iframe" class="maincontent">
			<iframe class="common_iframe" id="A001010_iframe" frameborder="0" border="0" src="${pageContext.request.contextPath}/vedio/findVediosWithPageByTeacher.do?num=1"></iframe>
		</div>
    </div>
    </form>
</body>
</html>

