<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
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
	<form class="form-inline definewidth m20" action="menu/query"
		id="pager" method="post">
		<!-- 关键字查询：  --><input type="hidden" name="pageNum" id="pageNum"
			value="${dto.pageNum }"> <input type="hidden" name="pageSize"
			id="pageSize" value="${dto.pageSize }"> <%-- <input type="text"
			name="keywords" id="keywords" class="abc input-default"
			placeholder="根据菜单名称查询" value="${dto.keywords}">&nbsp;&nbsp; --%>
	<!-- 	<button type="submit" class="btn btn-primary">查询</button> -->
		&nbsp;&nbsp;
		<%-- <shiro:hasPermission name="MENU_CREATE">
			<button type="button" class="btn btn-success" id="addnew">新增菜单</button>
		</shiro:hasPermission> --%>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>菜单id</th>
				<th>菜单名称</th>
				<th>菜单父类id</th>
				<th>权限名</th>
			<!-- 	<th>操作</th> -->
			</tr>
		</thead>
		<c:forEach var="menu" items="${pageModel.list }">
			<c:if test="${menu.pid==0 }">
				<tr>
					<td>${menu.mid }</td>
					<td>${menu.menuname }</td>
					<td>${menu.pid }</td>
					<td>${menu.securityname }</td>
					<%-- <td><shiro:hasPermission name="MENU_UPDATE">
							<a href="menu/queryUpdateById?mid=${menu.mid}">修改</a>
						</shiro:hasPermission> <shiro:hasPermission name="MENU_DELETE">
							<a href="JavaScript:del(${menu.mid })">删除</a>
						</shiro:hasPermission></td> --%>
				</tr>
				<c:forEach var="me" items="${pageModel.list }">
					<c:if test="${me.pid==menu.mid }">
						<tr >
							<td style="text-align: center;">${me.mid }</td>
							<td style="text-align: center;">${me.menuname }</td>
							<td style="text-align: center;">${me.pid }</td>
							<td style="text-align: center;">${me.securityname }</td>
							<%-- <td><shiro:hasPermission name="MENU_UPDATE">
									<a href="menu/queryUpdateById?mid=${me.mid}">修改</a>
								</shiro:hasPermission> <shiro:hasPermission name="MENU_DELETE">
									<a href="JavaScript:del(${me.mid })">删除</a>
								</shiro:hasPermission></td> --%>
						</tr>
						<c:forEach var="m" items="${pageModel.list }">
							<c:if test="${m.pid==me.mid }">
								<tr >
									<td style="text-align:right;">${m.mid }</td>
									<td style="text-align:right;">${m.menuname }</td>
									<td style="text-align:right;">${m.pid }</td>
									<td style="text-align:right;">${m.securityname }</td>
									<%-- <td><shiro:hasPermission name="MENU_UPDATE">
											<a href="menu/queryUpdateById?mid=${m.mid}">修改</a>
										</shiro:hasPermission> <shiro:hasPermission name="MENU_DELETE">
											<a href="JavaScript:del(${m.mid })">删除</a>
										</shiro:hasPermission></td> --%>
								</tr>
							</c:if>

						</c:forEach>
					</c:if>
				</c:forEach>
			</c:if>


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

			window.location.href = "menu/init";
		});

	});

	function del(id) {
		if (confirm("确定要删除吗？")) {
			var url = "menu/delete?mid=" + id;

			window.location.href = url;

		}
	}
</script>