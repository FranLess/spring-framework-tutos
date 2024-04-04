<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
  </head>
  <body>
    <form:form action="/book/home" modelAtrribute="book">
      <label for="title">Title</label>
      <form:input id="title" path="title"></form:input>
      <label for="description">Description</label>
      <form:input id="description" path="description"></form:input>
      <label for="author">Author</label>
      <form:input id="author" path="author"></form:input>
    </form:form>
  </body>
</html>
