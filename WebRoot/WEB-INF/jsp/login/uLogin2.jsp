<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${ctx}login2.css">
    <link rel="stylesheet" href="${ctx}music.css">
</head>
<body data-vide-bg='${ctx}birds.mp4' >

<div class="play"></div>
<div class="login-form">
    <div action="${ctx}/login/utoLogin" method="post">
        <h2>Sign In</h2>
        <div class="form-input">
            <input type="text" name='userName' placeholder="请输入用户名或手机号">
        </div>
        <div class="form-input">
            <input type="password" name='passWord' placeholder="请输入密码">
        </div>
        <div class="form-input">
            <input type="submit"  value='登录'>
        </div>
        <a href="#" class="forget">忘记密码(暂未开通)</a>
</div>
</div>
<script src="/resource/js/jquery-3.3.1.js"></script>
<script src="/resource/js/jquery.vide.js"></script>
</body>
</html>