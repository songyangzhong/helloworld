<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="${pageContext.request.contextPath}/css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="${pageContext.request.contextPath}/css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="${pageContext.request.contextPath}/js/jquery-1.10.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/side.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
<div class="form_boxA">
<h2>病床信息</h2>
<table cellpadding="0" cellspacing="0">
<tr>
<th>病床编号</th>
<th>是否空闲</th>
<th>创建时间</th>
<th>操作</th>
</tr>

<c:forEach items="${wards}" var="ward">
<tr>
<td>${ward.wardId}</td>
<td>${ward.status}</td>
<td>${ward.createTime}</td>
<td><a href="#">修改</a> | <a href="${pageContext.request.contextPath}/ward/delete?wardId=${ward.wardId}">删除</a></td>
</tr>
</c:forEach>

</table>
</div>
</div>
<!-- /MainForm -->

</body>
</html>