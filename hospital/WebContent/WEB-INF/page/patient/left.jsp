<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页左侧导航</title>
<link rel="${pageContext.request.contextPath}/stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<head></head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="${pageContext.request.contextPath}/patient/main" target="main"><div class="line">
					<img src="${pageContext.request.contextPath}img/coin01.png" />&nbsp;&nbsp;首页
				</div></a>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${pageContext.request.contextPath}img/coin07.png" /><img class="icon2"
						src="${pageContext.request.contextPath}img/coin08.png" /> 病人信息<img class="icon3"
						src="${pageContext.request.contextPath}img/coin19.png" /><img class="icon4"
						src="${pageContext.request.contextPath}img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${pageContext.request.contextPath}img/coin111.png" /><img class="coin22"
						src="${pageContext.request.contextPath}img/coin222.png" /><a href="${pageContext.request.contextPath}/patient/patientTab" target="main"
						class="cks">病人信息</a><img class="icon5" src="${pageContext.request.contextPath}img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="${pageContext.request.contextPath}img/coin111.png" /><img class="coin22"
						src="${pageContext.request.contextPath}img/coin222.png" /><a href="${pageContext.request.contextPath}/patient/case" target="main"
						class="cks">病例信息</a><img class="icon5" src="${pageContext.request.contextPath}img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="${pageContext.request.contextPath}img/coin111.png" /><img class="coin22"
						src="${pageContext.request.contextPath}img/coin222.png" /><a href="${pageContext.request.contextPath}/patient/inspect" target="main"
						class="cks">检查信息</a><img class="icon5" src="${pageContext.request.contextPath}img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${pageContext.request.contextPath}img/coin10.png" /><img class="icon2"
						src="${pageContext.request.contextPath}img/coin09.png" /> 医生信息<img class="icon3"
						src="${pageContext.request.contextPath}img/coin19.png" /><img class="icon4"
						src="${pageContext.request.contextPath}img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${pageContext.request.contextPath}img/coin111.png" /><img class="coin22"
						src="${pageContext.request.contextPath}img/coin222.png" /><a href="${pageContext.request.contextPath}/patient/doctTab" target="main"
						class="cks">医生信息</a><img class="icon5" src="${pageContext.request.contextPath}img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="${pageContext.request.contextPath}img/coinL1.png" /><img class="icon2"
						src="${pageContext.request.contextPath}img/coinL2.png" /> 系统管理<img class="icon3"
						src="${pageContext.request.contextPath}img/coin19.png" /><img class="icon4"
						src="${pageContext.request.contextPath}img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="${pageContext.request.contextPath}img/coin111.png" /><img class="coin22"
						src="${pageContext.request.contextPath}img/coin222.png" /><a href="${pageContext.request.contextPath}/patient/changepwd"
						target="main" class="cks">修改密码</a><img class="icon5"
						src="${pageContext.request.contextPath}img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="${pageContext.request.contextPath}img/coin111.png" /><img class="coin22"
						src="${pageContext.request.contextPath}img/coin222.png" /><a class="cks">退出</a><img
						class="icon5" src="${pageContext.request.contextPath}img/coin21.png" />
				</dd>
			</dl>

		</div>

	</div>
</body>
</html>
