<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>活动管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {

        });

        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/activity/activity/">活动列表</a></li>
    <shiro:hasPermission name="activity:activity:edit">
        <li><a href="${ctx}/activity/activity/form">活动添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="activity" action="${ctx}/activity/activity/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>活动标题：</label>
            <form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
        </li>
        <li><label>开始时间：</label>
            <input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                   value="<fmt:formatDate value="${activity.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </li>
        <li><label>结束时间：</label>
            <input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                   value="<fmt:formatDate value="${activity.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </li>
        <li><label>礼物类别：</label>
            <form:select path="gitCategory.id" class="input-xlarge required">
                <form:option value="">礼物类别</form:option>
                <form:options items="${gitCategorys}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </li>


        <li><label>奖品类别：</label>
            <form:select path="awardCategory.id" class="input-xlarge required">
                <form:option value="">奖品类别</form:option>
                <form:options items="${awardCategorys}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </li>

        <li><label>广告类别：</label>
            <form:select path="advertCategory.id" class="input-xlarge required">
                <form:option value="">奖品类别</form:option>
                <form:options items="${advertCategoryList}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </li>
        <li><label>模板：</label>
            <form:select path="style.id" class="input-xlarge required">
                <form:option value="">模板</form:option>
                <form:options items="${styleList}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </li>

        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>活动标题</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>活动状态</th>
        <shiro:hasPermission name="activity:activity:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="activity">
        <tr>
            <td><a href="${ctx}/activity/activity/form?id=${activity.id}">
                    ${activity.title}
            </a>
            </td>
            <td>
                <fmt:formatDate value="${activity.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                <fmt:formatDate value="${activity.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>

            <td>
                <c:if test="${activity.status==1}">
                    未开始
                </c:if>
                <c:if test="${activity.status==2}">
                    已开始
                </c:if>
                <c:if test="${activity.status==3}">
                    已结束
                </c:if>
            </td>


            <shiro:hasPermission name="activity:activity:edit">
                <td>
                    <c:if test="${activity.status==1}">
                        <a href="${ctx}/activity/activity/form?id=${activity.id}">修改</a>
                    </c:if>
                    <a href="${ctx}/activity/activity/delete?id=${activity.id}"
                       onclick="return confirmx('确认要删除该活动吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>