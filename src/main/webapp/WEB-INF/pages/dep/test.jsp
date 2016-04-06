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
            <%--<td><a methods="POST" href="/addDep?id=${dep.id}">Update</a></td>
            <td><a href="/delDep?id=${dep.id}">Delete</a></td>--%>
            <td>
                <form method="post" action="/delDep">
                    <input type="hidden" name="id" value=${dep.id}>
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form method="post" action="/addDep">
                    <input type="hidden" name="id" value=${dep.id}>
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form method="get" action="/showDepEmpl">
                    <input type="hidden" name="id" value="${dep.id}">
                    <input type="submit" value="List empl">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/addDep">Add new one</a>
</body>
</html>
