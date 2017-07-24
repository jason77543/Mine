<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Title Page</title>
<style type="text/css">
.aa{
	margin-left: 40%
}
.bb{
	margin-top: 10%
}
.cc{
	margin-top: 5%
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
			<div class="col-sm-6 col-sm-offset-3 bb">
				
				<h1 class="text-center">遺失密碼?</h1>

				<div class="form-horizontal">
				
					<form method="post" action="restMemberController">

							<div class="form-group">
								<label class="col-sm-3 control-label">
									會員帳號
								</label>
								<div class="col-sm-9">
									<input type="text" name="restMemId" class="form-control" value="" >
									
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label">
									E-mail
								</label>
								<div class="col-sm-9">
									<input type="text" name="restMemEmail" class="form-control" value="" >
									
								</div>
							</div>
							
							<input type="hidden" name="action" value="findPsw">
							<input class="btn btn-primary btn-lg  login-button login aa"
								type="submit" value="寄送密碼">
								
							<div>
								<a href="restMemberLogin.jsp" class="btn btn-link cc">回登入頁面</a> 
						
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