<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>礼物管理</title>
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
    <li class="active"><a href="${ctx}/git/git/">礼物列表</a></li>
    <shiro:hasPermission name="git:git:edit">
        <li><a href="${ctx}/git/git/form">礼物添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="git" action="${ctx}/git/git/" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>礼物名称：</label>
            <form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
        </li>


        <li><label>礼物类别：</label>
            <form:select path="gitCategory.id" class="input-xlarge required">
                <form:option value="">礼物类别</form:option>
                <form:options items="${gitCategoryList}" itemLabel="name" itemValue="id"
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

        <th>图标</th>
        <th>礼物名称</th>
        <th>价格</th>
        <th>票数</th>
        <th>备注</th>
        <shiro:hasPermission name="git:git:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="git">
        <tr>
            <td><a href="${ctx}/git/git/form?id=${git.id}">
                <img src="${git.icon}" alt="" srcset="" width="50px" height="30px">
            </a>
            </td>
            <td>
                    ${git.name}

            </td>
            <td>
                    ${fns:getDictLabel(git.price, 'git_price', '')}元
            </td>
            <td>
                    ${fns:getDictLabel(git.ticket, 'git_ticket', '')}票
            </td>
            <td>
                    ${git.remarks}
            </td>
            <shiro:hasPermission name="git:git:edit">
                <td>
                    <a href="${ctx}/git/git/form?id=${git.id}">修改</a>
                    <a href="${ctx}/git/git/delete?id=${git.id}"
                       onclick="return confirmx('确认要删除该礼物吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>