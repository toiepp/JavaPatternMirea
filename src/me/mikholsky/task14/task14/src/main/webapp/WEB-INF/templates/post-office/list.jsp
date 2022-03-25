<%--
  User: mikholskiyivan
  Date: 3/20/22 3:24 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All post offices</title>
</head>
<body>
<jsp:useBean id="listOfPostOffices" scope="request" type="java.util.List"/>
<c:forEach var="postOffice" items="${listOfPostOffices}">
    <ul>
        <li>Name: ${postOffice.name}, City: ${postOffice.cityName}
            <form method="post" action="/post-office/delete/${postOffice.id}">
                <input type="submit" value="Delete">
            </form>
        </li>
    </ul>
</c:forEach>
<br>
<a href="${pageContext.request.contextPath}/post-office">Go back.</a>

</body>
</html>
