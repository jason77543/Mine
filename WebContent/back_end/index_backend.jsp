<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>


<%
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

<body>
	<%@ include file="/back_end/actFiles/actBackNav.file" %>


	<%@ include file="/back_end/actFiles/actBackList.file" %>



			<div class="col-xs-12 col-sm-8">


				<h5 class="page-header text-right">目前位置:後端首頁</h5>


				<div
					class="panel panel-default col-sm-offset-3 col-sm-6 text-center">
					<div class="panel-heading">
						<h3 class="panel-title">待處理事項</h3>
					</div>

					<ul class="list-group">
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5
							筆待審核訂單 <span class="label label-info pull-right">5</span>
						</li>
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1
							筆待審核餐廳 <span class="label label-info pull-right">1</span>
						</li>
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2
							筆待處理申訴 <span class="label label-info pull-right">2</span>
						</li>
						<li class="list-group-item">0 筆待處理檢舉</li>
						<li class="list-group-item">0 筆待審核活動</li>

					</ul>







				</div>




			</div>

			<script src="https://code.jquery.com/jquery.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>