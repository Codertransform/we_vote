<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${activity.title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <jsp:include page="style.jsp"></jsp:include>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="carousel slide" id="carousel-663248">
                <ol class="carousel-indicators">
                    <li data-slide-to="0" data-target="#carousel-663248">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-663248" class="active">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-663248">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="item">
                        <img alt=""
                             src="${advert1.image}" style="width: 100%" height="300px"/>
                        <div class="carousel-caption">
                            <h4>
                                First Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item active">
                        <img alt=""
                             src="${advert2.image}"style="width: 100%" height="300px"/>
                        <div class="carousel-caption">
                            <h4>
                                Second Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt=""
                             src="${advert3.image}" style="width: 100%" height="100px"/>
                        <div class="carousel-caption">
                            <h4>
                                Third Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel-663248" data-slide="prev"><span
                        class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control"
                                                                                href="#carousel-663248"
                                                                                data-slide="next"><span
                    class="glyphicon glyphicon-chevron-right"></span></a>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img alt="300x200"
                             src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/people/default.jpg"/>
                        <div class="caption">
                            <h3>
                                Thumbnail label
                            </h3>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img alt="300x200"
                             src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/city/default.jpg"/>
                        <div class="caption">
                            <h3>
                                Thumbnail label
                            </h3>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img alt="300x200"
                             src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/600/200/sports/default.jpg"/>
                        <div class="caption">
                            <h3>
                                Thumbnail label
                            </h3>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                            <p>
                                <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>

</body>

</html>