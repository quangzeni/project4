<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 1/6/2024
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/createStyle.css" rel="stylesheet"/>
    <title>Update Product</title>
</head>
<body>
<div class="container">
    <form action="<%=request.getContextPath()%>/productController/update" method="post">
        <label for="id">ProductId</label>
        <input type="number" id="id" name="id" value="${productUpdate.id}" readonly/><br>
        <label for="categoryName">Product Name</label>
        <input type="text" id="categoryName" name="categoryName" value="${productUpdate.productName}"/><br>
        <label for="price">Price</label>
        <input type="number" id="price" name="price" value="${productUpdate.price}"><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description" value="${productUpdate.description}"/><br>
        <label for="category_id">CategoryName</label>
        <input type="text" id="category_id" name="category.id" value="${productUpdate.category.categoryName}" readonly>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" value="true" ${productUpdate.status?"checked":""}>
        <label for="active">Active</label>
        <input type="radio" id="inactive" name="status" value="false" ${productUpdate.status?"":"checked"}>
        <label for="inactive">Inactive</label><br>

        <input type="submit" value="Update"/>
    </form>
</div>
</body>
</html>
