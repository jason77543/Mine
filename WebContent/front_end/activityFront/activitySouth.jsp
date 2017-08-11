<%@page import="com.actDetial.model.ActDetialService"%>
<%@page import="com.actDetial.model.ActDetial"%>
<%@page import="com.member.model.Member"%>
<%@page import="com.restaurant.model.RestaurantService"%>
<%@page import="com.restaurant.model.Restaurant"%>
<%@page import="com.restMember.model.RestMemberService"%>
<%@page import="com.restMember.model.RestMember"%>
<%@page import="com.activity.model.Activity"%>
<%@page import="com.activity.model.ActivityService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ActivityService activityService = new ActivityService();
	List<Activity> activityFrontList = activityService.getAllSouth();
	request.setAttribute("activityFrontList", activityFrontList);

	RestMemberService restMemberService = new RestMemberService();
	RestaurantService restaurantService = new RestaurantService();
	
	RestMember restMember = null;
	Restaurant restaurant = null;
	
	
	
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html lang="">

<head>
    <%@ include file="/front_end/files/actFrontCss.file" %>
</head>

<body>
	<%@ include file="/front_end/files/overflow.file" %>
    <%@ include file="/front_end/files/actFrontNav.file" %>
    <div class="container-fluid">
        <div class="row">
            <%@ include file="/front_end/files/actFrontList.file" %>
            
            <div class="col-xs-12 col-sm-8 ">

            <div class="panel-group col-sm-offset-2 col-sm-8">
	

			<%@ include file="/front_end/files/activityAll.file" %>
	

		
			</div>


		</div>
    
	</div>
</div>
            
            <script src="https://code.jquery.com/jquery.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>

</html>