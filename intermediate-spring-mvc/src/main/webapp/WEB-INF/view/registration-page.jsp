<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ taglib prefix="spring"
uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Spring Thyme Seed Starter Manager</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
    <div center="1">
      <h1>Register here</h1>
      <form:form action="register" method="get" modelAttribute="user">
        <label for="name">Name</label>
        <form:input id="name" path="name" />
        <br />
        <label for="userName">User name</label>
        <form:input id="userName" path="userName" />
        <br />
        <label for="password">Password</label>
        <form:input id="password" path="password" />
        <br />
        <label for="country">Country</label>
        <form:select path="country">
          <form:option value="USA">United States</form:option>
          <form:option value="UK">United Kingdom</form:option>
          <form:option value="MX">México</form:option>
          <form:option value="ES">España</form:option>
        </form:select>
        <label for="">Hobbies: </label>
        <form:checkbox path="hobbies" value="videogames" />Videogames
        <form:checkbox path="hobbies" value="drawing" />Drawing
        <form:checkbox path="hobbies" value="movies" /> Watch movies
        <form:checkbox path="hobbies" value="reading" /> Reading
        <br />
        <label for="">Gender: </label>
        <form:radiobutton path="gender" value="male" /> Male
        <form:radiobutton path="gender" value="female" /> Female
        <br />
        <input type="submit" value="Register" />
      </form:form>
    </div>
  </body>
</html>
