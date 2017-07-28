<%@page import="com.restMember.model.RestMember"%>
<%@page import="com.restMember.model.RestMemberService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	RestMember restMember = (RestMember)request.getAttribute("restMember");
%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>
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

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				
				<h1 class="text-center">餐廳會員註冊</h1>

				<div class="form-horizontal">
				<c:if test="${not empty hasAUser}">
					${hasAUser}
				</c:if>
					<form method="post" action="<%=request.getContextPath()%>/restMember/restMemberController">
							
							<input type="hidden" name="restNo" value="${param.restNo}">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									餐廳名稱
								</label>
								<div class="col-sm-9">
									<input type="text" name="restName" class="form-control" value="${param.restName}" readonly>
									
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									餐廳地址
								</label>
								<div class="col-sm-9">
									<input type="text" name="restAdd" class="form-control" value="${param.restAdd}" readonly>

								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									餐廳電話
								</label>
								<div class="col-sm-9">
									<input type="text" name="restPhone" class="form-control" value="${param.restPhone}" readonly>
									
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									餐廳介紹
								</label>
								<div class="col-sm-9">
									<input type="text" name="restIntro" class="form-control" value="${param.restIntro}" readonly>
									
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									餐廳種類
								</label>
								<div class="col-sm-9">
									<c:if test="${param.restKind=='0'}">
										<input type="text" name="restKind" class="form-control" value="0" readonly>狗餐廳
									</c:if>
									<c:if test="${param.restKind=='1'}">
										<input type="text" name="restKind" class="form-control" value="1" readonly>貓餐廳
									</c:if>
									<c:if test="${param.restKind=='2'}">
										<input type="hidden" name="restKind"  value="2" >
										<input type="text" value="其他餐廳" class="form-control" readonly>
									</c:if>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label">
									餐廳會員帳號
								</label>
								<div class="col-sm-9">
									<input type="text" name="restMemId" class="form-control" value="<%=(restMember==null)?"":restMember.getRestMemId()%>">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label">
									餐廳會員密碼
								</label>
								<div class="col-sm-9">
									<input type="text" name="restMemPsw" class="form-control" value="<%=(restMember==null)?"":restMember.getRestMemPsw()%>">
									
								</div>
							</div>
							<input type="hidden" name="action" value="register">
							<input class="btn btn-primary btn-lg btn-block login-button login"
								type="submit" value="註冊此帳號">
							<div>
								<a href="restMemberLogin.jsp" class="btn btn-link">回登入頁面</a> 
								<a href="restMemberList.jsp" class="btn btn-link">回註冊首頁</a>
							</div>	
								
						</form>			
					</div>	
						
						
					
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>