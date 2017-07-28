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
		
		
		/////////////////////修改餐廳資料///////////////////////////
		
			if("updateRestMemData".equals(action)){
			
			
			//////////////////檢查更改資料///////////////////////////
			List<String> updateError = new ArrayList<>();
			req.setAttribute("updateError", updateError);
			
			
			Integer restNo = Integer.parseInt(req.getParameter("restNo").trim());
			
			
			
			String restName = req.getParameter("restName");
			if( (restName.trim()).length()==0 || restName == null){
				updateError.add("餐廳名稱請勿留空");
			}
			
			String restAdd = req.getParameter("restAdd");
			if( (restAdd.trim()).length()==0 || restAdd == null){
				updateError.add("餐廳地址請勿留空");
			}
			
			String restPhone = req.getParameter("restPhone");
			if( (restPhone.trim()).length()==0 || restPhone == null){
				updateError.add("餐廳電話請勿留空");
			}
			
			String restIntro = req.getParameter("restIntro");
			if( (restIntro.trim()).length()==0 || restIntro == null){
				updateError.add("餐廳介紹請勿留空");
			}
			
			Integer restKind = null;
			try {
				restKind = Integer.parseInt(req.getParameter("restKind").trim());
			} catch (Exception e) {
				updateError.add("餐廳種類請勿留空");
			}
			
			
			
			
			
			if(!updateError.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/restMember/restMemberManagement.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			
			////////////////////用service更改資料///////////////////////////
			
			
			
			RestaurantService restaurantService = new RestaurantService();
			Restaurant restaurant = restaurantService.updateRestForRestMember(restNo, restName, restAdd, restPhone, restIntro, restKind);
			
			HttpSession session = req.getSession();
			
			
			session.getAttribute("restaurant");
			session.removeAttribute("restaurant");
			session.setAttribute("restaurant", restaurant);
			
			
			
			
			//////////////////轉交//////////////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/restMember/restMember.jsp");
			requestDispatcher.forward(req, res);
			
			}
			
			
			else if("newRestaurant".equals(action)){
				List<String> newRestErr = new ArrayList<>();
				req.setAttribute("newRestErr", newRestErr);
				
				
				
			}
		}

}
