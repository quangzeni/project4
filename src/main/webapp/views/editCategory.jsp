<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 1/6/2024
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/createStyle.css" rel="stylesheet"/>
    <title>Edit Category</title>
</head>
<body>
<div class="container">
    <form action="<%=request.getContextPath()%>/categoryController/update" method="post">
        <label for="id">CategoryId</label>
        <input type="number" id="id" name="id" value="${categoryUpdate.id}" readonly/><br>
        <label for="categoryName">Category Name</label>
        <input type="text" id="categoryName" name="categoryName" value="${categoryUpdate.categoryName}"/><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description" value="${categoryUpdate.description}"/><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" value="true" ${categoryUpdate.status?"checked":""}>
        <label for="active">Active</label>
        <input type="radio" id="inactive" name="status" value="false" ${categoryUpdate.status?"":"checked"}>
        <label for="inactive">Inactive</label><br>
        <input type="submit" value="Update"/>
    </form>
</div>
</body>
</html>
