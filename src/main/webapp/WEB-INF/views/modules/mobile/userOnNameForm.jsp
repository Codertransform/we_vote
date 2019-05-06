<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${activity.title}</title>
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
            <h3 class="text-center">
                我要报名
            </h3>
            <form role="form" action="/mobile/mobileUser/doOnName" enctype="multipart/form-data">
                <input type="hidden" value="${activity.id}" name="activityId">
                <input type="hidden" value="${activity.office.id}" name="officeId">
                <div class="form-group">
                    <label>图像</label><input class="form-control" type="file" name="images" id="nameImage"/>
                </div>
                <div class="form-group">
                    <label>个性宣言</label><input class="form-control" type="text" name="remarks"/>
                </div>
                <button type="submit" class="btn btn-default">报名</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
