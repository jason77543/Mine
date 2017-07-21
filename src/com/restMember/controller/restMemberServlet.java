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
				///////////////////////////檢查////////////////////////////
				String restMemId = req.getParameter("restMemId");
				
				String restMemReg = "^[a-zA-Z0-9_]{2,10}$";
				if(restMemId == null || (restMemId.trim()).length() == 0 ){
					errorMsgs.put("restMemId", "餐廳會員帳號不能空白");
				} else if(!restMemId.trim().matches(restMemReg)){
					errorMsgs.put("restMemId", "餐廳會員帳號只能英文、數字和_，長度2到10");
				}
				
				String restMemPsw = req.getParameter("restMemPsw");
				
				if(restMemPsw == null || (restMemPsw.trim()).length() == 0 ){
					errorMsgs.put("restMemId", "餐廳會員密碼不能空白");
				}else if(!restMemPsw.trim().matches(restMemReg)){
					errorMsgs.put("restMemId", "餐廳會員密碼只能英文、數字和_，長度2到10");
				}
				
				if(allowUser(restMemId, restMemPsw)==null){
					errorMsgs.put("restMemId", "餐廳會員帳號密碼有誤");
				}
			
				if(!errorMsgs.isEmpty()){
					RequestDispatcher requestDispatcher =req.getRequestDispatcher("/restMember/restMemberLogin.jsp");
					requestDispatcher.forward(req, res);
				}
				
				///////////////////////////登入成功///////////////////////////////
				
				HttpSession session = req.getSession();
				session.setAttribute("restMember", allowUser(restMemId, restMemPsw));
				
				
				///////////////////////////為濾器準備//////////////////////////////
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
			
			/////////////////////驗證帳號有無被註冊/////////////////////
			String restMemId = req.getParameter("restMemId");
			String restMemPsw = req.getParameter("restMemPsw");
			
			int restNo =  Integer.parseInt(req.getParameter("restNo")) ;
			
			
			
			if(allowUser(restMemId, restMemPsw)==null){
				hasAUser.add("此帳號已經有人註冊嚕~");
			}
			
			if(!hasAUser.isEmpty()){
				RequestDispatcher requestDispatcher =req.getRequestDispatcher("/restMember/restMemberRegister.jsp");
				requestDispatcher.forward(req, res);
			}
			
			////////////////////存取帳號////////////////////////////
			RestMemberService restMemberService = new RestMemberService();
			restMemberService.addRestMember(restMemId, restNo, restMemPsw);	
		}
		
		
		
		
	}

}
