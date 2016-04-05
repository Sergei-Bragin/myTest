<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
</head>
<body>
<form method="POST" action='saveDep' name="frmAddUser">
    <input type="hidden" name="id" value="${department.id}"/>
    Name : <input type="text" name="name" value="${dep.name}" /> <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
