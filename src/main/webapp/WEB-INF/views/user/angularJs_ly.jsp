<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <title>AngularJS 路由实例</title>
</head>
<body ng-app="myApp" ng-controller="userCtrl">
<div class="container">
    <h2>AngularJS 路由应用</h2>
    <ul>
        <li><a href="#/">首页</a></li>
        <li><a href="#/computers">电脑</a></li>
        <li><a href="#/printers">打印机</a></li>
        <li><a href="#/blabla">其他</a></li>
    </ul>

    <div ng-view></div>
</div>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/angular-route.js"></script>
<script type="text/javascript" src="js/ly.js"></script>
</body>
</html>
