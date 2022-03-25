<%--
  User: mikholskiyivan
  Date: 3/20/22 3:15 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>New post office</title>
</head>
<body>
<%--@elvariable id="postOffice" type="me.mikholskiy.entities.PostOffice"--%>
<form:form action="/post-office/new" method="post" modelAttribute="postOffice">
    Name: <form:input path="name"/>
    <br><br>
    City: <form:input path="cityName"/>
    <input type="submit" value="Submit">
</form:form>
<br>
<a href="${pageContext.request.contextPath}/post-office"></a>

</body>
</html>
