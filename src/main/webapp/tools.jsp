<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 18.05.2019
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--screwdriver - id 1001 - 5<form> Podaj ilosc: <input type="text" name="screwdriver"> <input type="submit" value="Wypozycz"><br> </form>--%>
<%--hammer - id 1002 - 8<form> Podaj ilosc: <input type="text" name="screwdriver"> <input type="submit" value="Wypozycz"><br> </form>--%>

<h2>Tools:</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Tool type</th>
        <th>Available</th>
        <th>Take/Return</th>
    </tr>

    <c:forEach items="${applicationScope.tools}" var="tool">
        <tr>
            <td>${tool.id}</td>
            <td>${tool.name}</td>
            <td>${tool.type}</td>
            <c:choose>
                <c:when test="${tool.available}">
                    <td style="background-color: GREEN"></td>
                    <td>
                        <form>
                            <input type="hidden" name="action" value="take">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value="Take">
                        </form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td style="background-color: RED"></td>
                    <td>
                        <form>
                            <input type="hidden" name="action" value="return">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value="Return">
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>

</body>
</html>
