<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/28
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>VTrans录音笔</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="main">
        <div class="inputBox"></div>
    </div>
</body>
</html>
