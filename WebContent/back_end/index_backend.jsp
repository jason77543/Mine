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


				<h5 class="page-header text-right">�ثe��m:��ݭ���</h5>


				<div
					class="panel panel-default col-sm-offset-3 col-sm-6 text-center">
					<div class="panel-heading">
						<h3 class="panel-title">�ݳB�z�ƶ�</h3>
					</div>

					<ul class="list-group">
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5
							���ݼf�֭q�� <span class="label label-info pull-right">5</span>
						</li>
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1
							���ݼf���\�U <span class="label label-info pull-right">1</span>
						</li>
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2
							���ݳB�z�ӶD <span class="label label-info pull-right">2</span>
						</li>
						<li class="list-group-item">0 ���ݳB�z���|</li>
						<li class="list-group-item">0 ���ݼf�֬���</li>

					</ul>







				</div>




			</div>

			<script src="https://code.jquery.com/jquery.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>