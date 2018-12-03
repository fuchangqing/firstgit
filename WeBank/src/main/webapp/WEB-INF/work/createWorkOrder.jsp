<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<base href="<%=basePath%>">
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
	<form action="work/save" method="post" class="definewidth m20" enctype="multipart/form-data">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td colspan="6">客户信息</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">客户姓名</td>
				<td><input type="text" name="customername" placeholder="必填"
					style="width: 120px;" /></td>

				<td width="10%" class="tableleft">性别</td>
				<td><select name="sex" style="width: 120px;">
						<option value="0">未知</option>
						<option value="1">男</option>
						<option value="2">女</option>
				</select></td>

				<td width="10%" class="tableleft">证件类型</td>
				<td><select name="certificatetype" style="width: 120px;">
						<c:forEach var="d" items="${datalist }">
							<c:if test="${d.pid==1 }">
								<option value="${d.id }">${d.name }</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">证件号码</td>
				<td><input type="text" style="width: 120px;"
					name="centificatenumber" /></td>

				<td width="10%" class="tableleft">手机号</td>
				<td><input type="text" style="width: 120px;" name="telephone" /></td>

				<td width="10%" class="tableleft">微信白名单openId</td>
				<td><input type="text" style="width: 120px;" name="wechatwhite" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">QQ白名单openId</td>
				<td><input type="text" style="width: 120px;" name="qqwhile" /></td>

				<td width="10%" class="tableleft">开户渠道</td>
				<td><select name="openchannel" style="width: 120px;">
						<c:forEach var="d" items="${datalist }">
							<c:if test="${d.pid==2 }">
								<option value="${d.id }">${d.name }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<td width="10%" class="tableleft">客群分类</td>
				<td><input type="text" style="width: 120px;"
					name="customertype" /></td>
			</tr>
			<tr>
				<td colspan="6">客户进线信息</td>

			</tr>
			<tr>
				<td width="10%" class="tableleft">进线渠道</td>
				<td><select style="width: 120px;" name="comeinchannel">
						<c:forEach var="d" items="${datalist }">
							<c:if test="${d.pid==3 }">
								<option value="${d.id }">${d.name }</option>
							</c:if>
						</c:forEach>
				</select></td>
				<td width="10%" class="tableleft">来电号码</td>
				<td><input type="text" name="callphone" /></td>
			</tr>
			<tr>
				<td colspan="6">工单信息</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">处理时效</td>
				<td><select name="aging" style="width: 120px;">
						<c:forEach var="d" items="${datalist }">
							<c:if test="${d.pid==4 }">
								<option value="${d.id }">${d.name }小时</option>
							</c:if>
						</c:forEach>
				</select></td>
				<td width="10%" class="tableleft">紧急程度</td>
				<td><select name="urgencylevel" style="width: 120px;">
						<c:forEach var="d" items="${datalist }">
							<c:if test="${d.pid==5 }">
								<option value="${d.id }">${d.name }</option>
							</c:if>
						</c:forEach>
				</select></td>

				<td width="10%" class="tableleft">问题类型</td>
				<td><select name="problemtype" style="width: 120px;">
						<c:forEach var="d" items="${datalist }">
							<c:if test="${d.pid==6 }">
								<option value="${d.id }">${d.name }</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">流转对象</td>
				<td><select style="width: 120px;" name="handlegroup"
					onchange="changeHandleperson(this.value)">
						<option value="">请选择组</option>
						<c:forEach var="d" items="${deptlist }">
							<option value="${d.id }">${d.name }</option>
						</c:forEach>
				</select></td>

				<td width="10%" class="tableleft">处理人</td>

				<td><select name="handleperson" style="width: 120px;"
					id="handleperson">
					<option value="">请选择处理人</option>
				</select></td>

				<td width="10%" class="tableleft"></td>
				<td></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">问题描述</td>
				<td colspan="5"></td>


			</tr>
			<tr>
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
			</tr>
		</table>

	</form>
</body>
<script type="text/javascript">
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
				for (var i = 0; i < data.length; i++) {
					var opt = document.createElement("option");
					opt.innerHTML = data[i].realname;
					opt.value = data[i].userid;
					sel.appendChild(opt);
				}
			}
		}
	}
</script>
</html>

