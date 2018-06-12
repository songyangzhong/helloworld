<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
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
<!-- Popup -->
<div id="Popup">

<!-- SubPopup -->
<div id="SubPopup">
<script type="text/javascript">
$(function(){
$(".select").each(function(){
var s=$(this);
var z=parseInt(s.css("z-index"));
var dt=$(this).children("dt");
var dd=$(this).children("dd");
var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
dt.click(function(){dd.is(":hidden")?_show():_hide();});
dd.find("a").click(function(){dt.html($(this).html());_hide();});
$("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})
</script>
<div class="form_boxC">
<p>"<span class="f_cB">*</span>"号为必填项目</p>

<form action="${pageContext.request.contextPath}/doctor/updateDoctor" method="post" >
<table cellpadding="0" cellspacing="0">
<tr>
<td><input name="doctorId" type="hidden" size="5" value="${doctor.doctorId}"></div></td>
</tr>
<tr>
<td><input name="departmentId" type="hidden" size="5" value="${doctor.departmentId}"></div></td>
</tr>
<tr>
<th>医生姓名 <span class="f_cB">*</span></th>
<td><div class="txtbox floatL" style="width:100px;"><input name="doctorName" type="text" size="5" value="${doctor.doctorName}"></div></td>
</tr>
<tr>
						<th>性别 <span class="f_cB">*</span></th>
						<td>
							<select name="gender">
							<div class="selectbox" style="width: 230px;">
								<dl class="select">
									<dt>请选择</dt>
									<dd>
										<ul>
                                			<option value="男" <c:if test="${doctor.gender=='男'}">selected</c:if> >男</option>
											<option value="女" <c:if test="${doctor.gender=='女'}">selected</c:if> >女</option>
										</ul>
									</dd>
								</dl>
							</div> 
							</select>
						</td>
					</tr>
<tr>
 <th>年龄 <span class="f_cB">*</span></th>
 <td><div class="txtbox floatL" style="width:100px;"><input  name="age" type="text"  min="1" max="150"size="5" value="${doctor.age}"></div></td>
 </tr>
<tr>

<tr>
 <th>密码 <span class="f_cB">*</span></th>
 <td><div class="txtbox floatL" style="width:100px;"><input  name="password" type="password"  min="1" max="150"size="5" value="${doctor.password}"></div></td>
 </tr>
<tr>

<tr>
 <th>电话号码 <span class="f_cB">*</span></th>
 <td><div class="txtbox floatL" style="width:100px;"><input  name="phoneNumber" type="text"  min="1" max="150"size="5" value="${doctor.phoneNumber}"></div></td>
 </tr>
<tr>

<input  name="salt" type="hidden"  min="1" max="150" size="5" value="${doctor.salt}">




</table>

<div id="BtmBtn">
		<div class="btn_box floatR">
			<input type="submit" value="提交"/>
		</div>
	</div>

</form>
</div>
</div>
<!-- SubPopup -->


<!-- /Popup -->
</body>
</html>