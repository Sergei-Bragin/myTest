<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department list</title>
    <link href="<c:url value="css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="css/metro.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="center">

    <table class="table hovered">
        <tbody>
        <tr>
            <th></th>
            <th>Id</th>
            <th>Name</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${deps}" var="dep">

            <tr>
                <td><img src="/image+${dep.id}"></td>
                <td><c:out value="${dep.id}"/></td>
                <td><c:out value="${dep.name}"/></td>
                <td>
                    <form method="post" action="/delDep">
                        <input type="hidden" name="id" value=${dep.id}>
                        <button class="button  primary" type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <form method="post" action="/addDep">
                        <input type="hidden" name="id" value=${dep.id}>
                        <button class="button  primary" type="submit">Update</button>
                    </form>
                </td>
                <td>
                    <form method="get" action="/showDepEmpl">
                        <input type="hidden" name="id" value="${dep.id}">
                        <input class="button primary" type="submit" value="List empl">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form method="get" action="/addDep">
        <button class="button primary block-shadow-success text-shadow " type="submit">+Add new one</button>
    </form>

</div>
</body>
</html>
