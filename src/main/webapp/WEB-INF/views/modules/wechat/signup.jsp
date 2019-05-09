<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1">
    <title>报名</title>
</head>
<body>
<form:form modelAttribute="signUp" action="${ctx}/auth/signup" method="post">
    <div class="control-group">
        <label class="control-label">类别名称：</label>
        <div class="controls">
            <form:input path="name" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>
</form:form>
</body>
</html>
