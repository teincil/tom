<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath }/RigisterServlet" method="post">
                姓名 <input type="text" name="name"  >
                <br>
                密码<input type="password" name="password" >
                <br>
         <input type="radio" name="gender" value="男" checked/>男<input type="radio" name="gender" value="女"/>女
         <br>
                年龄<input type="text" name="age" >
                <br>
          入职日期<input type="" name="hiredate" >
          <br>
          薪资<input type="text" name="salary" >
          <br>
          电话号码<input type="text" name="phone" >
          <br>
          e-mail<input type="text" name="email" >
          <br>
          <span>${pageScope.rigister_msg }</span>
          <input type="reset" value="重置">
          
          <input type="submit" value="注册" >
         
        </form>
</body>
</html>