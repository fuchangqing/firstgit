<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<form class="form-inline definewidth m20" action="data/query" id="pager"
		method="post">
	<!-- 	关键字查询: -->
		<input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum }">   
        <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize }">
<%-- 		<input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="根据名称查询" value="${dto.keywords}">&nbsp;&nbsp;
 --%>		<!-- <button type="submit" class="btn btn-primary">查询</button> -->
		&nbsp;&nbsp;
		<%-- <shiro:hasPermission name="DATA_CREATE"><button type="button" class="btn btn-success" id="addnew">新增字典</button>
		</shiro:hasPermission> --%>
	</form>
	
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>id</th>
				<th>名称</th>
				<th>备注</th>
				</tr>
		</thead>
		<c:forEach var="data" items="${pageModel.list }">
			<tr>
				<c:if test="${data.pid==0}">							
					<td>${data.id }</td>
					<td>${data.name }</td>
					<td>${data.memo }</td>					
				</c:if>
			</tr>
			<c:forEach var="d" items="${pageModel.list }">
			<tr>
				<c:if test="${d.pid==data.id}">
					<td style="text-align:center">${d.id }</td>
					<td style="text-align:center">${d.name }</td>
					<td style="text-align:center">${d.memo }</td>
				</c:if>
			</tr>
			</c:forEach>	
		</c:forEach>
		
	</table>

	<div class="inline pull-right page">
		<jsp:include page="../../pageBar.jsp"></jsp:include>
	</div>
	

</body>
</html>

<script>
    $(function () {
		$('#addnew').click(function(){
				window.location.href="data/init";
		 });
    });
    
    $(function () {
		$('#tongbu').click(function(){
				window.location.href="sys/user_tongbu";
		 });
    });
	
</script>