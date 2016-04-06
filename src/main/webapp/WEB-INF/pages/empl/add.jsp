<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.04.16
  Time: 15:18\
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Empl</title>
</head>
<body>
<form method="POST" action='saveEmpl' >
    <input type="hidden" name="id" value="<c:out value="${employee.id}"/>"/>
    Name : <input type="text" name="name" value="<c:out value="${employee.name}"/>"/><br/>
    Email : <input type="text" name="email" value="<c:out value="${employee.email}"/>"/><br/>
    Date : <input type="date" name="date" value="<c:out value="${employee.date}"/>"/><br/>
    Salary : <input type="text" name="salary" value="<c:out value="${employee.salary}"/>"/><br/>
    <input type="hidden" name="idDep" value="${id_dep}"/><br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
