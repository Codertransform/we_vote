<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>

    <title>Title</title>
    <script src="/base/meeting/orderInfo/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/base/meeting/orderInfo/bootstrap/js/jquery-1.12.4.min.js"></script>
    <link href="/base/meeting/orderInfo/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="/base/meeting/orderInfo/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>

<body>

<%--详情模态框展示 start--%>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


<%--详情模态框展示 end--%>

<form method="post" class="form-horizontal">
    <div class="form-group">
        <div class="col-md-4">
            <div class="input-group">
                <div class="input-group-addon bg-white dw-110">会议主题</div>
                <input type="text" htmlEscape="false" class="form-control input-large required"/>
            </div>
        </div>
        <div class="col-md-4 ">
            <div class="input-group ">
                <div class="input-group-addon bg-white dw-110">开始时间</div>
                <input type="text" htmlEscape="false" class="form-control input-large required"/>
            </div>
        </div>
        <div class="col-md-4 ">
            <div class="input-group ">
                <div class="input-group-addon bg-white dw-110">结束时间</div>
                <input type="text" htmlEscape="false" class="form-control input-large required"/>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-4">
            <div class="input-group">
                <div class="input-group-addon bg-white dw-110">会议名称</div>
                <select style="width:100%;" class="required">
                    <option value="" label=""/>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <div class="input-group-addon  dw-110">会议设备</div>
                <select style="width:100%;" class="required">
                    <option value="" label=""/>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <button class="btn btn-primary btn btn-lg">查询预定信息</button>
            </div>
        </div>
    </div>
</form>


<table class="table table-bordered table-hover table-condensed">
    <thead>
    <tr>
        <th>
            编号
        </th>
        <th>
            会议室
        </th>
        <th>
            预订人
        </th>
        <th>
            预定日期
        </th>
        <th>
            开始时间
        </th>
        <th>
            结束时间
        </th>
        <th>
            会议主题
        </th>
        <th>
            会议人数
        </th>
        <th>
            操作
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="order">
        <tr>
            <td>
                    ${order.id}
            </td>
            <td>
                    ${order.roomName}
            </td>
            <td>
                    ${order.userName}
            </td>
            <td>
                <fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd"/>

            </td>
            <td>
                <fmt:formatDate value="${order.orderStartTime}" pattern="HH点mm分"/>
            </td>
            <td>
                <fmt:formatDate value="${order.orderEndTime}" pattern="HH点mm分"/>
            </td>
            <td>
                    ${order.orderTopic}
            </td>
            <td>
                    ${order.orderPeople}
            </td>
            <td>
                <button class="btn btn-default" id="orderInfo">详情</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<div class="form-group form-inline" >
        <div class="col-md-6 ">
            <button class="btn btn-primary" id="exportCurrent">
                导出本页数据
            </button>
            <button class="btn btn-primary" id="exportAll">
                导出全部数据
            </button>
        </div>

        <div class="col-md-6 ">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${page.hasPreviousPage == false}">
                        <li class="disabled">
                            <a href="#">上一页</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/order/listPage?pn=${page.pageNum-1}">上一页</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="item" items="${page.navigatepageNums}">
                    <c:choose>
                        <c:when test="${page.pageNum == item }">
                            <li class="active">
                                <a href="#">${item}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="/order/listPage?pn=${item}">${item}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${page.hasNextPage == false}">
                        <li class="disabled">
                            <a href="#">下一页</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/order/listPage?pn=${page.pageNum+1}">上一页</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
</div>
</body>

<script>

    $("#orderInfo").click(function () {

        $("#myModal").modal({
            backdrop: "static"
        });
    });
    $("#exportCurrent").click(function () {
        var pn =
        ${page.pageNum}
    });
</script>
</html>
