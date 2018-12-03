<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<form class="form-inline definewidth m20" action="user/query" id="pager"
		method="post">
		关键字查询：
		<input type="hidden" name="pageNum" id="pageNum" value="${dto.pageNum }">
		<input type="hidden" name="pageSize" id="pageSize" value="${dto.pageSize }">
		<input type="text" name="keywords" id="keywords"
			class="abc input-default" placeholder="根据用戶名或真名查询" value="${dto.keywords}">&nbsp;&nbsp;
		<shiro:hasPermission name="USER_QUERY">
		<button type="submit" class="btn btn-primary">查询</button>
		</shiro:hasPermission>
		&nbsp;&nbsp;
		<shiro:hasPermission name="USER_CREATE">
		<button type="button" class="btn btn-success" id="addnew">新增用户</button>
		</shiro:hasPermission>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>用户id</th>
				<th>账号</th>
				<th>密码</th>
				<th>真实姓名</th>
				<th>性别</th>
				<th>部门</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach var="user" items="${pageModel.list }">
			<tr>
				<td>${user.userid }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.realname }</td>
				<td>${user.sex }</td>
				<td>${user.did }</td>
				<td><fmt:formatDate value="${user.opentime }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>
					<shiro:hasPermission name="USER_UPDATE">
					<a href="user/queryUpdateById?userid=${user.userid}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="USER_DELETE">
					<a href="JavaScript:del(${user.userid })">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
	</table>

	<div class="inline pull-right page">
		<jsp:include page="../../pageBar.jsp"></jsp:include>
	</div>
</body>

</body>
</html>

<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "user/init";
		});

	});

	$(function() {
		$('#tongbu').click(function() {
			window.location.href = "sys/user_tongbu";
		});
	});
	function del(id) {
		if (confirm("确定要删除吗？")) {
			var url = "user/delete?userid="+id;

			window.location.href = url;

		}
	}
</script>