<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>模板管理</title>
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
    <li class="active"><a href="${ctx}/style/style/">模板列表</a></li>
    <shiro:hasPermission name="style:style:edit">
        <li><a href="${ctx}/style/style/form">模板添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="style" action="${ctx}/style/style/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>模板名称：</label>
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
        <th>模板名称</th>
        <th>参考图</th>
        <th>备注</th>
        <th>创建日期</th>
        <shiro:hasPermission name="style:style:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="style">
        <tr>
            <td><a href="${ctx}/style/style/form?id=${style.id}">
                    ${style.name}
            </a></td>
            <td>
                <img src="${style.image}" alt="" srcset="" width="50px" height="30px">
            </td>
            <td>
                    ${style.remarks}
            </td>
            <td>
                <fmt:formatDate value="${style.createDate}" pattern="yyyy-MM-dd "/>
            </td>
            <shiro:hasPermission name="style:style:edit">
                <td>
                    <a href="${ctx}/style/style/form?id=${style.id}">修改</a>
                    <a href="${ctx}/style/style/delete?id=${style.id}"
                       onclick="return confirmx('确认要删除该模板吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>