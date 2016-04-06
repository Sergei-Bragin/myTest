<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
</head>
<body>
<form method="POST" action='saveDep' >
    <input type="hidden" name="id" value="<c:out value="${department.id}"/>"/>
    Name : <input type="text" name="name" value="<c:out value="${department.name}"/>"/><br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
