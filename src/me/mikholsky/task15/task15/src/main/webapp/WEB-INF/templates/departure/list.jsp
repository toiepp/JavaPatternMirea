<%--
  User: mikholskiyivan
  Date: 3/20/22 3:24 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All departures</title>
</head>
<body>
<jsp:useBean id="listOfDepartures" scope="request" type="java.util.List"/>
<c:forEach var="departure" items="${listOfDepartures}">
    <ul>
        <li>Type: ${departure.type}, Date: ${departure.departureDate}
            <form method="post" action="<c:url value="/departure/delete?id=${departure.id}"/>">
                <input type="submit" value="Delete">
            </form>
        </li>
    </ul>
</c:forEach>
</body>
</html>
