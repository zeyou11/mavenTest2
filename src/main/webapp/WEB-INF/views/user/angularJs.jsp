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
    <script type="text/javascript" src="js/angular.min.js"></script>
    <style>
        table, th, td {
            border: 1px solid grey;
            border-collapse: collapse;
            padding: 5px;
        }

        table tr:nth-child(odd) {
            background-color: #f1f1f1;
        }

        table tr:nth-child(even) {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div ng-app="myApp" ng-init="firstName='John';person={firstName:'John1',lastName:'Doe'}"
     ng-controller="myCtll">
    <p>名字 : <input type="text" ng-model="name"></p>
    <h1>Hello {{name}}</h1>
    <p>姓名为 <span ng-bind="firstName"></span></p>
    <p>{{person.firstName}}</p>
    <h2>乘法计算器</h2>
    <P>乘数：<input type="text" ng-model="cs"></P>
    <P>被乘数：<input type="text" ng-model="bcs"></P>
    <p>结果：{{cs * bcs}}</p>
    <p>使用ng-repeat循环数组</p>
    <p>作用域在控制器给视图表达式绑定数据{{carname}}</p>
    <p>过滤器</p>
    <p><input type="text" ng-model="test"></p>
    <ul>
        <li ng-repeat="x in names | filter:test | orderBy:'country'" onclick="liShow(this)">
            {{ (x.name | uppercase) + ', ' + x.country }}
        </li>
    </ul>
    <p>下拉框</p>
    <select>
        <option ng-repeat="x in names">{{x.name}}</option>
    </select>
    <p>后台返回的json数据</p>
    <ul>
        <li ng-repeat="x in namess | orderBy:'age'">
            {{ (x.name | uppercase) + ', ' + x.age }}
        </li>
    </ul>
    <p>表格</p>
    <table cellpadding="0" cellspacing="0">
        <tr ng-repeat="x in namess | orderBy : 'age'">
            <td>{{x.name | uppercase}}</td>
            <td>{{x.age}}</td>
        </tr>
    </table>
    <p>表单</p>
    <div>
        <form novalidate>
            First Name:<br>
            <input type="text" ng-model="user.firstName"><br>
            Last Name:<br>
            <input type="text" ng-model="user.lastName">
            <br><br>
            <button ng-click="reset()">RESET</button>
        </form>
        <p>form = {{user}}</p>
        <p>master = {{master}}</p>
    </div>
</div>
<script type="text/javascript" src="js/myApp.js"></script>
</body>
</html>
