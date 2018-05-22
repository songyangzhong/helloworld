<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病人注册</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="${pageContext.request.contextPath}/css/haiersoft.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<link href="${pageContext.request.contextPath}/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<script src="${pageContext.request.contextPath}/js/jquery-1.10.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/side.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
	<!-- Popup -->
	<div id="Popup">

		<!-- SubPopup -->
		<div id="SubPopup">
			<script type="text/javascript">
				$(
						function() {
							$(".select").each(
									function() {
										var s = $(this);
										var z = parseInt(s.css("z-index"));
										var dt = $(this).children("dt");
										var dd = $(this).children("dd");
										var _show = function() {
											dd.slideDown(200);
											dt.addClass("cur");
											s.css("z-index", z + 1);
										};
										var _hide = function() {
											dd.slideUp(200);
											dt.removeClass("cur");
											s.css("z-index", z);
										};
										dt.click(function() {
											dd.is(":hidden") ? _show()
													: _hide();
										});
										dd.find("a").click(function() {
											dt.html($(this).html());
											_hide();
										});
										$("body").click(
												function(i) {
													!$(i.target).parents(
															".select").first()
															.is(s) ? _hide()
															: "";
												});
									})
						})
			</script>
			<form action="${pageContext.request.contextPath}/patient/patientUpdate">
			<div class="form_boxC">
				<p>
					"<span class="f_cB">*</span>"号为必填项目
				</p>
				<table cellpadding="0" cellspacing="0">
					<tr>
						<th width="100">病人编号 <span class="f_cB">*</span></th>
						<td><div class="txtbox floatL" style="width: 100px;">
								<input name="patientId" type="text" size="5" value="${patientForm.patientId}" onchange="false"/>
							</div></td>
					</tr>
					<tr>
						<th>病人姓名<span class="f_cB">*</span></th>
						<td><div class="txtbox floatL" style="width: 100px;">
								<input name="patientName" type="text" size="5" value="${patientForm.patientName}"/>
							</div></td>
					</tr>
					<tr>
						<th>性别 <span class="f_cB">*</span></th>
						<td>
							<!-- selectbox -->
							<div class="selectbox" style="width: 230px;">
								<dl class="select">
									<dt>请选择</dt>
									<dd>
										<ul>
											<li><a href="#"> 男 </a></li>
											<li><a href="#"> 女 </a></li>
										</ul>
									</dd>
								</dl>
							</div> 
							<!-- /selectbox -->
						</td>
					</tr>
					<tr>
						<th>年龄 <span class="f_cB">*</span></th>
						<td><div class="txtbox floatL" style="width: 100px;">
								<input type="number" min="1" max="150" size="5" name="age" value="${patientForm.age}"/>
							</div></td>
					</tr>
					<tr>
						<th>密码<span class="f_cB">*</span></th>
						<td><div class="txtbox floatL">
								<input name="password" type="text" value="${patientForm.password}"/>
							</div></td>
					</tr>
					<tr>
						<th>联系方式<span class="f_cB">*</span></th>
						<td><div class="txtbox floatL">
								<input name="phoneNumber" type="text" value="${patientForm.phoneNumber}"/>
							</div></td>
					</tr>
				</table>
			</div>
		</div>
		<!-- SubPopup -->

		<div id="BtmBtn">
			<div class="btn_boxB floatR mag_l20">
				<input name="" type="button" value="取消"
					onmousemove="this.className='input_move'"
					onmouseout="this.className='input_out'">
			</div>
			<div class="btn_box floatR">
				<input name="" type="button" value="提交"
					onmousemove="this.className='input_move'"
					onmouseout="this.className='input_out'">
			</div>
		</div>
	</div>
	<!-- /Popup -->
	<input type="submit" value="submit"/>
	</form>
</body>
</html>