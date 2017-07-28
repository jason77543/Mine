package com.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restMember.model.RestMember;
import com.restMember.model.RestMemberService;
import com.restaurant.model.Restaurant;
import com.restaurant.model.RestaurantService;


@WebServlet("/restaurantServlet")
public class restaurantServlet extends HttpServlet {
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
	
	
	
	 
	protected Restaurant restUser(RestMember restMember){
		RestaurantService restaurantService = new RestaurantService();
		Restaurant restaurant = restaurantService.getOneRest(restMember.getRestNo());
		return restaurant;
	}
	
	
    public restaurantServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		/////////////////////�ק��\�U���///////////////////////////
		
			if("updateRestMemData".equals(action)){
			
			
			//////////////////�ˬd�����///////////////////////////
			List<String> updateError = new ArrayList<>();
			req.setAttribute("updateError", updateError);
			
			
			Integer restNo = Integer.parseInt(req.getParameter("restNo").trim());
			
			
			
			String restName = req.getParameter("restName");
			if( (restName.trim()).length()==0 || restName == null){
				updateError.add("�\�U�W�ٽФůd��");
			}
			
			String restAdd = req.getParameter("restAdd");
			if( (restAdd.trim()).length()==0 || restAdd == null){
				updateError.add("�\�U�a�}�Фůd��");
			}
			
			String restPhone = req.getParameter("restPhone");
			if( (restPhone.trim()).length()==0 || restPhone == null){
				updateError.add("�\�U�q�ܽФůd��");
			}
			
			String restIntro = req.getParameter("restIntro");
			if( (restIntro.trim()).length()==0 || restIntro == null){
				updateError.add("�\�U���нФůd��");
			}
			
			Integer restKind = null;
			try {
				restKind = Integer.parseInt(req.getParameter("restKind").trim());
			} catch (Exception e) {
				updateError.add("�\�U�����Фůd��");
			}
			
			
			
			
			
			if(!updateError.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/restMember/restMemberManagement.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			
			////////////////////��service�����///////////////////////////
			
			
			
			RestaurantService restaurantService = new RestaurantService();
			Restaurant restaurant = restaurantService.updateRestForRestMember(restNo, restName, restAdd, restPhone, restIntro, restKind);
			
			HttpSession session = req.getSession();
			
			
			session.getAttribute("restaurant");
			session.removeAttribute("restaurant");
			session.setAttribute("restaurant", restaurant);
			
			
			
			
			//////////////////���//////////////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/restMember/restMember.jsp");
			requestDispatcher.forward(req, res);
			
			}
			
			
			else if("newRestaurant".equals(action)){
				List<String> newRestErr = new ArrayList<>();
				req.setAttribute("newRestErr", newRestErr);
				
				
				
			}
		}

}
