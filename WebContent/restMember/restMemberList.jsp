<%@page import="com.restMember.model.RestMemberService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.restaurant.model.*"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>

<%
    RestaurantService restaurantSvc = new RestaurantService();
	Restaurant restaurant = new Restaurant();
    List<Restaurant> list = restaurantSvc.getAll();
    session.setAttribute("list",list);
   
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>餐廳一覽表</title>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20' >
		<td><h1>友善寵物餐廳一覽表</h1>
		          <a href="restMemberLogin.jsp">回登入頁面</a></td></tr></table>



<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		
		<th>餐廳名稱</th>
		<th>餐廳地址</th>
		<th>餐廳電話</th>
		<th>餐廳介紹</th>
		<th>餐廳種類</th>
		
		
		
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="restaurant" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			
			<td>${restaurant.restName}</td>
			<td>${restaurant.restAdd}</td>
			<td>${restaurant.restPhone}</td>
			<td>${restaurant.restIntro}</td>
			<td>
		
					<c:if test="${restaurant.restKind=='0'}">
						<input type="hidden" name="restKind" class="form-control" value="0" readonly>狗餐廳
					</c:if>
					<c:if test="${restaurant.restKind=='1'}">
						<input type="hidden" name="restKind" class="form-control" value="1" readonly>貓餐廳
					</c:if>
					<c:if test="${restaurant.restKind=='2'}">
						<input type="hidden" name="restKind" class="form-control" value="2" readonly>其他餐廳
					</c:if>
								
			</td>
			<td>
			  <FORM METHOD="post" ACTION="restMemberRegister.jsp">
			     <input type="submit" value="註冊">
			     <input type="hidden" name="restNo" value="${restaurant.restNo}">
			     <input type="hidden" name="restName" value="${restaurant.restName}">
			     <input type="hidden" name="restAdd" value="${restaurant.restAdd}">
			     <input type="hidden" name="restPhone" value="${restaurant.restPhone}">
			     <input type="hidden" name="restIntro" value="${restaurant.restIntro}">
			     <input type="hidden" name="restKind" value="${restaurant.restKind}">
			 </FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
<br>
	
		<div align="center" >
			沒有你的寵物餐廳嗎?? <a href="newRestaurant.jsp"><input type="button" value="新增餐廳"></a>
		</div>
		
</body>
</html>
