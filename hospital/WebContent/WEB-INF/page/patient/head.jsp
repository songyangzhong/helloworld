<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>头部</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<img class="headLogo" src="${pageContext.request.contextPath}/img/logLOGO.png"/>
		</div>
		<div class="headR">
			<span style="color:#FFF">欢迎：${patient.patientName}</span>
			<span style="color:#FFF"><a href="${pageContext.request.contextPath}/patient/login" target="_blank">【登录】</a></span> 
			<span style="color:#FFF"><a href="${pageContext.request.contextPath}/patient/register" target="_blank">【注册】</a></span> 
		</div>
	</div>
</body>
</html>