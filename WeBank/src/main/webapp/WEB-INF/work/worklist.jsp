<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link rel="stylesheet" href="Css/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="Js/jquery.sorted.js"></script>
<script type="text/javascript" src="Js/bootstrap.js"></script>
<script type="text/javascript" src="Js/ckform.js"></script>
<script type="text/javascript" src="Js/common.js"></script>
<script src="Js/bootstrap-datetimepicker.js"></script>
<script src="Js/bootstrap-datetimepicker.zh-CN.js"></script>




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
	<form class="form-inline definewidth m20" action="work/${task }"
		id="pager" method="post">
		<input type="hidden" name="pageNum" id="pageNum"
			value="${dto.pageNum }">
		<input type="hidden" name="pageSize"
			id="pageSize" value="${dto.pageSize }">
		<input type="text" name="wo.workorderid" style="width:120px"
			placeholder="工单编号" value="${dto.wo.workorderid }">&nbsp;&nbsp;
		<input type="text" name="creatdateStr"  style="width:200px"
			placeholder="创建时间" value="${dto.creatdateStr}" class=".date">&nbsp;&nbsp;
		
		<select name="wo.problemtype" style="width:120px" >
			<option value="">问题类型</option>
			<c:forEach var="p" items="${datalist}">
				<option value="${p.id }" ${d.id==dto.wo.problemtype?'selected':'' }>${p.name}</option>
			</c:forEach>
		</select>
		
		<select style="width:120px" name="wo.status">
			<option value="-1" >工单状态</option>
			<option value="0" ${dto.wo.status ==0?'selected':'' }>待处理</option>
			<option value="1" ${dto.wo.status ==1?'selected':'' }>未处理</option>
			<option value="2" ${dto.wo.status ==2?'selected':'' }>归档</option>
			<option value="3" ${dto.wo.status ==3?'selected':'' }>退单</option>
			<option value="4" ${dto.wo.status ==4?'selected':'' }>挂起</option>
		</select>
		
		<select style="width:120px" name="wo.handlegroup">
			<option value="">处理组</option>
			<c:forEach var="d" items="${deptlist}">
				<option value="${d.id }" ${dto.wo.handlegroup==d.id?'selected':'' }>${d.name}</option>
			</c:forEach>
		</select><br/><br/>
		
		<input type="text" name="wo.customername"  style="width:120px"
			placeholder="客户姓名" value="${dto.wo.customername }">&nbsp;&nbsp;
		<input type="text" name="wo.centificatenumber"  style="width:200px"
			placeholder="身份证号" value="${dto.wo.centificatenumber }" >&nbsp;&nbsp;
		<input type="text" name=" "  style="width:120px"
			placeholder="微信/QQ" value="">&nbsp;&nbsp;
		紧急程度：
		<input type="radio" name="wo.urgencylevel" value="-1">全部&nbsp;&nbsp;
		<input type="radio" name="wo.urgencylevel" value="17">高&nbsp;&nbsp;
		<input type="radio" name="wo.urgencylevel" value="16">中&nbsp;&nbsp;
		<input type="radio" name="wo.urgencylevel" value="15">低
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>编码</th>
				<th>客户姓名</th>
				<th>证件号码</th>
				<th>问题类型</th>
				<th>处理组</th>
				<th>处理人</th>
				<th>紧急程度</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>剩余时效</th>
				<th>催办次数</th>
				<th>首次处理时间</th>
			</tr>
		</thead>
		<c:forEach var="wo" items="${pageModel.list }">
			<tr>
				<td>
				<c:if test="${wo.wo.status==0 }">
					<a href="work/handlerInfo?id=${wo.wo.workorderid }">${wo.wo.workorderid }</a>
				</c:if>
				<c:if test="${wo.wo.status!=0 }">
					<a href="work/handlerInfo?id=${wo.wo.workorderid }" style="color:green">${wo.wo.workorderid }</a>
				</c:if>
				</td>
				<td>${wo.wo.customername }</td>
				<td>${wo.wo.centificatenumber }</td>
				<td>${wo.problemtypename }</td>
				<td>${wo.handlegroupname }</td>
				<td>${wo.username }</td>
				<td>${wo.urgencylevelname }</td>
				<td>${wo.wo.status }</td>
				<td><fmt:formatDate value="${wo.wo.creatdate }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>10</td>
				<td>${wo.wo.hurrycount }</td>
				<td>${wo.wo.firstdate }</td>
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

			window.location.href = "";
		});

	});

	$(function() {
		$('.date').datetimepicker({
			  language: 'zh-CN',//显示中文
			  format: 'yyyy-mm-dd',//显示格式
			  minView: "month",//设置只显示到月份
			  initialDate: new Date(),//初始化当前日期
			  autoclose: true,//选中自动关闭
			  todayBtn: true//显示今日按钮
			 })
	});
	
</script>