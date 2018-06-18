<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
联系方式：<input type="text" id="phone" name="phone"/>
<a href='javascript:findPassword()'>发送验证码</a>
<form action="${pageContext.request.contextPath}/updatePassword">
新密码：<input type="password" name="password"/></br>
验证码：<input type="text" name="code"/></br>
<input type="submit" value="修改"/>
</form>
</body>
<script>
function findPassword(){
    var phone=document.getElementById("phone").value;
    alert(phone);
    $.ajax({
		url: "SendSms",
		type: "POST",
		data: {"phone":phone},
		success: function(){ 
			alert('发送成功');
		},
		error: function(){
		    alert("Ajax请求失败！！！");
		}
    });
    alert('js方法执行完毕');
}
</script>
</html>