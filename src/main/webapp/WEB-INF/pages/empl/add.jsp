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
    <link href="<c:url value="css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="center">
    <form method="POST" action='saveEmpl'>

        <input type="hidden" name="idEmp" value="<c:out value="${empl.id}"/>"/>

        <div><label>Employee name</label><br/>
            <input class="input-control text" type="text" name="name" placeholder="Input employee name here..."
                   value="<c:out value="${param['name'] eq null ? empl.name : param['name']}"/>"/>
            <span class="error">${error.name}</span></div>

        <div><label>Employee email</label><br/>
            <input class="input-control text" type="text" name="email" placeholder="Input employee email here..."
                   value="<c:out value="${param['email'] eq null ? empl.email : param['email']}"/>"/>
            <span class="error">${error.email}</span></div>

        <div><label>Date</label><br/>
            <input class="input-control text" type="date" name="date"
                   value="<c:out value="${param['date'] eq null ? empl.date : param['date']}"/>"/>
            <span class="error">${error.get("date")}</span></div>

        <div><label>Employee salary</label><br/>
            <input class="input-control text" type="text" name="salary" placeholder="Input employee salary here..."
                   value="<c:out value="${param['salary'] eq null ? empl.salary : param['salary']}"/>"/>
            <span class="error">${error.get("salary")}</span></div>

        <span><input type="hidden" name="idDep"
        <%--value="${id_dep}"/></span>--%>
                     value="<c:out value="${param['idDep'] eq null ? id_dep : param['idDep']}"/>"/></span>
        <input class="button primary" type="submit" value="Submit"/>
        <input class="button primary" type="reset" value="Reset"/>
    </form>
</div>
</body>
</html>
