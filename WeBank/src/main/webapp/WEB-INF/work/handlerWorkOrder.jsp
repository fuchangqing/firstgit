<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<form action="work/save" method="post" class="definewidth m20"
		enctype="multipart/form-data">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td colspan="6">客户信息</td>

			</tr>
			<tr>
				<td width="10%" class="tableleft">客户姓名</td>
				<td>${wo.customername }</td>

				<td width="10%" class="tableleft">性别</td>
				<td>${cus.sex==1?'男':'女' }</td>

				<td width="10%" class="tableleft">证件类型</td>
				<td><c:forEach var="d" items="${datalist }">
						<c:if test="${cus.certificatetype==d.id }">
							${d.name}
						</c:if>
					</c:forEach></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">证件号码</td>
				<td>${cus.centificatenumber}</td>

				<td width="10%" class="tableleft">手机号</td>
				<td>${cus.telephone }</td>

				<td width="10%" class="tableleft">微信白名单openId</td>
				<td>${cus.wechatwhite }</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">QQ白名单openId</td>
				<td>${cus.qqwhile }</td>

				<td width="10%" class="tableleft">开户渠道</td>
				<td><c:forEach var="d" items="${datalist }">
						<c:if test="${cus.openchannel==d.id }">
							${d.name}
						</c:if>
					</c:forEach></td>

				<td width="10%" class="tableleft">客群分类</td>
				<td>${cus.customertype }</td>
			</tr>
			<tr>
				<td colspan="6">客户进线信息</td>

			</tr>
			<tr>
				<td width="10%" class="tableleft">进线渠道</td>
				<td><c:forEach var="d" items="${datalist }">
						<c:if test="${cus.comeinchannel==d.id }">
							${d.name}
						</c:if>
					</c:forEach></td>
				<td width="10%" class="tableleft">来电号码</td>
				<td>${cus.callphone }</td>
			</tr>
			<tr>
				<td colspan="6">工单信息</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">处理时效</td>
				<td><c:forEach var="d" items="${datalist }">
						<c:if test="${wo.aging==d.id }">
							${d.name}小时
						</c:if>
					</c:forEach></td>
				<td width="10%" class="tableleft">紧急程度</td>
				<td><c:forEach var="d" items="${datalist }">
						<c:if test="${wo.urgencylevel==d.id }">
							${d.name}
						</c:if>
					</c:forEach></td>

				<td width="10%" class="tableleft">问题类型</td>
				<td><c:forEach var="d" items="${datalist }">
						<c:if test="${wo.problemtype==d.id }">
							${d.name}
						</c:if>
					</c:forEach></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">处理部门</td>
				<td>${groupname}</td>

				<td width="10%" class="tableleft">处理人</td>
				<td>${personname}</td>

				<td width="10%" class="tableleft"></td>
				<td></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">问题描述</td>
				<td colspan="5"></td>


			</tr>
			<!-- <tr>
				<td width="10%" class="tableleft">上传文件</td>
				<td colspan="5"><input type="file" name="upload" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">上传文件</td>
				<td colspan="5"><input type="file" name="upload" /></td>
			</tr>
			<tr>

				<td colspan="6" style="text-align: center;">
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr> -->
		</table>

	</form>
	<form action="work/handlerWork" method="post">
		<input type="hidden" name="workorderid" value="${wo.workorderid }">
		<div class="panel panel-default definewidth m20">
			<div class="panel-body">工单处理</div>
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab"> 新增处理
				</a></li>
				<li><a href="#ios" data-toggle="tab">添加描述</a></li>
				<li><a href="#jmeter" data-toggle="tab">催办次数</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="home">
					<input type="radio" name="status" value="1">转办 &nbsp;&nbsp;
					<select style="width: 120px;" name="handlegroup"
						onchange="changeHandleperson(this.value)">
						<option value="">请选择组</option>
						<c:forEach var="d" items="${deptlist }">
							<option value="${d.id }">${d.name }</option>
						</c:forEach>
					</select>&nbsp;&nbsp; <select name="handleperson" style="width: 120px;"
						id="handleperson">
						<option value="">请选择处理人</option>
					</select> <br /> <input type="radio" name="status" value="3">退单&nbsp;&nbsp;
					<select name="handleperson1">
						<option value="">选择成员</option>
						<c:forEach var="h" items="${historylist }">
							<option value="${h.handleperson }">${h.handlepersonname }</option>
						</c:forEach>
					</select> <br /> <input type="radio" name="status" value="4">挂起 <br />
					<input type="radio" name="status" value="2">归档 <br />
					<textarea rows="4" cols="10" placeholder="问题描述【必填】" name="descs"></textarea>
					<br />
					<c:if test="${LOGIN_USER.userid eq wo.handleperson }">
						<button type="submit" class="btn btn-primary">确定</button>
					</c:if>
					<c:if test="${LOGIN_USER.userid ne wo.handleperson }">
						<button type="submit"  disabled="disabled" class="btn btn-primary">确定</button>
					</c:if>
				</div>
				<div class="tab-pane fade" id="ios">
					<textarea rows="4" cols="10" placeholder="问题描述【必填】"></textarea>
					<br />
					<c:if test="${LOGIN_USER.userid eq wo.handleperson }">
						<button type="submit" class="btn btn-primary">确定</button>
					</c:if>
					<c:if test="${LOGIN_USER.userid ne wo.handleperson }">
						<button type="submit"  disabled="disabled"  class="btn btn-primary">确定</button>
					</c:if>
				</div>
				<div class="tab-pane fade" id="jmeter">
					<textarea rows="4" cols="10" placeholder="问题描述【必填】"></textarea>
					<br />
					<c:if test="${LOGIN_USER.userid eq wo.handleperson }">
						<button type="submit" class="btn btn-primary">确定</button>
					</c:if>
					<c:if test="${LOGIN_USER.userid ne wo.handleperson }">
						<button type="submit"  disabled="disabled"  class="btn btn-primary">确定</button>
					</c:if>
				</div>
			</div>
		</div>
	</form>

	<div class="container">
		<div class="media">

			<div class="media-body">
				<h4 class="media-heading">历史记录</h4>
				<c:forEach items="${historys }" var="h">
					<div class="media-left media-top">
						<img src="http://static.runoob.com/images/mix/img_avatar.png"
							class="media-object" style="width: 80px">
					</div><br/>
					<table border="1" width="300" height="100" style="text-align: center">
						<tr>
							<td><b>操作组</b></td>
							<td>${h.handlegroupname }</td>
							<td><b>操作人</b></td>
							<td>${h.handlepersonname }</td>
						</tr>
						<tr>
							<td><b>操 作</b></td>
							<td>${h.actionstr }</td>
							<td><b>操作时间</b></td>
							<td><fmt:formatDate value="${h.createdate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
						<tr>
							<td><b>描述</b></td>
							<td colspan="3">${h.descs}</td>
						</tr>
					</table><br/>
					
				</c:forEach>
				
			</div>
		</div>
		<hr>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$('#backid').click(function() {
			window.location.href = "index.html";
		});
	});

	function changeHandleperson(val) {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("POST", "work/getHandlePerson?did=" + val, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
				var data = xmlhttp.responseText;
				data = eval(data);
				var sel = document.getElementById("handleperson");
				sel.length = 0;
				var loguser = ${LOGIN_USER.userid}
				for (var i = 0; i < data.length; i++) {				
					if (data[i].userid != loguser) {
						var opt = document.createElement("option");
						opt.innerHTML = data[i].realname;
						opt.value = data[i].userid;
						sel.appendChild(opt);
					}
				}
			}
		}
	}
</script>
