<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empl List</title>
</head>
<body>
<table border=1>
    <tr>
        <th>Emp Id</th>
        <th>Emp Name</th>
        <th>Emp Email</th>
        <th>Emp Date</th>
        <th>Emp Salary</th>
    </tr>
    <c:forEach items="${empls}" var="empl">
        <tr>
            <td><c:out value="${empl.id}" /></td>
            <td><c:out value="${empl.name}" /></td>
            <td><c:out value="${empl.email}" /></td>
            <td><c:out value="${empl.date}" /></td>
            <td><c:out value="${empl.salary}" /></td>
            <td>
                <form method="post" action="/del">
                    <input type="hidden" name="id" value=${empl.id}>
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form method="post" action="/addDep">
                    <input type="hidden" name="id" value=${empl.id}>
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/addEmpl?id=${id_dep}">Add new one</a>
</body>
</html>
