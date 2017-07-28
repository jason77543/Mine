<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<!DOCTYPE html>
<html lang="">

<head>
    
    <!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>

<body>
    <%@ include file="restMemberNavBar.file" %>


    <div class="container-fluid">
        <div class="row"> 
        	<%@ include file="restMemberList.file" %>
        <div class="col-xs-12 col-sm-8">       
   
    <div class="panel-group col-sm-offset-2 col-sm-8">
    
    
		<h5 class=" page-header text-right">目前位置:餐廳會員首頁</h5>
       <div class="panel-heading">
         <h3 class="panel-title text-center">發起中的活動</h3>
       </div>


	 <div class="panel panel-default">
       <div class="panel-heading">
         <h3 class="panel-title">小型犬溫馨聚會</h3>
       </div>
       <div class="panel-body">
         <button class="btn btn-info"><a href="#" >檢視活動狀態</a></button>
       </div>
     </div>

         <div class="panel panel-default">
       <div class="panel-heading">
         <h3 class="panel-title">大型犬溫馨聚會</h3>
       </div>
       <div class="panel-body">
          <button class="btn btn-info"><a href="#" >檢視活動狀態</a></button>
       </div>
     </div>

     <div class="panel panel-default">
       <div class="panel-heading">
         <h3 class="panel-title">中型犬溫馨聚會</h3>
       </div>
       <div class="panel-body">
         <button class="btn btn-info"><a href="#" >檢視活動狀態</a></button>
       </div>
       </div>
     </div>





        </div>
        </div>




    </div>
  
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>