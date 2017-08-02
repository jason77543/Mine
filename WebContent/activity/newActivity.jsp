<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@page import="com.activity.model.Activity"%>
<%@page import="com.restaurant.model.Restaurant"%>
<%@page import="com.restMember.model.RestMember"%>
<%@page import="com.restMember.model.RestMemberService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	RestMember restMember = (RestMember)session.getAttribute("restMember");
	Activity activity = (Activity)request.getAttribute("activity");
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
	String actDateMin  = simpleDateFormat.format(new Date());
	
%>


<%-- �����ĥ� JSTL �P EL ���� --%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Title Page</title>
<style type="text/css">
.aa {
	margin-top: 20px;
}




</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
			<![endif]-->

</head>
<body>
	<%@ include file="/files/restMemberNavBar.file" %>
	<%@ include file="/files/activity.file" %>
	
	<div class="container-fluid">
        <div class="row"> 
        	<%@ include file="/files/restMemberList.file" %>
        <div class="col-xs-12 col-sm-8">       
   
    <div class="panel-group col-sm-offset-2 col-sm-8">
    
    
	<h5 class=" page-header text-right">�ثe��m:�s�W�\�U����</h5>
	
		<h1 class="text-center">�s�W�\�U����</h1>

				<div class="form-horizontal">
				
					<form method="post" action="<%=request.getContextPath()%>/activity/activityController" enctype="multipart/form-data">
							<c:if test="${not empty activityError}">
								${activityError}
							</c:if>
							
							<input type="hidden" name="restMemId" value="${restMember.restMemId}">
							<input type="hidden" name="actStatus" value="0">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									���ʦW��
								</label>
								<div class="col-sm-9">
									<input type="text" name="actName" class="form-control" 
									value="" placeholder="�п�J���ʦW��" />
									
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									���ʤ��e
								</label>
								<div class="col-sm-9">
									<textarea name="actContent" rows="3" cols="54" placeholder="�п�J���ʤ��e"></textarea>

								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									���ʤ��
								</label>
								<div class="col-sm-9">
									<input type="date" name="actDate" class="form-control" 
									value="" min="<%=actDateMin %>" >	
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									���W�I����	
								</label>
								<div class="col-sm-9">
									<input type="date" name="actFDate" class="form-control" value="" 
											min="<%=actDateMin %>" ">
									
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									�H�ƤW��
								</label>
								<div class="col-sm-9">
									<input type="text" name="actULimit" class="form-control" 
									value="" placeholder="�п�J�H�ƤW��">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">
									�H�ƤU��
								</label>
								<div class="col-sm-9">
									<input type="text" name="actLLimit" class="form-control" 
									value="" placeholder="�п�J�H�ƤU��">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">
									��������
								</label>
								<div  class="col-sm-9">
									<select id="test" name="actKind" >    
									  <option value="0" >��</option>
									  <option value="1" >��</option>
									  <option value="2" >��L</option>
									</select>
								</div>
							</div>
							
							<div class="form-group" id="aKind" style='display:none'>
								<label class="col-sm-3 control-label">
									��L�d������
								</label>
								<div class="col-sm-9">
									<input type="text" name="actAnotherKind" class="form-control" 
									value="" placeholder="�п�J���F���οߥH�~������">
								</div>
							</div>
							
								
							
							
							<div class="form-group">
								<label class="col-sm-3 control-label">
									�o�_���ʬۤ�
								</label>
								<div class="col-sm-9">
									<input type="file" name="actInitImg" class="form-control" onchange="openFile(event)">
									<img id="outputIMG" height=70% width=70%>
								</div>
							</div>
							
							<input type="hidden" name="action" value="newActivity">
							<input class="btn btn-primary btn-lg btn-block login-button login"
								type="submit" value="�T�{�o�_">
									
								
						</form>	
								
					</div>	
				</div>
			</div>	
		</div>	
	</div>
		
	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>