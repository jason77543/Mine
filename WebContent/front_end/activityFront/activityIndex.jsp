<%@page import="com.activity.model.Activity"%>
<%@page import="com.activity.model.ActivityService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	
	ActivityService activityService = new ActivityService();
	List<Activity> activityFrontList = activityService.getAllByStatus(2);
	request.setAttribute("activityFrontList", activityFrontList);
	
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
								<h3 class="panel-title">活動名稱:${activityFront.actName}</h3>
							</div>
<!-- 							<div class="col-xs-12 col-sm-6 text-right "> -->
								
<!-- 									<footer> -->
<%-- 										<c:if test="${activity.actStatus=='0'}"><font color="red">活動發起待審核</font></c:if> --%>
<%-- 										<c:if test="${activity.actStatus=='1'}"><font color="red">審核未通過</font></c:if> --%>
<%-- 										<c:if test="${activity.actStatus=='2'}"><font color="green">審核通過</font></c:if>	 --%>
<%-- 										<c:if test="${activity.actStatus=='3'}"><font color="red">餐廳取消活動</font></c:if> --%>
<!-- 									</footer> -->
								
<!-- 							</div> -->
						</div>
					
		       </div>
		       
			       <div class="col-xs-12 col-sm-4">
						<img src="<%=request.getContextPath() %>/activity/DBGifReader5?actNo=${activityFront.actNo}" class="img-responsive" >
					</div>
				
					
					
					<div class="col-xs-12 col-sm-8 actarea">
						<textarea class="overflow form-control" rows="5" cols="40" wrap="hard" readonly>${activityFront.actContent}</textarea>
						
					</div>
					
					
					
				
			<form method="post" action="<%=request.getContextPath()%>/activity/actDetialController" >
			
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
														
															<option value="${activityFront.actKind}">貓</option>
															<option value="${activityFront.actKind}">狗</option>
															<option value="${activityFront.actKind}">其他</option>
														
													</select>	
												</div>
											</div>
												
											
											
											<input type="hidden" name="action" value="joinActivity">
								</div>		
							</div>

						</div>
					</div>
								
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
				<button type="submit" class="btn btn-primary">參加活動</button>
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