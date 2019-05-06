<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>奖品管理</title>
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
    <li class="active"><a href="${ctx}/award/award/">奖品列表</a></li>
    <shiro:hasPermission name="award:award:edit">
        <li><a href="${ctx}/award/award/form">奖品添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="award" action="${ctx}/award/award/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>奖品名称：</label>
            <form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
        </li>
        <li><label>奖品类别：</label>
            <form:select path="awardCategory.id" class="input-xlarge required">
                <form:option value="">奖品类别</form:option>
                <form:options items="${awardCategoryList}" itemLabel="name" itemValue="id"
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
        <th>奖品名称</th>
        <th>奖品图片</th>
        <th>奖项</th>
        <th>奖项数量</th>
        <th>奖品类别</th>
        <th>奖品备注</th>
        <shiro:hasPermission name="award:award:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="award">
        <tr>
            <td><a href="${ctx}/award/award/form?id=${award.id}">
                    ${award.name}
            </a></td>
            <td>

                <img src="${award.image}" alt="" srcset="" width="50px" height="30px">
            </td>
            <td>

                    ${fns:getDictLabel(award.item, 'award_status', '')}
            </td>
            <td>
                    ${fns:getDictLabel(award.itemCount, 'award_status_count', '')}
            </td>
            <td>
                    ${award.awardCategory.name}
            </td>
            <td>
                    ${award.remarks}
            </td>
            <shiro:hasPermission name="award:award:edit">
                <td>
                    <a href="${ctx}/award/award/form?id=${award.id}">修改</a>
                    <a href="${ctx}/award/award/delete?id=${award.id}"
                       onclick="return confirmx('确认要删除该奖品吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>