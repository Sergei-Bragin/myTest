<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
    <link href="<c:url value="css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro.css"/>" rel="stylesheet" type="text/css">
    <script src="js/metro.js"></script>
</head>
<body>
<div class="center">
<form method="POST" action='saveDep' >
    <input type="hidden" name="id" value="<c:out value="${department.id}"/>"/>
    <label>Department name</label><br/>
    <input class="input-control text" type="text" name="name"  placeholder="Input you name here..." value="<c:out value="${department.name}"/>"/>
    <span class="error">${error.get("name")}</span><br/>
    <input class="button primary" type="submit" value="Submit" />
    <input class="button primary" type="reset" value="Reset"/>
</form>
</div>
</body>
</html>
