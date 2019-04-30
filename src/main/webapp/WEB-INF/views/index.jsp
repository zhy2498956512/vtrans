<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/29
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>VTrans录音笔</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="main">
    <div class="top">
        <div class="top-information">
            <div class="app">手机APP</div>
            <div>|</div>
            <div class="sign-out">退出</div>
            <div>${sessionScope.User.userName}</div>
        </div>
    </div>
    <div class="QRCode">
        <img style="width: 95%;margin-left: 5px;margin-top: 5px" src="http://vormor.cn:8080/img/QRCode.png">
        <p style=";margin-left: 33px;margin-top: 0px">扫描下载APP(安卓)</p>
    </div>
    <div class="left">
        <div class="left-top">
            <span style="font-size: 26px;margin-left: 80px;">录音</span><span style="font-size: 12px;margin-left: 10px;">${recordingList.size()}个录音</span>
        </div>
        <ul class="navbar">
            <c:forEach items="${recordingList}" var="recording">
                <li class="list active">
                    <h3>${recording.recordingName}</h3>
                    <div class="text">你好。早上好！</div>
                    <div class="footer">
                        <span>2019年04月28日   16:35:01</span>
                    </div>
                    <div class="line"></div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="right">
        <audio src="http://vormor.cn:8080/MP3/%E7%8E%8B%E5%A4%A9%E9%98%B3%20-%20%E7%88%B1%E5%A6%82%E6%BD%AE%E6%B0%B4%EF%BC%88Cover%EF%BC%9AGAI%E7%88%B7%EF%BC%89.mp3" controls="controls" loop="loop" autoplay="autoplay">亲 您的浏览器不支持html5的audio标签</audio>
    </div>

    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/index.js"></script>
</div>
</body>
</html>
