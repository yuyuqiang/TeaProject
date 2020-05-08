<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets1/Styles/bridging.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets1/Scripts/common.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	<style>
		.info{ padding-top:10px; overflow:hidden;}
		.inner{ width:1000px;height:172px; height:17px; line-height:17px; overflow:hidden;}
		.inner p{ display:inline-block;}
	</style>
</head>
<body style="background: #f5f5f5 ; overflow-x: hidden">
    <form id="form1">
    <div class="main">
		<div class="sidbar" id="sidbar" style="margin-right: 30px!important;">
			<div class="sub_nav" style="margin-right: 20px!important;">
<%--                <h2><p class="systemIcon">信息管理</p></h2>--%>
                <div class="switch_subNav">
					<ul id="show_iframe" class="switch_nav"  style="background: #272c33;height: 150px!important;">
						<li class="nav_current">
							<i class=" white user large icon" style="margin-top: 10px;margin-left: 10px"></i>
							<a href="#" class="subNavigation" id="A001010"
							   style="margin-top: -27px;margin-left: 20px"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/teacher/myTeaInfoUI.do">个人信息</a>
						</li>
						<li class="nav_current">
							<i class=" white users large icon" style="margin-top: 10px;margin-left: 10px"></i>

							<a href="#" class="subNavigation" id="A001011"
							   style="margin-top: -27px;margin-left: 20px"
							   data-name="common_iframe" onclick="Common.switchNavigation(this);"
							   data-url="${pageContext.request.contextPath}/teacher/list.do">学生信息</a>
						</li>

                    </ul>
                </div>
            </div>
        </div>

		<div style="width: 210px;margin-top: -320px">
			<!--最新公告-->
			<div class="ui segments m-margin-top-large">
				<div class="ui secondary segment ">
					<div class="ui two column grid">
						<div class="column">
							<i class="bookmark icon"></i>最新公告
						</div>
						<div class="right aligned column">
							<a href="#" target="_blank">more <i class="angle double right icon"></i></a>
						</div>
					</div>
				</div>

				<c:forEach items="${list}"  var="notice">
					<div class="ui segment">
						<i class="blue volume up icon"></i>

						<div id="info" class="info" style="margin-top: -30px;margin-left: 20px">
							<div class="inner" >
								<p class="txt" style="color: #3e8cff" >${notice.noticeName}...${notice.createTime}</p>
							</div>
						</div>

					</div>
				</c:forEach>
			</div>

		</div>

		<!--====这里是弹出层的内容====-->
		<div id="common_iframe" class="maincontent">
			<iframe class="common_iframe" id="A001010_iframe" frameborder="0" border="0" src="${pageContext.request.contextPath}/teacher/myTeaInfoUI.do"></iframe>
		</div>
    </div>
    </form>
</body>
<script>
	function scroll(){
		var info = document.getElementById('info');
		var div = info.getElementsByTagName('div')[0];
		var p = document.getElementsByTagName('p')[0];
		var p_w = p.offsetWidth;
		var div_w = info.offsetWidth;
		if(div_w > p_w){ return false; }
		div.innerHTML += div.innerHTML;

		setInterval(function(){
			if(p_w <= info.scrollLeft){
				info.scrollLeft -= p_w;
			} else {
				info.scrollLeft++;
			}
		}, 30);
	}
	scroll();
</script>

</html>

