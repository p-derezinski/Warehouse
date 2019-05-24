<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 20.05.2019
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="hidden" name="action" value="logout">
    <input type="submit" value="Log out">
</form>

</body>
</html>
