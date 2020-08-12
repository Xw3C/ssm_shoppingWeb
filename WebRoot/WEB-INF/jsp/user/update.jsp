<%@ taglib prefix="pa" uri="http://jsptags.com/tags/navigation/pager" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>新增类目</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
</head>

<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">修改用户信息</span></strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/user/exUpdate" method="post" class="form-x">
            <input type="hidden" name="id" value="${obj.id}"/>
            <div class="form-group">
                <div class="label"><label>用户名:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="userName" data-validate="required:请输入名称" value="${obj.userName}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>密码:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="passWord" data-validate="required:请输入密码" value="${obj.passWord}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>手机号:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="phone" data-validate="required:请输入手机号" value="${obj.phone}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>真实姓名:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="realName" data-validate="required:请输入真实姓名" value="${obj.realName}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>性别:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="sex" data-validate="required:请输入性别" value="${obj.sex}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>地址:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="address" data-validate="required:请输入名称" value="${obj.address}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>邮箱:</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="email" data-validate="required:请输入名称" value="${obj.email}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>