<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
    <link href="<c:url value="css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="center">
<form method="POST" action='saveDep' >
    <input type="hidden" name="id" value="<c:out value="${department.id}"/>"/>
    Name : <input type="text" name="name" value="<c:out value="${department.name}${dep_name}"/>"/>
    <span class="error"/>${error.get("name")}</span><br/>
    <input class="button15" type="submit" value="Submit" />
</form>
</div>
</body>
</html>
