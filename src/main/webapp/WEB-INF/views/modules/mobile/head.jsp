<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1"><span
                class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                class="icon-bar"></span><span class="icon-bar"></span></button>
        <a class="navbar-brand" href="#">${activity.title}</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li class="active">
                <a href="/mobile/activity/activity/index?activityId=${activity.id}">活动首页</a>
            </li>
            <li class="active">
                <a href="/mobile/activity/activity/index?activityId=${activity.id}">活动奖品</a>
            </li>
            <li class="active">
                <a href="/mobile/mobileUser/onName?activityId=${activity.id}">我要报名</a>
            </li>
        </ul>

        <form class="navbar-form navbar-right" role="search" action="#">
            <div class="form-group">
                <input class="form-control" type="text" placeholder="请输入编号或姓名查找"/>
            </div>
            <button type="submit" class="btn btn-default">查找</button>
        </form>

        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">我的<strong
                        class="caret"></strong></a>
                <ul class="dropdown-menu">
                    <li class="divider"></li>
                    <li>
                        <a href="/mobile/mobileUser/register?activityId=${activity.id}">注册</a>
                    </li>

                    <li class="divider"></li>
                    <c:if test="${empty sessionScope.mobileUser}">
                        <li>
                            <a href="/mobile/mobileUser/login?activityId=${activity.id}">登录</a>
                        </li>
                    </c:if>
                    <li class="divider"></li>
                    <li>
                        <a href="#">我的作品</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">我的礼物</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

</nav>