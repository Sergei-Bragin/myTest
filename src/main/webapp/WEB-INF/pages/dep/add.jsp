<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
    <link href="<c:url value="css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro-icons.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro-responsive.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro-rtl.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro-schemes.css"/>" rel="stylesheet" type="text/css">
    <script async="" src="//www.google-analytics.com/analytics.js"></script>
    <script src="js/jquery-2.2.3.min.js"></script>
    <script src="js/metro.js"></script>


</head>
<body>
<div class="center">
    <form method="POST" action='saveDep' enctype="multipart/form-data">
        <input type="hidden" name="id" value="<c:out value="${department.id}"/>"/>

        <label>Department name</label><br/>
        <input class="input-control text" type="text" name="name" placeholder="Input you name here..."
               value="<c:out value="${department.name}"/>"/>
        <span class="error">${error.get("name")}</span><br/>

        <%--<label>Department icon</label><br/>
              <input type="file" name="icon" accept="image/*"><br/>--%>
        <label>Department icon</label><br/>
        <div class="input-control file" data-role="input">
            <input class="input-control text" type="file" name="icon" accept="image/*"
            placeholder="Input you image here" value="${icon}"/>
        </div><br/>

        <input class="button primary" type="submit" value="Submit"/>
        <input class="button primary" type="reset" value="Reset"/>
    </form>
</div>
</body>
</html>
