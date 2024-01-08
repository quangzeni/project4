<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/dashboardStyle.css" rel="stylesheet"/>
    <title>Dashboard</title>
</head>
<body>
<div class="container dashboard-container">
    <header class="header">
        <h1>Dashboard</h1>
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
            <div class="dashboard-section">
                <h2>Category</h2>
                <p>Total Categories: ${listCategories.size()}</p>
            </div>
            <div class="dashboard-section">
                <h2>Product</h2>
                <p>Total Products: ${productList.size()}</p>
                <p>Total Active Products: ${activeProduct}</p>
                <p>Total Inactive Products: ${productList.size()-activeProduct}</p>
            </div>
            <div class="dashboard-section">
                <h2>Order</h2>
                <p>Total Accounts: ${orderList.size()}</p>
            </div>
            <div class="dashboard-section">
                <h2>Account</h2>
                <p>Total Accounts: ${customerAccountList.size()}</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
