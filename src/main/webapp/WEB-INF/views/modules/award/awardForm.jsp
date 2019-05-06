<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>奖品管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function (form) {
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
        });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/award/award/">奖品列表</a></li>
    <li class="active"><a href="${ctx}/award/award/form?id=${award.id}">奖品<shiro:hasPermission
            name="award:award:edit">${not empty award.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="award:award:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<form:form id="inputForm" modelAttribute="award" action="${ctx}/award/award/save" method="post" class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>
    <div class="control-group">
        <label class="control-label">奖品名称：</label>
        <div class="controls">
            <form:input path="name" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">奖品图片：</label>
        <div class="controls">
            <form:hidden id="nameImage" path="image" htmlEscape="false" maxlength="255" class="input-xlarge"/>
            <sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100"
                          maxHeight="100"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">奖项：</label>
        <div class="controls">
            <form:select path="item" class="input-xlarge required">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('award_status')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">奖项数量：</label>
        <div class="controls">
            <form:select path="itemCount" class="input-xlarge required">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('award_status_count')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">奖品备注：</label>
        <div class="controls">
            <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="64" class="input-xxlarge "/>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">奖品类别：</label>
        <div class="controls">
            <form:select path="awardCategory.id" class="input-xlarge required">
                <form:option value="" label="奖品类别"/>
                <form:options items="${awardCategoryList}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </div>
    </div>


    <div class="form-actions">
        <shiro:hasPermission name="award:award:edit"><input id="btnSubmit" class="btn btn-primary" type="submit"
                                                            value="保 存"/>&nbsp;</shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>