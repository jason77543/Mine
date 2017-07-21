package com.restMember.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restMember.model.RestMember;







@WebServlet("/restMemberServlet")
public class restMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 protected Member allowUser(String memId, String memPwd) {
		  MemberService memSvc = new MemberService();
		  Member member = memSvc.getOneMemberById(memId);

		  if (member == null) {
		   return null;
		  } else if (!member.getMemPwd().equals(memPwd)) {
		   return null;
		  } else {
		   return member;
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
			
				if(!errorMsgs.isEmpty()){
					RequestDispatcher requestDispatcher =req.getRequestDispatcher("/restMember/restMemberLogin.jsp");
					requestDispatcher.forward(req, res);
				}
				
				///////////////////////////�n�J���\///////////////////////////////
				
				RequestDispatcher requestDispatcher =req.getRequestDispatcher("/restMember/restMember.jsp");
				requestDispatcher.forward(req, res);
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}

}
