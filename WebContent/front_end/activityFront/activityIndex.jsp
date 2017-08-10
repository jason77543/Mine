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
	List<Activity> activityFrontList = activityService.getAllByStatus(2);
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
	

		
	

		<c:forEach var="activityFront" items="${activityFrontList}">
			 <div class="panel panel-default">
		       <div class="panel-heading">
		       	
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<h3 class="panel-title">
								<% Activity act = (Activity) pageContext.getAttribute("activityFront"); %>   
								<%
								restMember = restMemberService.getOneRestMember(act.getRestMemId());
								restaurant = restaurantService.getOneRest(restMember.getRestNo());
								
								%>
								
								活動餐廳:<%=restaurant.getRestName() %>
								</h3>
							</div>

						</div>
					
		       </div>
		       
			       <div class="col-xs-12 col-sm-4">
						<img src="<%=request.getContextPath() %>/activity/DBGifReader5?actNo=${activityFront.actNo}" class="img-responsive" >
					</div>
				
					
					
					<div class="col-xs-12 col-sm-8 actarea">
						<textarea class="overflow form-control" rows="5" cols="40" wrap="hard" readonly>${activityFront.actContent}</textarea>
						
					</div>
					
					
					
				
			<form method="post" action="<%=request.getContextPath()%>/actDetial/actDetialController" >
			
		       <div class="row">
					<div class="col-xs-12 col-sm-12">
						<div class="panel-body text-right" >
		         			<a href='#${activityFront.actNo}' data-toggle="modal" class="btn btn-primary">活動詳情</a>
								<div class="modal fade" id="${activityFront.actNo }">
									<div class="modal-dialog">
										<div class="modal-content">
											
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title text-center">活動詳情</h4>
					</div>
			
				<div class="modal-body">
					<div class="container">
						<div class="row">
				
							<div class="col-sm-5">
									
				
								<div class="form-horizontal">
								
									
											
											
									
											<div class="form-group">
												<div class="col-xs-12 col-sm-4">
													<img src="<%=request.getContextPath()%>/activity/DBGifReader5?actNo=${activityFront.actNo}" 
													class="img-responsive" >
													
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													活動名稱
												</label>
												<div class="col-sm-9">
													<input type="text" name="actName" class="form-control" value="${activityFront.actName }" readonly>	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													活動內容
												</label>
												<div class="col-sm-9">
													<textarea name="actContent" rows="3" cols="47" wrap="hard" readonly>${activityFront.actContent }</textarea>	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													活動日期
												</label>
												<div class="col-sm-9">
													<input type="date" name="actDate" class="form-control" value="${activityFront.actDate }" readonly>	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													報名截止日期
												</label>
												<div class="col-sm-9">
													<input type="date" name="actFDate" class="form-control" value="${activityFront.actFDate}" readonly>	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													人數上限
												</label>
												<div class="col-sm-9">
													<input type="text" name="actULimit" class="form-control" value="${activityFront.actULimit }" readonly>	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													人數下限
												</label>
												<div class="col-sm-9">
													<input type="text" name="actLLimit" class="form-control" value="${activityFront.actLLimit }" readonly>	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													種類限制
												</label>
												<div class="col-sm-9">
													<select id="testModal" name="actKind" class="form-control" disabled="true">
														
															<option value="0" ${(activityFront.actKind=="0")?'selected':''}>貓</option>
															<option value="1" ${(activityFront.actKind=="1")?'selected':''}>狗</option>
															<option value="2" ${(activityFront.actKind=="2")?'selected':''}>其他</option>
														
													</select>	
												</div>
											</div>
												
											
											
											
								</div>		
							</div>

						</div>
					</div>
								
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
				
				
				
				<% 
				ActDetialService actDetialService=new ActDetialService();
				Map<Integer,Integer> map = actDetialService.getOneActDetialMap(member.getMemNo()); 
				boolean showAttend=true;
					if(map!=null){
						try{
							if(map.get(act.getActNo())==null){
								showAttend=true;
							}
							if(map.get(act.getActNo())==0){
								showAttend=false;
							}
						}catch (Exception e){
							showAttend=true;
						}
					}		
				%>
				<% if(showAttend){  %>
<%-- 				<c:if test="${actDetial.memActStatus==''}"> --%>
					<input type="hidden" name="memActStatus" value="0">
					<input type="hidden" name="memNo" value="${member.memNo}">
					<input type="hidden" name="actNo" value="${activityFront.actNo}">
					<input type="hidden" name="action" value="joinActivity">
					<button type="submit" class="btn btn-primary">參加活動</button>
<%-- 				</c:if> --%>
				<% } %>
				
					<% if(!showAttend){  %>
<%-- 				<c:if test="${actDetial.memActStatus=='0'}"> --%>
					<input type="hidden" name="memNo" value="${member.memNo}">
					<input type="hidden" name="actNo" value="${activityFront.actNo}">
					<input type="hidden" name="action" value="cancelActivity">
					<button type="submit" class="btn btn-primary">取消活動</button>
<%-- 				</c:if> --%>
				<% } %>
			</div>
												
					</div>
				</div>
			</div>
					         			
		  </div>
		</div>	
	</div>
				
				
				
			</form>	
			
			
				
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