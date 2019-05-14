<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#search").click(function () {
                alert($("#username").val());
                $.ajax({
                    type: "POST",
                    url: "user/queryByUserName",
                    data: {
                        "username": $("#username").val()
                    },
                    dataType: "json",
                    success: function (data) {
                        var obj1 = data.obj1;
                        var user = data.user;
                        if (user == null) {
                            alert("请输入正确的用户名！");
                            return;
                        }
                        var html = "<td>" + user.id + obj1 + "</td><td>" + user.username + "</td><td>"
                            + user.password
                            + "</td><td>" + user.realname + "</td>";
                        $("#user").html(html);
                    },
                    //null值不会被success回调函数捕获，因此可以通过error来实现该功能
                    error: function () {
                        alert("请输入正确的用户名！");
                    }
                })
            })
        })
    </script>
</head>
<body>
<center>
    <div style="margin-top: 25px">
        请输入查询的用户名:
        <input type="text" id="username"/>
        <input id="search" style="margin-left: 10px" type="button" value="搜索">
    </div>
    <div style="margin-top: 50px">
        <table border="1">
            <tr>
                <td>主键</td>
                <td>用户名</td>
                <td>密码</td>
                <td>姓名</td>
            </tr>
            <tr id="user">
            </tr>
        </table>
    </div>
</center>
</body>
</html>
