<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 1/7/2024
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/userStyle.css" rel="stylesheet"/>
    <title>Customer Account</title>
</head>
<body>
<div class="container">
    <header class="header">
        <h1>Customer Account Manager</h1>
    </header>
    <div class="main-content">
        <div class="left sidebar">
            <ul>
                <li><a href="<%=request.getContextPath()%>/dashboardController">Dashboard</a></li>
                <li><a href="<%=request.getContextPath()%>/categoryController/findAll">Category Management</a></li>
                <li><a href="<%=request.getContextPath()%>/productController/findAll">Product Management</a></li>
                <li><a href="<%=request.getContextPath()%>/customerAccountController/findAll">Customer Management</a></li>
                <li><a href="<%=request.getContextPath()%>/orderController/findAll">Order Management</a></li>
            </ul>
        </div>
        <div class="content">
            <%--            Tìm kiếm và sắp xếp--%>
            <div class="table-controls">
                <div class="search-container">
                    <input type="text" id="searchInput" name="searchInput" placeholder="Enter Customer Account name">
                    <button class="btn btn-search">Search</button>
                </div>
                <div class="sort-container">
                    <select id="sortSelect" name="sortSelect">
                        <option value="asc">Ascending</option>
                        <option value="desc">Descending</option>
                    </select>
                    <button class="btn btn-sort">Sort</button>
                </div>
            </div>

            <%--             Bảng--%>
            <table border="1">
                <thead>
                <tr>
                    <th>Account Id</th>
                    <th>Account Email</th>
                    <th>Created at</th>
                    <th>role</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCustomerAccount}" var="customerAccount">
                    <tr>
                        <td>${customerAccount.id}</td>
                        <td>${customerAccount.email}</td>
                        <td>${customerAccount.createdAt}</td>
                        <td>${customerAccount.role}</td>
                        <td>${customerAccount.status?"Active":"Inactive"}</td>
<%--                        <td>--%>
<%--                            <div class="btn-container">--%>
<%--                                <a href="<%=request.getContextPath()%>/customerAccountController/initUpdate/${customerAccount.id}"--%>
<%--                                   class="btn btn-update">Update</a>--%>
<%--                                <a href="<%=request.getContextPath()%>/customerAccountController/delete/${customerAccount.id}"--%>
<%--                                   class="btn btn-delete">Delete</a>--%>
<%--                            </div>--%>
<%--                        </td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
<%--            <div class="button-container">--%>
<%--                <a href="<%=request.getContextPath()%>/views/newCategory.jsp">--%>
<%--                    <button class="btn btn-create">Create New Category</button>--%>
<%--                </a>--%>
<%--            </div>--%>
        </div>
    </div>
</div>
</body>
</html>
