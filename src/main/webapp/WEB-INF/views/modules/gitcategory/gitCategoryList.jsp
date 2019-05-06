<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>礼物类别管理</title>
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
    <li class="active"><a href="${ctx}/gitcategory/gitCategory/">礼物类别列表</a></li>
    <shiro:hasPermission name="gitcategory:gitCategory:edit">
        <li><a href="${ctx}/gitcategory/gitCategory/form">礼物类别添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="gitCategory" action="${ctx}/gitcategory/gitCategory/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>类别名称：</label>
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
        <th>类别名称</th>
        <th>类别图标</th>
        <th>创建日期</th>
        <th>备注</th>
        <shiro:hasPermission name="gitcategory:gitCategory:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="gitCategory">
        <tr>
            <td><a href="${ctx}/gitcategory/gitCategory/form?id=${gitCategory.id}">
                    ${gitCategory.name}
            </a>
            </td>
            <td>
                <img src="${gitCategory.image}" alt="" srcset="" width="50px" height="30px">
            </td>
            <td>
                <fmt:formatDate value="${gitCategory.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${gitCategory.remarks}
            </td>
            <shiro:hasPermission name="gitcategory:gitCategory:edit">
                <td>
                    <a href="${ctx}/gitcategory/gitCategory/form?id=${gitCategory.id}">修改</a>
                    <a href="${ctx}/gitcategory/gitCategory/delete?id=${gitCategory.id}"
                       onclick="return confirmx('确认要删除该礼物类别吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>