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
    <input type="hidden" name="idEmp" value="<c:out value="${empl.id}"/>"/>
    Name : <input type="text" name="name" value="<c:out value="${empl.name}"/>"/>
    <span class="error">${error.get("name")}</span><br/>
    Email : <input type="text" name="email" value="<c:out value="${empl.email}"/>"/>
    <span class="error">${error.get("email")}</span><br/>
    Date : <input type="date" name="date" value="<c:out value="${empl.date}"/>"/>
    <span class="error">${error.get("date")}</span><br/>
    Salary : <input type="text" name="salary" value="<c:out value="${empl.salary}"/>"/>
    <span class="error">${error.get("salary")}</span><br/>
    <input type="hidden" name="idDep" value="${id_dep}"/><br/>
    <input class="button15" type="submit" value="Submit" />
</form>
</div>
</body>
</html>
