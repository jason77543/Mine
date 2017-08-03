<%@page import="com.restMember.model.RestMember"%>
<%@page import="java.util.List"%>
<%@page import="com.activity.model.ActivityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ page import="com.activity.model.Activity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	ActivityService activityService = new ActivityService();
	RestMember restMember = (RestMember)session.getAttribute("restMember");
	Activity activity = (Activity)request.getAttribute("activity");
	List<Activity> activitiyList = activityService.getAllById(restMember.getRestMemId());
	
	session.setAttribute("activitiyList", activitiyList);
%>
<!DOCTYPE html>
<html lang="">

<head>
    
    <!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		
	
</head>

<body>

    <%@ include file="/files/restMemberNavBar.file" %>
	<%@ include file="/files/overflow.file" %>

    <div class="container-fluid">
        <div class="row"> 
        	<%@ include file="/files/restMemberList.file" %>
        <div class="col-xs-12 col-sm-8">       
   
    <div class="panel-group col-sm-offset-2 col-sm-8">
    
    
		<h5 class=" page-header text-right">目前位置:餐廳會員首頁</h5>
		
       <div class="panel-heading">
         <h3 class="panel-title text-center">所有活動</h3>
       </div>
		
		
			<c:forEach var="activity" items="${activitiyList}">
			 <div class="panel panel-default">
		       <div class="panel-heading">
		         <h3 class="panel-title">活動名稱:${activity.actName}</h3>
		       </div>
		       
			       <div class="col-xs-12 col-sm-4">
						<img src="<%=request.getContextPath() %>/activity/DBGifReader5?actNo=${activity.actNo}" class="img-responsive" >
					</div>
				
					
					
					<div class="col-xs-12 col-sm-8 actarea">
						<p class="overflow">${activity.actContent}</p>
						
					</div>
					
					
					
				
		       <div class="row">
					<div class="col-xs-12 col-sm-12">
						<div class="panel-body text-right" >
		         			<button class="btn btn-info"><a href="#" >檢視活動狀態</a></button>
		       			</div>
					</div>	
				</div>
		     </div>
			</c:forEach>
        
       </div>
     </div>

	



        </div>
        </div>




    
  
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>

</html>