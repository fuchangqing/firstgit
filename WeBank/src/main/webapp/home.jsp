<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="header">

		<div class="dl-title">
			<!--<img src="/chinapost/Public/assets/img/top.png">-->
		</div>

		<div class="dl-log"><shiro:user></shiro:user>
			欢迎您，<span style="color:#ccc;font-size: 16px;font-weight: bold;">			
			<shiro:principal></shiro:principal> </span>
			<a href="/logout" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title"></div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">系统管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-order">工单管理</div></li>

			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

		</ul>
	</div>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui-min.js"></script>
	<script type="text/javascript" src="assets/js/common/main-min.js"></script>
	<script type="text/javascript" src="assets/js/config-min.js"></script>
	<script>
		BUI.use('common/main', function() {
			var config = [ {
				id : '1',
				homePage:'4',
				menu : [ {
					text : '系统管理',
					items : [ {
						id : '2',
						text : '机构管理',
						href : 'dept/query'
					},{
						id : '3',
						text : '角色管理',
						href : 'role/query'
					}, {
						id : '4',
						text : '用户管理',
						href : 'user/query'
					},{
						id : '5',
						text : '菜单管理',
						href : 'menu/query'
					},{
						id : '6',
						text : '数据字典',
						href : 'data/query'
					},]
				} ]
			}, {
				id : '7',
				homePage:'14',
				menu : [ {
					text : '工单管理',
					items : [ {
						id : '9',
						text : '创建工单',
						href : 'work/init'
						
					}, {
						id : '10',
						text : '待处理工单',
						href : 'work/queryNo'
					},  {
						id : '11',
						text : '我的工单',
						href : 'work/queryMy'
					}, {
						id : '12',
						text : '本组工单',
						href : 'work/queryGroup'
					},{
						id : '13',
						text : '本组退单',
						href : 'work/groupBack'
					},{
						id : '14',
						text : '查询所有工单',
						href : 'work/query'
					} ]
				} ]
			} ];
			new PageUtil.MainPage({
				modulesConfig : config
			});
		});
	</script>
	<div style="text-align:center;">
		<p>
			来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
		</p>
	</div>
</body>
</html>
