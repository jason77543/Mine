<%@page import="com.restMember.model.RestMemberService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
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

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				
				<h1 class="text-center">�\�U�|�����U</h1>

				<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U�s��
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value="${param.restNo}" readonly >
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U�W��
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value="${param.restName}" readonly>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U�a�}
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value="${param.restAdd}" readonly>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U�q��
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value="${param.restPhone}" readonly>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U����
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value="${param.restIntro}" readonly>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U����
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value="${param.restKind}" readonly>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U�|���b��
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value=""><input type="button" value="�ˬd�b���O�_�i��">
								</div>
								
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label">
									�\�U�|���K�X
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control" value="" >
								</div>
							</div>
						</div>	
						<input type="hidden" name="action" value="register">
						<input class="btn btn-primary btn-lg btn-block login-button login"
						type="submit" value="���U���b��">
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>