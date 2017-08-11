package com.actDetial.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.actDetial.model.ActDetial;
import com.actDetial.model.ActDetialService;
import com.activity.model.Activity;
import com.activity.model.ActivityService;
import com.member.model.Member;
import com.member.model.MemberService;



@WebServlet("/ActDetialServlet")
public class ActDetialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ActDetialServlet() {
        super();
       
    }
    
    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		
		if("joinActivity".equals(action)){
			
			List<String> joinErr = new ArrayList<>();
			req.setAttribute("joinErr", joinErr);
			
			
			Integer actNo = null;
			try {
				actNo = Integer.parseInt(req.getParameter("actNo"));
				
			} catch (Exception e) {
				joinErr.add("�ѥ[���ʿ��~_���ʽs��");
			}
			
			Integer memNo = null;
			try {
				memNo = Integer.parseInt(req.getParameter("memNo"));
				
			} catch (Exception e) {
				joinErr.add("�ѥ[���ʿ��~_�|���s��");
			}
			
			Integer memActStatus = null;
			try {
				memActStatus = Integer.parseInt(req.getParameter("memActStatus"));
				
			} catch (Exception e) {
				joinErr.add("�ѥ[���ʿ��~_�|���ѥ[�s��");
			}
			
			if(!joinErr.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/activityFront/activityIndex.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			////////////////////////�s���Χ�s/////////////////////////////
			
			
			
			
			ActDetialService actDetialService = new ActDetialService();
	    	ActDetial actDetial = actDetialService.getOneActDetial(actNo, memNo);
	    	try {
	    		if(! (  (actDetial.getActNo().equals(actNo)) && (actDetial.getMemNo().equals(memNo))  ) ){
		    		actDetial = actDetialService.addActDetial(actNo, memNo, memActStatus);
					req.setAttribute("actDetial", actDetial);
		    	}else{
		    		actDetial = actDetialService.updateActDetial(actNo, memNo, memActStatus);
		    		req.setAttribute("actDetial", actDetial);
		    	}
			} catch (Exception e) {
				actDetial = actDetialService.addActDetial(actNo, memNo, memActStatus);
				req.setAttribute("actDetial", actDetial);
			}
	    	
			
			
			//////////////////////���////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/activityFront/activityIndex.jsp");
			requestDispatcher.forward(req, res);
			
			
			
		}
		
		
		else if("cancelActivity".equals(action)){
			
			List<String> cancelErr = new ArrayList<>();
			req.setAttribute("cancleErr", cancelErr);
			
			
			Integer actNo = null;
			try {
				actNo = Integer.parseInt(req.getParameter("actNo"));
				
			} catch (Exception e) {
				cancelErr.add("�ѥ[���ʿ��~_���ʽs��");
			}
			
			Integer memNo = null;
			try {
				memNo = Integer.parseInt(req.getParameter("memNo"));
				
			} catch (Exception e) {
				cancelErr.add("�ѥ[���ʿ��~_�|���s��");
			}
			
			Integer memActStatus = null;
			try {
				memActStatus = Integer.parseInt(req.getParameter("memActStatus"));
				
			} catch (Exception e) {
				cancelErr.add("�ѥ[���ʿ��~_�|���ѥ[�s��");
			}
			
			if(!cancelErr.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/activityFront/activityIndex.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			////////////////////////�s��/////////////////////////////
			ActDetialService actDetialService = new ActDetialService();
			ActDetial actDetial = actDetialService.updateActDetial(actNo, memNo, memActStatus);
			
			req.setAttribute("actDetial", actDetial);
			
			
			//////////////////////���////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/activityFront/activityIndex.jsp");
			requestDispatcher.forward(req, res);
			
			
			
		}
	}

}
