<%@page import="com.activity.model.Activity"%>
<%@page import="com.activity.model.ActivityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>


<%
	ActivityService activityService = new ActivityService();
	List<Activity> activityBackList = activityService.getAll();
	pageContext.setAttribute("activityBackList", activityBackList);
	
	Emp emp = (Emp) session.getAttribute("emp");
	pageContext.setAttribute("emp", emp);
	List<Integer> auth = (List<Integer>) session.getAttribute("auth");
	pageContext.setAttribute("auth", auth);
	
%>
<!DOCTYPE html>
<html lang="">
<head>
    <%@ include file="/back_end/actFiles/actBackCss.file" %>
</head>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script>
	$(document).ready(function(){
		$("tr:even").css("background-color","white");
		$("tr:odd").css("background-color","#D9FFFF");
		
	})
	</script>
	<style type="text/css">
		.actTable{
			margin-top: 50px;
		}
		th{
			text-align: center;
			font-size: 16px;
			background: #8CEA00;
		}
		
</style>
<body>
    <%@ include file="/back_end/actFiles/actBackNav.file" %>
	<%@ include file="/back_end/actFiles/actBackList.file" %>

	    	<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 text-center">
						<table class="table table-hover table-striped table-condensed table-bordered actTable">
						<thead>
							<tr>
								<th>活動相片</th>
								<th>活動編號</th>
								<th>活動名稱</th>
								<th>活動日期</th>
								<th>截止日期</th>
								<th>人數上限</th>
								<th>人數下限</th>
								<th>種類限制</th>
								<th>活動狀態</th>
								<th>審核活動</th>
							</tr>
						</thead>
							<c:forEach var="activityBack" items="${activityBackList}" >
								<form method="post" action="<%=request.getContextPath()%>/activity/activityController">
									<tr>
										<td>${activityBack.actInitImg}</td>
										<td>${activityBack.actNo}</td>
										<td>${activityBack.actName}</td>
										<td>${activityBack.actDate}</td>
										<td>${activityBack.actFDate}</td>
										<td>${activityBack.actULimit}</td>
										<td>${activityBack.actLLimit}</td>
											<c:if test="${activityBack.actKind=='0'}">
												<td>貓</td>
											</c:if>
											<c:if test="${activityBack.actKind=='1'}">
												<td>狗</td>
											</c:if>
											<c:if test="${activityBack.actKind=='2'}">
												<td>其他</td>
											</c:if>
										<td>
											<select name="actStatus">    
											  <option value="0" ${(activityBack.actStatus=='0')?'selected':''} >發起活動</option>
											  <option value="1" ${(activityBack.actStatus=='1')?'selected':''} >審核未通過</option>
											  <option value="2" ${(activityBack.actStatus=='2')?'selected':''} >審核通過</option>
											  <option value="3" ${(activityBack.actStatus=='3')?'selected':''} >餐廳取消活動</option>
											</select>
										</td>
										<td>
											<input type="hidden" name="actNo" value="${activityBack.actNo}">
											<input type="hidden" name="action" value="actManagement">
											<input type="submit" value="修改">
										</td>
									</tr>
								</form>	
							</c:forEach>
								
							
						
						</table>
					</div>
				</div>
			</div> 
  		
	
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>