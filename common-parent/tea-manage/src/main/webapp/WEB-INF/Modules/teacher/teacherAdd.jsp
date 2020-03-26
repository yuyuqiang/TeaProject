<!DOCTYPE html>
<html>
<head>
<title></title>
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/Styles/bridging.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/Scripts/common.js"></script>
<%--	<script type="text/javascript">--%>
<%--	function userSave(){--%>
<%--		$("#userForm").attr("action","");--%>
<%--		$("#userForm").submit();--%>
<%--	}--%>
<%--	</script>--%>
</head>
<body>
	<form id="fm" action="${pageContext.request.contextPath}/teacher/addTeacher.do" name="formAdd" method="post">
		<div class="specificPageEdit" style="*position: static;">
			<div class="form">
				<div class="specificPage_header fix">
					<h4 class="specificPage_title l">
						<span id="MainContent_lbTitle">编辑</span>
					</h4>
					<span class="closePage r" onclick="Common.closePage();">关闭</span>
				</div>
				<div id="MainContent_divTitleTab" class="activeEdite_tab_list"
					style="margin-bottom: 3px;">
					<p>
						<span class="tab_list_current" data-tab="tab_1" onclick="Common.switchTab(this);">添加用户</span>
					</p>
				</div>

				<div class="hide_tab fix" data-tab="tab_1" id="tab_1">
					<div id="MainContent_UpdatePanel1">
						<table border="0" cellpadding="0" cellspacing="6" style="width: 100%">
							<tr>
								<td class="input_text tar">编号：</td>
								<td>
									<p>
										<input type="text" id="teaNum" name="teaNum"  style="width: 150px;" />
									</p>
								</td>
								<td class="input_text tar">姓名：</td>
								<td>
									<p>
										<input type="text" id="teaRealName" name="teaRealName"  style="width: 150px;" />
									</p>
								</td>

							</tr>

							<tr><td colspan="6" style="margin-top: 116px;"><h5>详细信息</h5></td></tr>
							<tr>
								<td class="input_text tar">性别：</td>
								<td>
									<p>
									  <select name="teaSex"  >
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
									</p>
								</td>
								<td class="input_text tar">年龄：</td>
								<td>
									<p>
										<input name="teaAge" type="text" value="" style="width: 150px;" />
									</p>
								</td>
								<td class="input_text tar">账号：</td>
								<td>
									<p>
										<input name="loginName" type="text" value="" id="deviceDetail" style="width: 150px;" />
									</p>
								</td>
								<td class="input_text tar">密码：</td>
								<td>
									<p>
										<input name="loginPwd" type="text"  style="width: 150px;" />
									</p>
								</td>
							</tr>
						</table>
					</div>
				</div>
				 <div class="form_btn form_btn_static">
                    <ul>
                        <li><input type="button" value="保存" onclick="check();"/></li>
                        <li><input type="button" value="关闭" onclick="Common.closePage();" /></li>
                    </ul>
                </div>
			</div>
		</div>
	</form>
</body>

<script>
	function check(){
		//获取编号，姓名，JS非空校验
		var num=$("#teaNum").val();
		var name=$("#teaRealName").val();
		var um=$.trim(num);
		var nm=$.trim(name);
		if(null==um||""==um){
			alert("请输入编号");
			return;
		}
		if(null==nm||""==nm){
			alert("请输入姓名");
			return;
		}
		//向服务端发起请求
		document.getElementById("fm").submit();
	}
</script>
</html>
