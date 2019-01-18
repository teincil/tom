<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>xxx欢迎来到员工管理系统</h1>
 
   <a href="${pageContext.request.contextPath }/login.jsp">登录</a>
   <a href="${pageContext.request.contextPath }/rigister.jsp">注册</a>

 <c:if test="${sessionScope.emp!=null }">
    <a href="${pageContext.request.contextPath }/listServlet">员工列表</a>
    <a href="${pageContext.request.contextPath }/safeOutServlet">安全退出</a>
    <div style="text-align: right;">上次登陆时间:${lasttime }</div>
 </c:if>
 
 
</body>
</html>