<%--
  User: mikholskiyivan
  Date: 3/20/22 3:24 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All post offices</title>
</head>
<body>
<div>
    <h3>Filtering</h3>
    <form action="${pageContext.request.contextPath}/post-office/list" method="get">
        Name: <input type="text" name="by-name">,
        city <input type="text" name="by-city">
        <input type="submit" value="Filter">
    </form>
</div>
<br>
<div>
    <jsp:useBean id="listOfPostOffices" scope="request" type="java.util.List"/>
    <c:forEach var="postOffice" items="${listOfPostOffices}">
        <ul>
            <li>Name: ${postOffice.name}, City: ${postOffice.cityName}
                <form method="post" action="<c:url value="/post-office/delete?id=${postOffice.id}"/>">
                    <input type="submit" value="Delete">
                </form>
                <form method="get" action="<c:url value="/post-office/${postOffice.getId()}/departures"/>">
                    <input type="submit" value="Get all departures">
                </form>
            </li>
        </ul>
    </c:forEach>
</div>
</body>
</html>
