<%@page import="com.restaurant.model.Restaurant"%>
<%@page import="com.restaurant.model.RestaurantService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.restaurant.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
    RestaurantService restSvc = new RestaurantService();
    List<Restaurant> list = restSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<html>
<head>
<title>�Ҧ����u��� - listAllEmp.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�����m�߱ĥ� EL ���g�k����:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�Ҧ����u��� - ListAllEmp.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
		</td>
	</tr>
</table>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>�\�U�s��</th>
		<th>�\�U�W��</th>
		<th>�\�U�a�}</th>
		<th>�\�U�q��</th>
		<th>�\�U����</th>
		<th>�\�U����</th>
		<th>�\�U�f�֪��A</th>
		<th>�\�U�g��</th>
		<th>�\�U�n��</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="rest" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			<td>${rest.restNo}</td>
			<td>${rest.restName}</td>
			<td>${rest.restAdd}</td>
			<td>${rest.restPhone}</td>
			<td>${rest.restIntro}</td>
			<td>${rest.restKind}</td>
			<td>${rest.restReviewStatus}</td>
			<td>${rest.restLongtitude}</td>
			<td>${rest.restLatitude}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="restNo" value="${rest.restNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="restNo" value="${rest.restNo}">
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
