<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department list</title>
</head>
<body>
<table border=1>
    <tr>
        <th>Dep Id</th>
        <th>Department Name</th>
    </tr>
    <c:forEach items="${deps}" var="dep">
        <tr>
            <td><c:out value="${dep.id}" /></td>
            <td><c:out value="${dep.name}" /></td>
            <td><a href="/addDep?id=${dep.id}">Update</a></td>
            <td><a href="/delDep?id=${dep.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<%--<form action="/add" >--%>
    <%--<input type="submit" value="Add Department">--%>
<%--</form>--%>
<a href="/addDep">Add new one</a>
</body>
</html>
