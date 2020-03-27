<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>用户信息</title>
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/Styles/bridging.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>
<script type="text/javascript">
	 function search(){
	 $("#searchUserForm1").attr("action","");
	 $("#searchUserForm1").submit();
	 }

	 $(document).ready(function(){
		 
	 	$("#birthday").datepicker({
			dateFormat: 'yy-mm-dd',
		});

	 })
</script>
</head>
<body>
	<form id="searchUserForm1" action="" method="post">
		<div class="condition_search">
			<div class="search_title">
				<h3 class="total_title">条件查询</h3>
				<span class="clickToReflesh" onclick="window.location.href = window.location.href;">点击刷新</span>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="MainContent_labAllTotal"></span></div>
			</div>

			<div class="search_detail" style="height: 80px;">
				<div class="search_table">
					<table cellpadding="0" cellspacing="0" style="width: 900px">
						<tr>
							<td class="input_text tar">用户名：</td>
							<td>
								<p><input type="text" id="username" name="username" style="width: 120px;"></p>
							</td>
							<td class="input_text tar">性别：</td>
							<td>
								<p>
									<select>
										<option value="">男</option>
										<option value="">女</option>
									</select>
								</p>
							</td>
							<td class="input_text tar">省份：</td>
							<td>
								<p><input type="text" style="width: 120px;"></p>
							</td>
							<td class="input_text tar">身份证：</td>
							<td>
								<p><input type="text" style="width: 120px;"></p>
							</td>
						</tr>
						<tr>
							<td class="input_text tar">生日：</td>
							<td colspan="7"><p><input type="text" id="birthday" style="width:120px;" readonly="readonly"></p></td>

						</tr>
					</table>
				</div>
				<input type="button" onclick="search();" class="search_btn" />
			</div>
			<div class="edit">
				<h3 class="total_title">查询结果</h3>
				<ul>
					<li><input type="button" value="新增" class="addition"
						data-url="${pageContext.request.contextPath}/teacher/teacherAddUI.do"
						onclick="Common.showPage(this);" /></li>
				</ul>
			</div>
		</div>
		
		<!--这里是表格数据-->
		<div class="total_table rel">
			<table border="0" cellspacing="0" cellpadding="0"
				style="width: 100%;">
				<thead>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="10%">编号</td>
					<td width="10%">姓名</td>
					<td width="10%">性别</td>
					<td width="10%">年龄</td>
					<td width="10%">账号</td>
					<td width="10%">密码</td>
					<td width="10%">操作</td>
				</tr>
				</thead>
			</table>
			<div style="height: 200px; overflow-y: auto; overflow-x: hidden;">
				<table cellpadding="0" cellspacing="0"
					style="width: 100%; background-color: #FFF;">

					<c:forEach items="${page.list}" var="tea"  varStatus="status">
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
							<td width="4%" bgcolor="#FFFFFF" align="center">
									${status.index+1}
							</td>
							<td width="10%" bgcolor="#FFFFFF" align="center">
									${tea.teaNum}
							</td>
							<td width="10%" bgcolor="#FFFFFF" align="center">
									${tea.teaRealName}
							</td>
							<td width="10%" bgcolor="#FFFFFF" align="center">
									${tea.teaSex}
							</td>

							<td width="10%" bgcolor="#FFFFFF" align="center">
									${tea.teaAge}
							</td>
							<td width="10%" bgcolor="#FFFFFF" align="center">
									${tea.loginName}

							</td>
							<td width="10%" bgcolor="#FFFFFF" align="center">
									${tea.loginPwd}
							</td>
							<td width="10%" bgcolor="#FFFFFF" align="center">
								<a href="#" onclick="delTea(${tea.teaId})" >删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<!-- 分页查询 -->
		<div class="page">
			<%@ include file="/WEB-INF/Modules/pageFile.jsp" %>
		</div>
		
		<div class="specific_page tal dn" id="popupLayer">
        <!--这里删除了style属性-->
        <iframe id="childform" frameborder="0" border="0" class="iframe_layer" name="layer_iframe"></iframe>
    </div>
	</form>
</body>
<script>
	function delTea(tid){
		//删除前的确认提示
		if(confirm("确认删除吗?")){
			window.location.href="${pageContext.request.contextPath}/teacher/delTeacher.do?id="+tid;
		}
	}
</script>
</html>
