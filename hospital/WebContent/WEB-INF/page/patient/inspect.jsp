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
<h2>检查信息</h2>
<table cellpadding="0" cellspacing="0">
<tr>
<th>检查编号</th>
<th>病人编号</th>
<th>病人姓名</th>
<th>检查项目名称</th>
<th>检查结果</th>
</tr>

<c:forEach items="${patient_Inspects}" var="patient_Inspect">
<tr>
<td>${patient_Inspect.inspectId}</td>
<td>${patient_Inspect.patientId}</td>
<td>${patient_Inspect.patientName}</td>
<td>${patient_Inspect.inspectName}</td>
<td>${patient_Inspect.result}</td>
</tr>
</c:forEach>

</table>
</div>
</div>
<!-- /MainForm -->

</body>
</html>