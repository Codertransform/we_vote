<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>作品管理</title>
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
    <li class="active">
        <a href="${ctx}/production/production/">作品列表</a>
    </li>
</ul>
<form:form id="searchForm" modelAttribute="production" action="${ctx}/production/production/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">


        <li><label>礼物类别：</label>
            <form:select path="office.id" class="input-xlarge required">
                <form:option value="">机构</form:option>
                <form:options items="${officeList}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </li>


        <li><label>奖品类别：</label>
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
        <th>参赛用户</th>
        <th>参赛图片</th>
        <th>参赛宣言</th>
        <th>票数</th>
        <th>参赛日期</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="production">
        <tr>
            <td>
                    ${production.mobileUser.username}
            </td>
            <td>
                    ${production.image}
            </td>
            <td>
                    ${production.remarks}
            </td>
            <td>
                    ${production.ticket}
            </td>
            <td>
                <fmt:formatDate value="${production.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>