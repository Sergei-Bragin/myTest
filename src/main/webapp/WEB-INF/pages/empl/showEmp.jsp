<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empl List</title>
    <link href="<c:url value="css/main.css"/>" rel="stylesheet">
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Date</th>
        <th>Salary</th>
    </tr>
    <c:forEach items="${empls}" var="empl">
        <tr>
            <td><c:out value="${empl.id}" /></td>
            <td><c:out value="${empl.name}" /></td>
            <td><c:out value="${empl.email}" /></td>
            <td><c:out value="${empl.date}" /></td>
            <td><c:out value="${empl.salary}" /></td>
            <td>
                <form method="post" action="/delEmpl">
                    <input type="hidden" name="id" value=${empl.id}>
                    <input type="hidden" name="depId" value="${id_dep}">
                    <input class="button15" type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form method="get" action="/addEmpl">
                    <input type="hidden" name="idEmp" value=${empl.id}>
                    <input type="hidden" name="id" value="${id_dep}">
                    <input class="button15" type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/addEmpl?id=${id_dep}">Add new one</a>
</body>
</html>
