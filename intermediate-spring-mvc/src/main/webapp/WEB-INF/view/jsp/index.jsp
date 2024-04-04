<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Thyme Seed Starter Manager</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <form:form action="show/jsp" method="get" modelAttribute="book">
        <label for="title">Title</label>
        <form:input path="title" id="title" />
        <label for="description">Description</label>
        <form:input path="description" id="description" />
        <label for="author">Author</label>
        <form:input path="author" id="author" />
        <input type="submit" value="Enviar" />
    </form:form>
</body>
</html>
