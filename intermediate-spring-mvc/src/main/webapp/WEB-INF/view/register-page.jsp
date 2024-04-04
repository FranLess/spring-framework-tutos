<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>My JSP Page</title>
  </head>
  <body>
    <h1>Register succesfull!!!</h1>

    <!-- Example: Using <c:out> to display a variable -->
    <c:set var="pageTitle" value="JSTL Core Tags Example" />
    <p>Page Title: <c:out value="${pageTitle}" /></p>
    <br />
    <h4>User:</h4>
    ${user.name}
    <br />
    <h4>User name:</h4>
    ${user.userName}
    <br />
    <h4>Country</h4>
    ${user.country}
    <br />
    <h4>Password:</h4>
    ${user.password}
    <br />
    <h4>Hobbies:</h4>
    ${user.hobbies}
    <br />

    <!-- Example: Iterating over a list (replace with your own data) -->
    <c:forEach var="hobbie" items="${user.hobbies}">
      <p>${hobbie}</p>
    </c:forEach>

    <!-- Add more JSTL tags and your custom content here -->
  </body>
</html>
