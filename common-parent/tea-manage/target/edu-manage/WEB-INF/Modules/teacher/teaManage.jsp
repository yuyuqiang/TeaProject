<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/bridging.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/common.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>

</head>
<body  style="background: #f5f5f5 ; overflow-x: hidden" >
    <form id="form1">
    <div class="main">
		<div class="sidbar" id="sidbar" style="margin-right: 30px!important;">
			<div class="sub_nav" style="margin-right: 20px!important;">
<%--                <h2><p class="systemIcon">教学资料</p></h2>--%>
                <div class="switch_subNav">
					<ul id="show_iframe" class="switch_nav"  style="background: #272c33;height: 450px!important;">
						<li class="nav_current">
							<i class=" white file video outline large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001010"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/vedio/findVediosWithPageByTeacher.do?num=1">教学视频管理</a>
						</li>
						<li class="nav_current">
							<i class=" white folder large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001011"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/rar/findRarWithPageByTeacher.do?num=1">教学课件管理</a>
						</li>
						<li class="nav_current">
							<i class=" white tasks large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001012"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/teacher/teaHomeworkPrev.do">作业管理</a>
						</li>
						<li class="nav_current">
							<i class=" white file alternate outline large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001013"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/question/questionList.do">试题管理</a>
						</li>
						<li class="nav_current">
							<i class=" white table large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001014"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/subject/list.do">课程管理</a>
						</li>
						<li class="nav_current">
							<i class=" white list ul large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001015"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/exam/list.do">考试列表</a>
						</li>

						<li class="nav_current">
							<i class=" white file large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001016"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/exampaper/list.do">试卷管理</a>
						</li>

						<li class="nav_current">
							<i class=" white list alternate outline large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001017"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/exampaperanswer/list.do">答题列表</a>
						</li>

						<li class="nav_current">
							<i class=" white signal large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001018"
							   style="margin-top: -27px;margin-left: 20px"

							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/statis/exam_stats.do">考试成绩统计</a>
						</li>

                    </ul>
                </div>
            </div>
        </div>

		<div class="ui modal" style="width: 500px">
			<div class="header" align="center" id="noticeName" name="noticeName"></div>
			<div class="content">
				<p id="noticeContent" name="noticeContent"></p>
			</div>
			<div class="actions">
				<div class="ui cancel button">Cancel</div>
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

