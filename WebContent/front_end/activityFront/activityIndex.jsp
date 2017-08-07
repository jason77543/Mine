<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<!DOCTYPE html>
<html lang="">

<head>
    <%@ include file="/front_end/files/actFrontCss.file" %>
</head>

<body>
    <%@ include file="/front_end/files/actFrontNav.file" %>
    <div class="container-fluid">
        <div class="row">
            <%@ include file="/front_end/files/actFrontList.file" %>
            
            <div class="col-xs-12 col-sm-8 ">

            <div class="row">
	
<div class="col-sm-10 col-sm-offset-1">
<div id="carousel-id" class="carousel slide" data-ride="carousel">
    <!-- 幻燈片小圓點區 -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-id" data-slide-to="0" class=""></li>
        <li data-target="#carousel-id" data-slide-to="1" class=""></li>
        <li data-target="#carousel-id" data-slide-to="2" class="active"></li>
    </ol>
    <!-- 幻燈片主圖區 -->
    <div class="carousel-inner">
        <div class="item">
            <img src="https://api.fnkr.net/testimg/2800x700/aaaaaa" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>標題</h1>
                    <p>內文</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="https://api.fnkr.net/testimg/2800x700/aaaaaa" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>標題</h1>
                    <p>內文？</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">更多</a></p>
                </div>
            </div>
        </div>
        <div class="item active">
            <img src="https://api.fnkr.net/testimg/2800x700/aaaaaa" alt="">
            <div class="container">
                <div class="carousel-caption">
                    <h1>標題</h1>
                    <p>內文</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">詳細內容</a></p>
                </div>
            </div>
        </div>
    </div>
    <!-- 上下頁控制區 -->
    <a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div>

</div>
</div>




                <h5 class="page-header text-right">目前位置:活動首頁</h5>
                <div class="row">
                    <div class="panel panel-default col-sm-8 col-sm-offset-2 top-margin-sm">
                        <div class="col-xs-12 col-sm-4"><img src="https://api.fnkr.net/testimg/200x200/00CED1/FFF/?text=img+placeholder"></div>
                        <div class="col-xs-12 col-sm-8">
                            <div class="panel-heading">
                                <h3 class="panel-title">活動標題</h3>
                            </div>
                            <div class="panel-body">
                                內容文字
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-default col-sm-8 col-sm-offset-2 top-margin-sm">
                        <div class="col-xs-12 col-sm-4"><img src="https://api.fnkr.net/testimg/200x200/00CED1/FFF/?text=img+placeholder"></div>
                        <div class="col-xs-12 col-sm-8">
                            <div class="panel-heading">
                                <h3 class="panel-title">活動標題</h3>
                            </div>
                            <div class="panel-body">
                                內容文字
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="panel panel-default col-sm-8 col-sm-offset-2 top-margin-sm">
                        <div class="col-xs-12 col-sm-4"><img src="https://api.fnkr.net/testimg/200x200/00CED1/FFF/?text=img+placeholder"></div>
                        <div class="col-xs-12 col-sm-8">
                            <div class="panel-heading">
                                <h3 class="panel-title">活動標題</h3>
                            </div>
                            <div class="panel-body">
                                內容文字
                            </div>
                        </div>
                    </div>
                </div>

<div class="text-center">

                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li class="active"><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
                <br>
<ul class="pager">
  <li><a href="#">前一頁</a></li>
  <li><a href="#">下一頁</a></li>
</ul>
            
</div>

<div class="postion-left-group-b">
        <footer>
            <div class="row">
                <div class="col-sm-12">
                    <div class="col-sm-3">
                        <p>Copyright 寵物You&amp;Me 2017</p>
                    </div>
                    <div class="col-sm-3">
                        <p>關於我們</p>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <a href="#">
        <div class="" id="fixedbutton-talk">
            <button class="button btn-lg btn-primary active">
                交易聊天室
            </button>
        </div>
    </a>
</div>
            </div>
            <script src="https://code.jquery.com/jquery.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>