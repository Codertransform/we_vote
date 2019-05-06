<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>广告管理</title>
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
    <li class="active"><a href="${ctx}/advert/advert/">广告列表</a></li>
    <shiro:hasPermission name="advert:advert:edit">
        <li><a href="${ctx}/advert/advert/form">广告添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="advert" action="${ctx}/advert/advert/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <label>广告标题：</label>
            <form:input path="title" htmlEscape="false" maxlength="64" class="input-medium"/>
        </li>
        <li>
            <label>广告状态：</label>
            <form:radiobuttons path="status" items="${fns:getDictList('advert_online_status')}" itemLabel="label"
                               itemValue="value" htmlEscape="false"/>
        </li>
        <li><label>广告类别：</label>
            <form:select path="advertCategory.id" class="input-xlarge required">
                <form:option value="">广告类别</form:option>
                <form:options items="${advertCategoryList}" itemLabel="name" itemValue="id"
                              htmlEscape="false"/>
            </form:select>
        </li>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>广告标题</th>
        <th>广告图片</th>
        <th>广告类别</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>备注</th>
        <shiro:hasPermission name="advert:advert:edit">
            <th colspan="2">操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="advert">
        <tr>
            <td>
                <a href="${ctx}/advert/advert/form?id=${advert.id}">
                        ${advert.title}
                </a>
            </td>
            <td>
                <img src=" ${advert.image}" alt="" srcset="" width="50px" height="30px">
            </td>
            <td>
                    ${advert.advertCategory.name}
            </td>
            <td>
                <c:if test="${advert.status==1}">
                    上线使用中
                </c:if>
                <c:if test="${advert.status==2}">
                    已下线
                </c:if>
            </td>
            <td>

                <fmt:formatDate value="${advert.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${advert.remarks}
            </td>
            <shiro:hasPermission name="advert:advert:edit">
                <td>

                    <c:if test="${advert.status==2}">
                        <a href="${ctx}/advert/advert/form?id=${advert.id}">修改&nbsp;|&nbsp;</a>
                    </c:if>
                    <c:if test="${advert.status==1}">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;
                    </c:if>
                    <a href="${ctx}/advert/advert/delete?id=${advert.id}"
                       onclick="return confirmx('确认要删除该广告吗？', this.href)">删除&nbsp;|&nbsp;</a>

                    <c:choose>
                        <c:when test="${advert.status==1}">
                            <a href="${ctx}/advert/advert/offLine?id=${advert.id}"
                               onclick="return confirmx('确认要下线该广告吗？', this.href)">

                                <button class="btn btn-small btn-danger">下线</button>
                            </a>
                        </c:when>
                        <c:when test="${advert.status==2}">
                            <a href="${ctx}/advert/advert/onLine?id=${advert.id}"
                               onclick="return confirmx('确认要上线该广告吗？', this.href)">
                                <button class="btn btn-small btn-success">上线</button>
                            </a>
                        </c:when>
                    </c:choose>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class=" pagination">${page}</div>
</body>
</html>