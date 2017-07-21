package com.restMember.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restMember.model.RestMember;
import com.restMember.model.RestMemberService;







@WebServlet("/restMemberServlet")
public class restMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected RestMember allowUser(String restMemId,String restMemPsw){
		RestMemberService restMemberService = new RestMemberService();
		RestMember restMember = restMemberService.getOneRestMember(restMemId);
		if(restMember==null){
			return null;
		} else if(!restMember.getRestMemPsw().equals(restMemPsw)){
			return null;
		} else {
			return restMember;
		}
	}
	 
    public restMemberServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("login".equals(action)){
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try{
				///////////////////////////�ˬd////////////////////////////
				String restMemId = req.getParameter("restMemId");
				
				String restMemReg = "^[a-zA-Z0-9_]{2,10}$";
				if(restMemId == null || (restMemId.trim()).length() == 0 ){
					errorMsgs.put("restMemId", "�\�U�|���b������ť�");
				} else if(!restMemId.trim().matches(restMemReg)){
					errorMsgs.put("restMemId", "�\�U�|���b���u��^��B�Ʀr�M_�A����2��10");
				}
				
				String restMemPsw = req.getParameter("restMemPsw");
				
				if(restMemPsw == null || (restMemPsw.trim()).length() == 0 ){
					errorMsgs.put("restMemId", "�\�U�|���K�X����ť�");
				}else if(!restMemPsw.trim().matches(restMemReg)){
					errorMsgs.put("restMemId", "�\�U�|���K�X�u��^��B�Ʀr�M_�A����2��10");
				}
				
				if(allowUser(restMemId, restMemPsw)==null){
					errorMsgs.put("restMemId", "�\�U�|���b���K�X���~");
				}
			
				if(!errorMsgs.isEmpty()){
					RequestDispatcher requestDispatcher =req.getRequestDispatcher("/restMember/restMemberLogin.jsp");
					requestDispatcher.forward(req, res);
				}
				
				///////////////////////////�n�J���\///////////////////////////////
				
				HttpSession session = req.getSession();
				session.setAttribute("restMember", allowUser(restMemId, restMemPsw));
				
				
				///////////////////////////���o���ǳ�//////////////////////////////
//				String location = (String)session.getAttribute("location");
//				if(location != null){
//					session.removeAttribute(location);
//					res.sendRedirect(location);
//					return;
//				} else{
//					res.sendRedirect(req.getContextPath()+"/restMember/restMemberLogin.jsp");
//				}
				
				RequestDispatcher requestDispatcher =req.getRequestDispatcher("/restMember/restMember.jsp");
				requestDispatcher.forward(req, res);
				
				
				
			} catch (Exception e) {
				errorMsgs.put("Exception",e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/restMember/restMemberLogin.jsp");
				failureView.forward(req, res);
			}
			
		}
		
		
		else if("register".equals(action)){
			
			List<String> hasAUser = new ArrayList<>();
			req.setAttribute("hasAUser", hasAUser);
			
			/////////////////////���ұb�����L�Q���U/////////////////////
			String restMemId = req.getParameter("restMemId");
			String restMemPsw = req.getParameter("restMemPsw");
			
			int restNo =  Integer.parseInt(req.getParameter("restNo")) ;
			
			
			
			if(allowUser(restMemId, restMemPsw)==null){
				hasAUser.add("���b���w�g���H���U�P~");
			}
			
			if(!hasAUser.isEmpty()){
				RequestDispatcher requestDispatcher =req.getRequestDispatcher("/restMember/restMemberRegister.jsp");
				requestDispatcher.forward(req, res);
			}
			
			////////////////////�s���b��////////////////////////////
			RestMemberService restMemberService = new RestMemberService();
			restMemberService.addRestMember(restMemId, restNo, restMemPsw);	
		}
		
		
		
		
	}

}
