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
     <table border="1" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>入职日期</th>
            <th>工资</th>
            <th>电话</th>
            <th>e-mail</th>
            <th>修改</th>
            <th>删除</th>
          </tr>
        </thead>
        <c:forEach items="${requestScope.emp }" var="emp">
           <tr>
             <td>${emp.id }</td>
             <td>${emp.name }</td>
             <td>${emp.password}</td>
             <td>${emp.gender}</td>
             <td>${emp.age}</td>
             <td>${emp.hiredate }</td>
             <td>${emp.salary }</td>
             <td>${emp.phone }</td>
             <td>${emp.email }</td>
             <td><a href="${pageContext.request.contextPath }/FindEmpByIdServlet?id=${emp.id }" >修改</a></td>
             <td><a href="${pageContext.request.contextPath }/DeleteServlet?id=${emp.id }">删除</a></td>
           </tr>
        </c:forEach>
     </table>
     <a href="${pageContext.request.contextPath }/CombackServlet" >恢复</a>
     
</body>
</html>