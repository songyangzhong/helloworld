<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/page.css" />
<link href="${pageContext.request.contextPath}/css/haiersoft.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<link href="${pageContext.request.contextPath}/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
</head>
<body>

	<!-- 登录body -->
	<div class="logDiv">
		<img class="logBanner" src="${pageContext.request.contextPath}/img/logBanner.png" />
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
			</div>
			<form action="${pageContext.request.contextPath}/patient/patientLogin" method="post">
			<!-- 输入框 -->
			<div class="lgD">
				<img class="img1" src="${pageContext.request.contextPath}/img/logName.png" /><input type="text"
					placeholder="输入用户名" name="patientName"/>
			</div>
			<div class="lgD">
				<img class="img1" src="${pageContext.request.contextPath}/img/logPwd.png" /><input type="text"
					placeholder="输入用户密码" name="password"/>
			</div>
			<div class="logC">
				<%-- <a href="${pageContext.request.contextPath}index" target="_self"><button>登 录</button></a> --%>
				<div class="btn_box floatR"><input type="submit" value="登录"/></div>
			</div>
			</form>
			<p>${message}</p>
		</div>
	</div>
	<!-- 登录body  end -->

</body>
</html>