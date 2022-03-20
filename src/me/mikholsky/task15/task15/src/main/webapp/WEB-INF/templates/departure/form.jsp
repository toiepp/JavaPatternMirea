<%--
  User: mikholskiyivan
  Date: 3/20/22 3:15 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>New departure</title>
</head>
<body>
<%--@elvariable id="departure" type="me.mikholskiy.entities.Departure"--%>
<form:form action="/departure/new" method="post" modelAttribute="departure">
    Type: <form:input path="type"/>
    <br><br>
    Date (yyyy-MM-dd): <form:input path="departureDate"/>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
