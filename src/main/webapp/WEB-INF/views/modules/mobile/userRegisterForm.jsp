<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="style.jsp"/>
</head>
<body>
<jsp:include page="head.jsp"/>

<div class="container">
    <div class="row clearfix"></div>

    <div class="row clearfix">
        <div class="col-md-offset-3 col-md-6 column">
            <h3 class="text-center" style="height: 100px">

            </h3>
            <h3 class="text-center">
               用户注册
            </h3>
            <form role="form" action="/mobile/mobileUser/doRegister">
                <input type="hidden" value="${activity.id}" name="activityId">
                <div class="form-group">
                    <label>姓名</label><input class="form-control" type="text" name="username"/>
                </div>
                <div class="form-group">
                    <label>电话</label><input class="form-control" type="text" name="phone"/>
                </div>
                <div class="form-group">
                    <label>邮箱</label><input class="form-control" type="text" name="email"/>
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
