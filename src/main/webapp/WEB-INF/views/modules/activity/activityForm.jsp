<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>活动管理</title>
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
    <li><a href="${ctx}/activity/activity/">活动列表</a></li>
    <li class="active"><a href="${ctx}/activity/activity/form?id=${activity.id}">活动<shiro:hasPermission
            name="activity:activity:edit">${not empty activity.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="activity:activity:edit">查看</shiro:lacksPermission></a></li>
</ul>
<br/>
<c:if test="${not empty errorMessage}">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>
                        注意!
                    </h4><font color="red"><strong>${errorMessage}！</strong></font>
                </div>
            </div>
        </div>
    </div>
</c:if>
<form:form id="inputForm" modelAttribute="activity" action="${ctx}/activity/activity/save" method="post"
           class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>

    <div class="control-group">
        <label class="control-label">开始时间：</label>
        <div class="controls">
            <input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
                   value="<fmt:formatDate value="${activity.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">结束时间：</label>
        <div class="controls">
            <input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
                   value="<fmt:formatDate value="${activity.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">活动通知：</label>
        <div class="controls">
            <form:input path="notify" htmlEscape="false" maxlength="255" class="input-xlarge " placeholder="(页面头部滚动)"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">活动标题：</label>
        <div class="controls">
            <form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">奖品类别：</label>
        <div class="controls">
            <form:select path="awardCategory.id" class="input-xlarge required">
                <form:option value="" label="奖品类别"/>
                <form:options items="${awardCategorys}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">广告类别：</label>
        <div class="controls">
            <form:select path="advertCategory.id" class="input-xlarge required">
                <form:option value="" label="奖品类别"/>
                <form:options items="${advertCategoryList}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">礼物类别：</label>
        <div class="controls">
            <form:select path="gitCategory.id" class="input-xlarge required">
                <form:option value="" label="礼物类别"/>
                <form:options items="${gitCategorys}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">模板：</label>
        <div class="controls">
            <form:select path="style.id" class="input-xlarge required">
                <form:option value="" label="模板"/>
                <form:options items="${styleList}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">活动规则：</label>
        <div class="controls">
            <form:textarea path="rules" htmlEscape="false" rows="4" maxlength="64" class="input-xxlarge "/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">活动内容：</label>
        <div class="controls">
            <form:textarea path="contents" htmlEscape="false" rows="4" maxlength="64" class="input-xxlarge "/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="64" class="input-xxlarge "/>
        </div>
    </div>

    <div class="form-actions">

        <shiro:hasPermission name="activity:activity:edit">
            <c:choose>
                <c:when test="${empty activity.id}">
                    <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
                </c:when>
                <c:when test="${ activity.status==1}">
                    <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
                </c:when>
            </c:choose>
        </shiro:hasPermission>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>