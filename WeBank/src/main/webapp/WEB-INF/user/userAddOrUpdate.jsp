<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="Js/jquery.sorted.js"></script>
<script type="text/javascript" src="Js/bootstrap.js"></script>
<script type="text/javascript" src="Js/ckform.js"></script>
<script type="text/javascript" src="Js/common.js"></script>



<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form action="user/add" method="post" class="definewidth m20">
		<input type="hidden" name="userid" value="${user.userid }" />
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td><input type="text" name="username"
					value="${user.username }" onblur="validateUsername(this.value)" />
					<span id="validateUsername"></span></td>
			</tr>
			<tr>
				<td class="tableleft">密码</td>
				<td><input type="password" name="password"
					value="${user.password }" /></td>
			</tr>
			<tr>
				<td class="tableleft">真实姓名</td>
				<td><input type="text" name="realname"
					value="${user.realname }" /></td>
			</tr>
			<tr>
				<td class="tableleft">电话</td>
				<td><input type="text" name="telephone"
					value="${user.telephone }" /></td>
			</tr>
			<tr>
				<td class="tableleft">性別</td>
				<td><input type="radio" name="sex" value="男"
					${user.sex eq '男'?'checked':'' } /> 男 <input type="radio"
					name="sex" value="女" ${user.sex eq '女'?'checked':'' } /> 女</td>
			</tr>

			<tr>
				<td class="tableleft">部门</td>
				<td><select name="did">
						<c:forEach items="${deptList }" var="dept">
							<option value="${dept.id }"
								${dept.id ==user.did ?'selected':'' }>${dept.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<shiro:hasRole name="超级管理员">
			<tr>
				<td class="tableleft">角色</td>
				<td><c:forEach items="${roleList }" var="role">
					<c:set var="roleType" value="false"></c:set>
						<c:forEach var="rd" items="${user.rids }">
							<c:if test="${rd==role.rid }">
								<c:set var="roleType" value="true"></c:set>
							</c:if>
						</c:forEach>
						<input type="checkbox" name="rids" value="${role.rid }"
							${roleType?'checked':'' } />
						${role.rolename }<br />
					</c:forEach></td>
			</tr>
			</shiro:hasRole>
			<tr>
				<td class="tableleft"></td>
				<td>
					<shiro:hasPermission name="USER_CREATE">
					<button id="subdata" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;</shiro:hasPermission>
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$('#backid').click(function() {
			window.location.href = "user/query";
		});

	});
	function validateUsername(val) {
		var req = new XMLHttpRequest();
		req.open("POST", "user/validateUsername?username=" + val, true);
		req.send();
		req.onreadystatechange = function() {
			if (req.status == 200 && req.readyState == 4) {
				var un = document.getElementById("validateUsername");
				if (req.responseText == "ok") {
					un.innerHTML = "<font color='green'>用户名可以使用</font>"
					$("#subdata").attr({
						"type" : "submit"
					});
				} else {
					un.innerHTML = "<font color='red'>用户名已存在,请重新输入</font>"
				}
			}
		}
	}
</script>