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
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script type="text/javascript" src="js/angular-animate.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="userCtrl">

<div class="container">
    <div ng-include="'js/myUsers_List.html'"></div>
    <div ng-include="'js/myUsers_Form.html'"></div>
</div>
<script type="text/javascript" src="js/myApp1.js"></script>
</body>
</html>
