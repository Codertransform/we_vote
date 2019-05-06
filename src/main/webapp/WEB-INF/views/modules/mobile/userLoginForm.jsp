<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="style.jsp"></jsp:include>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>

<div class="container">
    <div class="row clearfix"></div>

    <div class="row clearfix">
        <div class="col-md-offset-3 col-md-6 column">
            <h3 class="text-center" style="height: 100px">

            </h3>
            <c:if test="${message!=null}">
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-6 column">
                            <div class="alert alert-success alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <h4>
                                    <strong>${message}</strong>
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <h3 class="text-center">
                用户登录
            </h3>

            <form role="form" action="/mobile/mobileUser/doLogin">
                <input type="hidden" value="${activity.id}" name="activityId">
                <div class="form-group">
                    <label>姓名</label><input class="form-control" type="text" name="username"/>
                </div>
                <div class="form-group">
                    <label>密码</label><input class="form-control" type="password" name="password"/>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
