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
	<form action="dept/add" method="post" class="definewidth m20">
		<input type="hidden" name="id" value="${dept.id }" />
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">部门名称</td>
				<td><input type="text" name="name"
					value="${dept.name }" id="deptname"
					onblur="validateDeptname(this.value)"/>
					<span id="validateDeptname"></span>
				</td>				
			</tr>
			<tr>
				<td class="tableleft">备注</td>
				<td><input type="text" name="memo"
					value="${dept.memo }" /></td>
			</tr>
			
			<tr>
				<td class="tableleft"></td>
				<td>
					<button class="btn btn-primary" id="subdata">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "role/query";
		});
		/* if ($("#box_${menu.mid }")) {
			
		}else if($("#box_${menu.mid }_${second.mid}")){

		}else if($("#box_${menu.mid }_${second.mid}_${small.mid}")){
			
		} */
		
	});
	function validateDeptname(val) {
		var req = new XMLHttpRequest();
		req.open("POST", "dept/validateDeptname?name=" + encodeURI(encodeURI(val)), true);
		req.send();
		req.onreadystatechange = function() {
			if (req.status == 200 && req.readyState == 4) {
				var un = document.getElementById("validateDeptname");		
				if (req.responseText == "ok") {
					un.innerHTML = "<font color='green'>部门名可以使用</font>"
					$("#subdata").attr({
						"type" : "submit"
					});
				} else {
					un.innerHTML = "<font color='red'>部门名已存在,请重新输入</font>"
						$("#subdata").attr({
							"type" : "button"
						});
				}
			}
		}
	}
</script>