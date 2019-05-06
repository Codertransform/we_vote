<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>活动链接管理</title>
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
    <li class="active"><a href="${ctx}/activitylink/activityLink/">活动链接列表</a></li>
    <shiro:hasPermission name="activitylink:activityLink:edit">
        <li><a href="${ctx}/activitylink/activityLink/form">活动链接添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="activityLink" action="${ctx}/activitylink/activityLink/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>活动：</label>
            <form:select path="activity.id" class="input-xlarge required">
                <form:option value="">活动</form:option>
                <form:options items="${activityList}" itemLabel="title" itemValue="id"
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
        <th>活动链接</th>
        <shiro:hasPermission name="activitylink:activityLink:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="activityLink">
        <tr>
            <td>
                <a href="${ctx}/activitylink/activityLink/form?id=${activityLink.id}"> ${activityLink.activity.title}</a>
            </td>

            <td>
                    ${activityLink.url}
            </td>

            <shiro:hasPermission name="activitylink:activityLink:edit">
                <td>
                    <c:if test="${empty activityLink.id}">
                        <a href="${ctx}/activitylink/activityLink/form?id=${activityLink.id}">生成链接</a>
                    </c:if>
                    <a href="${ctx}/activitylink/activityLink/delete?id=${activityLink.id}"
                       onclick="return confirmx('确认要删除该活动链接吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>