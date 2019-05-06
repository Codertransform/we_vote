<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>广告类别管理</title>
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
    <li class="active"><a href="${ctx}/advertcategory/advertCategory/">广告类别列表</a></li>
    <shiro:hasPermission name="advertcategory:advertCategory:edit">
        <li><a href="${ctx}/advertcategory/advertCategory/form">广告类别添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="advertCategory" action="${ctx}/advertcategory/advertCategory/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>广告类别：</label>
            <form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>广告类别</th>
        <th>备注</th>
        <th>创建时间</th>
        <shiro:hasPermission name="advertcategory:advertCategory:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="advertCategory">
        <tr>
            <td><a href="${ctx}/advertcategory/advertCategory/form?id=${advertCategory.id}">
                    ${advertCategory.name}
            </a></td>
            <td>
                    ${advertCategory.remarks}
            </td>
            <td>
                <fmt:formatDate value="${advertCategory.createDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
            </td>
            <shiro:hasPermission name="advertcategory:advertCategory:edit">
                <td>
                    <a href="${ctx}/advertcategory/advertCategory/form?id=${advertCategory.id}">修改</a>
                    <a href="${ctx}/advertcategory/advertCategory/delete?id=${advertCategory.id}"
                       onclick="return confirmx('确认要删除该广告类别吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>