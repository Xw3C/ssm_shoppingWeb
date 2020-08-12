<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>


</head>
<body>
    <div class="width100 hidden_yh" style="border-top: 1px solid #ddd">
        <div class="width1200 hidden_yh center_yh" style="margin-top: 75px">
            <form action="${ctx/login}/login/toRes" method="post">
                <div class="center_yh hidden_yh" style="width: 475px;margin-bottom: 40px;">
                    <span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px;" class="left_yh block_yh tright">用户名</span>
                    <input type="text" name="userName" placeholder="请输入您的用户名" style="border: 1px solid #c9c9c9;width: 292px;height: 42px;font-size: 16px;text-indent: 22px;"class="left_yh">
                </div>
            </form>
        </div>
    </div>

    <%@include file="/common/ufooter.jsp"%>
</body>
</html>