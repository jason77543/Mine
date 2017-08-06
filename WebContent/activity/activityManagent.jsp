<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.restMember.model.RestMember"%>
<%@page import="java.util.List"%>
<%@page import="com.activity.model.ActivityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ page import="com.activity.model.Activity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	ActivityService activityService = new ActivityService();
	RestMember restMember = (RestMember)session.getAttribute("restMember");
	Activity activity = (Activity)request.getAttribute("activity");
	List<Activity> activitiyList = activityService.getAllById(restMember.getRestMemId());
	session.setAttribute("activitiyList", activitiyList);
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html lang="">

<head>
    
    <!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	<style type="text/css">
			.btn123{
				margin-top: 10px;
			}
			
	</style>	
	
</head>

<body>

    <%@ include file="/files/restMemberNavBar.file" %>
	<%@ include file="/files/overflow.file" %>

    <div class="container-fluid">
        <div class="row"> 
        	<%@ include file="/files/restMemberList.file" %>
        <div class="col-xs-12 col-sm-8">       
   
    <div class="panel-group col-sm-offset-2 col-sm-8">
    
    
		<h5 class=" page-header text-right">�ثe��m:�޲z�ڪ�����</h5>
		
       <div class="panel-heading">
         <h3 class="panel-title text-center">�Ҧ�����</h3>
         
        <div class="row btn123">
         <div class="col-xs-12 col-sm-4"><div class="btn-group btn-group-justified">
				<div class="btn-group">
					<a href="#" class="btn btn-default" role="button">�̪�@�~</a>
				</div>
				
			</div></div>
			<div class="col-xs-12 col-sm-4"><div class="btn-group btn-group-justified">
				
				<div class="btn-group">
					<a href="#" class="btn btn-default" role="button">�̪�@�Ӥ�</a>
				</div>
				
			</div></div>
			<div class="col-xs-12 col-sm-4"><div class="btn-group btn-group-justified">
				
				<div class="btn-group">
					<a href="#" class="btn btn-default" role="button">�̪�@�P��</a>
				</div>
			</div></div>
      	 </div>
		</div>
		
			<c:forEach var="activity" items="${activitiyList}">
			 <div class="panel panel-default">
		       <div class="panel-heading">
		       	
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<h3 class="panel-title">���ʦW��:${activity.actName}</h3>
							</div>
							<div class="col-xs-12 col-sm-6 text-right">
								
									<footer>
										<c:if test="${activity.actStatus=='0'}"><font color="red">���ʵo�_�ݼf��</font></c:if>
										<c:if test="${activity.actStatus=='1'}"><font color="red">�f�֥��q�L</font></c:if>
										<c:if test="${activity.actStatus=='2'}"><font color="green">�f�ֳq�L</font></c:if>	
										<c:if test="${activity.actStatus=='3'}"><font color="red">�\�U��������</font></c:if>
									</footer>
								
							</div>
						</div>
					
		       </div>
		       
			       <div class="col-xs-12 col-sm-4">
						<img src="<%=request.getContextPath() %>/activity/DBGifReader5?actNo=${activity.actNo}" class="img-responsive" >
					</div>
				
					
					
					<div class="col-xs-12 col-sm-8 actarea">
						<p class="overflow">${activity.actContent}</p>
						
					</div>
					
					
					
				
		       <div class="row">
					<div class="col-xs-12 col-sm-12">
						<div class="panel-body text-right" >
		         			<a href='#modal-id' data-toggle="modal" class="btn btn-primary">���ʸԱ�</a>
								<div class="modal fade" id="modal-id">
									<div class="modal-dialog">
										<div class="modal-content">
											
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title text-center">���ʸԱ�</h4>
					</div>
			
				<div class="modal-body">
					<div class="container">
						<div class="row">
				
							<div class="col-sm-5">
									
				
								<div class="form-horizontal">
								
									<form method="post" action="<%=request.getContextPath()%>/activity/activityController">
									
											
											<input type="hidden" name="actNo" value="${activity.actNo}">
											<input type="hidden" name="restMemId" value="${restMember.restMemId }">
											<input type="hidden" name="actStatus" value="${activity.actStatus }">
									
											<div class="form-group">
												<div class="col-xs-12 col-sm-4">
													<img src="<%=request.getContextPath()%>/activity/DBGifReader5?actNo=${activity.actNo}" class="img-responsive" >
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													���ʦW��
												</label>
												<div class="col-sm-9">
													<input type="text" name="actName" class="form-control" value="${activity.actName }">	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													���ʤ��e
												</label>
												<div class="col-sm-9">
													<textarea name="actContent" rows="3" cols="47" wrap="hard">${activity.actContent }</textarea>	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													���ʤ��
												</label>
												<div class="col-sm-9">
													<input type="date" name="actDate" class="form-control" value="${activity.actDate }"
															min="<%=%>">	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													���W�I����
												</label>
												<div class="col-sm-9">
													<input type="date" name="actFDate" class="form-control" value="${activity.actFDate}">	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													�H�ƤW��
												</label>
												<div class="col-sm-9">
													<input type="text" name="actULimit" class="form-control" value="${activity.actFDate }">	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													�H�ƤU��
												</label>
												<div class="col-sm-9">
													<input type="text" name="actLLimit" class="form-control" value="">	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													��������
												</label>
												<div class="col-sm-9">
													<input type="text" name="restName" class="form-control" value="">	
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">
													��L�d������
												</label>
												<div class="col-sm-9">
													<input type="text" name="restName" class="form-control" value="">	
												</div>
											</div>
											
											
									</form>			
								</div>		
							</div>
						</div>
					</div>
								
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">����</button>
				<button type="submit" class="btn btn-primary">Save changes</button>
			</div>
					</div>
				</div>
			</div>
					         			
		       			</div>
					</div>	
				</div>
		     </div>
			</c:forEach>
        
       </div>
     </div>

	



        </div>
        </div>




    
  
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>

</html>