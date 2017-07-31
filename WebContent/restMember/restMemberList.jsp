<%@page import="com.restMember.model.RestMemberService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.restaurant.model.*"%>
<%-- �����ĥ� JSTL �P EL ���� --%>

<%
    RestaurantService restaurantSvc = new RestaurantService();
	Restaurant restaurant = new Restaurant();
    List<Restaurant> list = restaurantSvc.getAll();
    session.setAttribute("list",list);  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�\�U�@����</title>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20' >
		<td><h1>�͵��d���\�U�@����</h1>
		          <a href="restMemberLogin.jsp">�^�n�J����</a></td></tr></table>



<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		
		<th>�\�U�W��</th>
		<th>�\�U�a�}</th>
		<th>�\�U�q��</th>
		<th>�\�U����</th>
		<th>�\�U����</th>
		<th>�\�U�f�֪��A</th>
		
		
	</tr>
	<%@ include file="/files/page1.file" %> 
	<c:forEach var="restaurant" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			
			<td>${restaurant.restName}</td>
			<td>${restaurant.restAdd}</td>
			<td>${restaurant.restPhone}</td>
			<td>${restaurant.restIntro}</td>
			<td>
		
					<c:if test="${restaurant.restKind=='0'}">
						<input type="hidden" name="restKind" class="form-control" value="0" >���\�U
					</c:if>
					<c:if test="${restaurant.restKind=='1'}">
						<input type="hidden" name="restKind" class="form-control" value="1" >���\�U
					</c:if>
					<c:if test="${restaurant.restKind=='2'}">
						<input type="hidden" name="restKind" class="form-control" value="2" >��L�\�U
					</c:if>
								
			</td>
			<td>
					<c:if test="${restaurant.restReviewStatus=='0'}">
						<input type="hidden" name="restReviewStatus" class="form-control" value="0" >�w�f�ֳq�L
					</c:if>
					<c:if test="${restaurant.restReviewStatus=='1'}">
						<input type="hidden" name="restReviewStatus" class="form-control" value="1" >�f�֥��q�L
					</c:if>
					<c:if test="${restaurant.restReviewStatus=='2'}">
						<input type="hidden" name="restReviewStatus" class="form-control" value="2" >���f��
					</c:if>
			</td>
			<td>
			<c:if test="${restaurant.restReviewStatus=='0'}">
				<FORM METHOD="post" ACTION="<%=request.getContextPath() %>/restMember/restMemberRegister.jsp">
			     <input type="submit" value="���U">
			     <input type="hidden" name="restNo" value="${restaurant.restNo}">
			     <input type="hidden" name="restName" value="${restaurant.restName}">
			     <input type="hidden" name="restAdd" value="${restaurant.restAdd}">
			     <input type="hidden" name="restPhone" value="${restaurant.restPhone}">
			     <input type="hidden" name="restIntro" value="${restaurant.restIntro}">
			     <input type="hidden" name="restKind" value="${restaurant.restKind}">
			     <input type="hidden" name="restReviewStatus" value="${restaurant.restReviewStatus}">
			     <input type="hidden" name="restLongtitude" class="form-control" value="<%=restaurant.getRestLongtitude() %>" >
				 <input type="hidden" name="restLatitude" class="form-control" value="<%=restaurant.getRestLatitude() %>" >
				 <input type="hidden" name="restLocate" class="form-control" value="<%=restaurant.getRestLocate() %>" >
			 </FORM>
			</c:if>
			
			<c:if test="${restaurant.restReviewStatus=='1'}">
				<input type="submit" value="���U" disabled>
			</c:if>
			<c:if test="${restaurant.restReviewStatus=='2'}">
				<input type="submit" value="���U" disabled>
			</c:if>
			
			  
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="/files/page2.file" %>
<br>
	
		<div align="center" >
			�S���A���d���\�U��?? <a href="<%=request.getContextPath() %>/restaurant/newRestaurant.jsp"><input type="button" value="�s�W�\�U"></a>
		</div>
		
</body>
</html>
