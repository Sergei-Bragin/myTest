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
    <input class="input-control text" type="text" name="name"  placeholder="Input you name here..." value="<c:out value="${department.name}${dep_name}"/>"/>
    <span class="error"/>${error.get("name")}</span><br/>
    <input class="button success" type="submit" value="Submit" />
    <input class="button warning" type="reset" value="Reset"/>
</form>
   <%-- <div class="input-control text full-size required">
        <input type="text" data-validate-func="required" data-validate-hint="${error.get("name")}" data-validate-hint-position="right">
        <span class="input-state-error mif-warning"></span>
        <span class="input-state-success mif-checkmark"></span>
        <input class="button success" type="submit" value="Submit"/>
    </div>
--%>
</div>
</body>
</html>
