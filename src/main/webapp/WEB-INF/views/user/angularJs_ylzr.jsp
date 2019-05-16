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
</head>
<body>

<div ng-app="ylzrApp" ng-controller="ylzrCtrl">
    <p>输入一个数字: <input type="number" ng-model="number"/></p>
    <button ng-click="ksjs()">X<sup>2</sup></button>
    <p>结果: {{result}}</p>
</div>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/ylzr.js"></script>
</body>
</html>
