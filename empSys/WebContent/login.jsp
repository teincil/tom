<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  function changeImg(){
	  var img=document.getElementById("validate");
	  img.src="${pageContext.request.contextPath }/ValidateServlet?date=" + new Date();
  }
</script>

</head>
<body>
   <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
      姓名<input type="text" name="name">
      <br>
      密码<input type="password" name="password">
      <br>
     <input type="checkbox" checked="checked"> 记住用户名
     <br>
     验证码:<input type="text" name="validate">
			<img alt="验证码" id="validate" src="${pageContext.request.contextPath }/ValidateServlet"
				style="cursor: pointer;" onclick="changeImg()"/>	
			<font color="red">${val_msg }</font>
     
   <span style="color: red ;">${requestScope.error_msg }</span>  
   <br>
      <input type="reset" value="重置">
      <input type="submit" value="提交">
      
   </form>
</body>
</html>