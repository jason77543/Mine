<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.restMember.model.*"%>

<html >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
		<title>Title Page</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script> 
		<![endif]--><style type="text/css">
			.ad{
				margin-top: 50%;
			}
		</style>
	</head>
	<body>
		
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-sm-offset-3">
					
					<form method="post" action="restMember.do" name="restMemberForm1">
						<div class="form-horizontal ad">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									帳號
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label">
									密碼
								</label>
								<div class="col-sm-9">
									<input type="text" name="" class="form-control">
								</div>
							</div>
						</div>		
	
							<div class="text-center">
								<input type="checkbox"  id="">記住我
								<button class="btn btn-info">忘記密碼</button>
								<button class="btn btn-info">登入</button>
							</div>
						
					</form>
				</div>
			</div>
		</div>	
		
		
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
</html>