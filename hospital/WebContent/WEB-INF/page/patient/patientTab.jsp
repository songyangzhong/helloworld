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

</head>

<body>


<!-- MainForm -->
<div id="MainForm">
<div class="form_boxA">
<h2>病人信息</h2>
<table cellpadding="0" cellspacing="0">
<tr>
<th>病人编号</th>
<th>姓名</th>
<th>年龄</th>
<th>性别</th>
<th>病房编号</th>
<th>饮食建议</th>
<th>药物历史</th>
<th>联系方式</th>
<th>创建时间</th>
</tr>

<tr>
<td>${patientForm.patientId}</td>
<td>${patientForm.patientName}</td>
<td>${patientForm.age}</td>
<td>${patientForm.gender}</td>
<td>${patientForm.wardId}</td>
<td>${patientForm.dietAdvice}</td>
<td>${patientForm.medicineHistory}</td>
<td>${patientForm.phoneNumber}</td>
<td>${patientForm.createTime}</td>

<td><a href="${pageContext.request.contextPath}/patient/beforeUpdate?patientId=${patientForm.patientId}">修改</a> |
	 <a href="${pageContext.request.contextPath}/patient/deleteById?patientId=${patientForm.patientId}">删除</a></td>
</tr>

</table>
</div>
</div>
<!-- /MainForm -->

</body>
</html>