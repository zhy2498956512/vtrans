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
        <div class="input_box">
            <div class="tips"></div>
            <p class="tit_h3">登录VTrans录音笔</p>
            <div>
                <a class="jump" href="#content1"><div id="gsjs1" class="gsjss" tabindex="2"><span>密码登录</span></div></a>
                <a class="jump" href="#content2"><div id="gsjs2" class="gsjs" tabindex="2"><span>验证登录</span></div></a>
            </div>
            <div class="iphone">
                <input id="userMail" placeholder="请输入邮箱账户">
            </div>
            <div class="iphone" id="content1">
                <input id="userPass" placeholder="请输入用户密码">
            </div>
            <div class="test-code" id="content2">
                <div>
                    <input id="code">
                </div>
                <div>
                    <span>|</span>
                    <input type="button" id="sendsms" value="发送验证码">
                </div>
            </div>
            <div class="btn" id="login">
                <a>登录</a>
            </div>
        </div>
    </div>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/login.js"></script>
</body>
</html>
