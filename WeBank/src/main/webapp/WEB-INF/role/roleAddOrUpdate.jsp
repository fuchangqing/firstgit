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
	<form action="role/add" method="post" class="definewidth m20">
		<input type="hidden" name="rid" value="${role.rid }" />
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">角色名</td>
				<td><input type="text" name="rolename"
					value="${role.rolename }" onblur="validateRolename(this.value)" />
					<span id="validateRolename"></span></td>
			</tr>
			<tr>
				<td class="tableleft">角色描述</td>
				<td><input type="text" name="description"
					value="${role.description }" /></td>
			</tr>
			<tr>
				<td class="tableleft">角色</td>
				<td><c:forEach items="${menuList }" var="menu">
						<c:if test="${menu.pid==0 }">						
						<c:set var="menuType" value="false"></c:set>
							<c:forEach var="md" items="${role.mids }">
								<c:if test="${md==menu.mid }">
									<c:set var="menuType" value="true"></c:set>
								</c:if>
							</c:forEach>
							<input type="checkbox" name="mids" ${menuType?'checked':'' }
								value="${menu.mid }" />
								${menu.menuname }<br />
							<c:forEach items="${menuList }" var="second">
								<c:if test="${second.pid==menu.mid }">
									<c:set var="secondType" value="false"></c:set>
									<c:forEach var="md" items="${role.mids }">
										<c:if test="${md==second.mid }">
											<c:set var="secondType" value="true"></c:set>
										</c:if>
									</c:forEach>
									&nbsp;&nbsp;&nbsp;<input type="checkbox" name="mids"
										${secondType?'checked':'' } value="${second.mid }"
										 />
										${second.menuname }<br />
									<c:forEach items="${menuList }" var="small">
										<c:if test="${small.pid==second.mid }">
											<c:set var="smallType" value="false"></c:set>
											<c:forEach var="md" items="${role.mids }">
												<c:if test="${md==small.mid }">
													<c:set var="smallType" value="true"></c:set>
												</c:if>
											</c:forEach>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="mids" value="${small.mid }"
												${smallType?'checked':'' }
												} />
												 ${small.menuname }<br />
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach></td>
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
	function validateRolename(val) {
		var req = new XMLHttpRequest();
		req.open("POST", "role/validateRolename?rolename="
				+ encodeURI(encodeURI(val)), true);
		req.send();
		req.onreadystatechange = function() {
			if (req.status == 200 && req.readyState == 4) {
				var un = document.getElementById("validateRolename");
				if (req.responseText == "ok") {
					un.innerHTML = "<font color='green'>角色名可以使用</font>"
					$("#subdata").attr({
						"type" : "submit"
					});
				} else {
					un.innerHTML = "<font color='red'>角色名已存在,请重新输入</font>"
					$("#subdata").attr({
						"type" : "button"
					});
				}
			}
		}
	}
</script>