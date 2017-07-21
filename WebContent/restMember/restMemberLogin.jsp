<%@page import="com.restMember.model.RestMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ page import="com.restMember.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
 RestMember restMember =(RestMember)request.getAttribute("restMember"); 
%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Title Page</title>
<style type="text/css">
.pwd {
	margin-top: 20px;
}

.login {
	margin-top: 15px;
}

#memIdShow {
   color: red;
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

				<div align="center">
					<Img src="../img/1.jpg" height="250px" width="400px" />
				</div>

				<form class="" action="restMember"  method="post">
							<c:if test="${not empty errorMsgs}">
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
									
										<li>${message.value}</li>
									</c:forEach>
									
								</ul>
									
							</c:if>	
				

					<div class="form-group">
						<label for="restMemId" class="cols-sm-2 control-label">帳號</label><span
							id="restMemIdShow"> 
							

						</span>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="restMemId" id="restMemId" value="<%= (restMember==null)?"":restMember.getRestMemId() %>" placeholder="請輸入帳號" required />
							</div>
						</div>
					</div>


					<div class="form-group pwd">
						<label for="memId" class="cols-sm-2 control-label">密碼</label><span
							id="restMemIdShow">
							
							</span>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="password"
									class="form-control" name="restMemPsw" id="restMemPsw" value="<%= (restMember==null)?"":restMember.getRestMemPsw() %>"
									placeholder="請輸入帳號" required />
							</div>
						</div>
					</div>

					<div class="checkbox">
						<label> <input type="checkbox"> 記住我
						</label>
					</div>
					<input type="hidden" name="action" value="login">
					<input class="btn btn-primary btn-lg btn-block login-button login"
						type="submit" value="登錄">
					<div>
						<a href="#" class="btn btn-link">忘記密碼</a> <a href="restMemberList.jsp"
							class="btn btn-link">註冊</a>
					</div>
					
				</form>

			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>