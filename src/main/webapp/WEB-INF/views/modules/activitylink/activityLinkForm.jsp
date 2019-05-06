<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>活动链接管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
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


        function produceUrl() {
            //获取当前选择项.
            var selectValue = $("#selectActivity").find("option:selected").val();

            if (selectValue == '') {
                $.jBox.warning("请先选择活动");
                return;
            } else {
                $.ajax({
                    url: "produceUrl",
                    data: "selectValue=" + selectValue,
                    async: false,//关闭异步请求
                    success: function (result) {
                        if (result.success) {
                            $("#urlValue").attr("value", result.url);
                        } else if (resule.success == false) {
                            $.jBox.warning("未先选择活动");
                        }
                    },
                    error: function (result) {
                        $.jBox.warning("生成连接失败");
                    }
                });
            }


        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/activitylink/activityLink/">活动链接列表</a></li>
    <li class="active"><a href="${ctx}/activitylink/activityLink/form?id=${activityLink.id}">活动链接<shiro:hasPermission
            name="activitylink:activityLink:edit">${not empty activityLink.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission
            name="activitylink:activityLink:edit">查看</shiro:lacksPermission></a></li>
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
<form:form id="inputForm" modelAttribute="activityLink" action="${ctx}/activitylink/activityLink/save" method="post"
           class="form-horizontal">
    <form:hidden path="id"/>
    <sys:message content="${message}"/>


    <div class="control-group">
        <label class="control-label">活动：</label>
        <div class="controls">
            <form:select path="activity.id" class="input-xlarge required" id="selectActivity">
                <form:option value="">请选择活动</form:option>
                <form:options items="${activityList}" itemLabel="title" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">活动链接：</label>
        <div class="controls">
            <form:textarea path="url" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge required"
                           id="urlValue"/>
            <span class=" btn btn-primary" onclick="produceUrl()">生成连接</span>
            <span class="help-inline"><font color="red">*</font> </span>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label">备注：</label>
        <div class="controls">
            <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="64" class="input-xxlarge "/>
        </div>
    </div>
    <div class="form-actions">
        <c:if test="${empty activityLink.id}">
            <shiro:hasPermission name="activitylink:activityLink:edit">
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
            </shiro:hasPermission>
        </c:if>
        <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>

</body>
</html>