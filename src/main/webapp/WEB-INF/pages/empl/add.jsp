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
    <link href="<c:url value="css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="center">
<form method="POST" action='saveEmpl'>
    <input type="hidden" name="idEmp" value="${empl.id}"/>
    Name : <input type="text" name="name" value="${empl.name}"/><br/>
    Email : <input type="text" name="email" value="${empl.email}"/><br/>
    Date : <input type="date" name="date" value="${empl.date}"/><br/>
    Salary : <input type="text" name="salary" value="${empl.salary}"/><br/>
    <input type="hidden" name="idDep" value="${id_dep}"/><br/>
    <input class="button15" type="submit" value="Submit" />
</form>
</div>
</body>
</html>
