<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10" />
    <title>报名</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${ctxStatic}/wexin/css/base.css"/>
</head>
<body>
<div class="container">
    <div class="panel">
        <div class="panel-title topic clearfix">
            <div class="col-xs-4 txt">
                <p>参赛数</p>
                <p>90</p>
            </div>
            <div class="col-xs-4 txt">
                <p>投票数</p>
                <p>45672</p>
            </div>
            <div class="col-xs-4 txt">
                <p>访问量</p>
                <p>19632</p>
            </div>
        </div>
        <div class="panel-body">
            <div class="time">距离活动结束还剩：<span id="countdown"></span></div>
            <div class="form">
                <form:form cssClass="form-horizontal" modelAttribute="signUp" action="${ctx}/sign/signup" method="post" enctype="multipart/form-data">
                    <sys:message content="${message}"/>
                    <div class="form-group">
                        <label for="name" class="col-xs-3 control-label">姓名:</label>
                        <div class="col-xs-8 msg">
                            <form:input path="name" htmlEscape="false" maxlength="64" cssClass="form-control" placeholder="请填写姓名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-xs-3 control-label">邮箱:</label>
                        <div class="col-xs-8 msg">
                            <form:input path="email" htmlEscape="false" maxlength="64" cssClass="form-control" placeholder="请填写邮箱"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tel" class="col-xs-3 control-label">电话:</label>
                        <div class="col-xs-8 msg">
                            <form:input path="tel" htmlEscape="false" maxlength="64" cssClass="form-control" placeholder="请填写电话"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remarks" class="col-xs-3 control-label">参赛宣言:</label>
                        <div class="col-xs-8 msg">
                            <form:textarea path="remarks" htmlEscape="false" maxlength="64" cssClass="form-control" placeholder="请填写参赛宣言"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="file" class="col-xs-3 control-label">上传参赛作品:</label>
                        <div class="col-xs-8 msg">
                            <input type="file"/>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
