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
<div>
    <h3>Filtering</h3>
    <form action="${pageContext.request.contextPath}/departure/list">
        Type: <input type="text" name="by-type">,
        departure date: <input type="text" name="by-departure-date">
        <input type="submit" value="Filter">
    </form>
</div>
<br>
<div>
    <jsp:useBean id="listOfDepartures" scope="request" type="java.util.List"/>
    <c:choose>
        <c:when test="${listOfDepartures.size() == 0}">
            <h1>No departures</h1>
        </c:when>
        <c:otherwise>
            <c:forEach var="departure" items="${listOfDepartures}">
                <ul>
                    <li>Type: ${departure.type}, Date: ${departure.departureDate}; <br>
                        POST OFFICE: ${departure.departurePostOffice.name}, ${departure.departurePostOffice.cityName}
                        <form method="post" action="<c:url value="/departure/delete?id=${departure.id}"/>">
                            <input type="submit" value="Delete">
                        </form>
                    </li>
                </ul>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
