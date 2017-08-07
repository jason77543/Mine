package com.restaurant.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.restMember.model.RestMember;
import com.restMember.model.RestMemberService;
import com.restaurant.model.Restaurant;
import com.restaurant.model.RestaurantService;


@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected Double getLongtitude(String restAdd){
		Double longtitude = null;
		try {
			String sKeyWord = restAdd;
			
			URL urlFromGMap  = new URL(String.format("http://maps.googleapis.com/maps/api/geocode/json?address=%s&sensor=false&language=zh-TW", 
			URLEncoder.encode(sKeyWord, "UTF-8")));//p=%s is KeyWord in	            
			URLConnection connFromGMap = urlFromGMap.openConnection();
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader readerFromGMap = new BufferedReader(new InputStreamReader(connFromGMap.getInputStream(),"utf-8"));
			while ((line = readerFromGMap.readLine()) != null) {builder.append(line);}
				JSONObject json = new JSONObject(builder.toString()); //�ഫjson�榡
			    JSONArray ja = json.getJSONArray("results");//���ojson��Array����
			        for (int i = 0; i < ja.length(); i++) {
		                  
//		            lat.add(ja.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
		            longtitude = (ja.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
		                 
			}
			              
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return longtitude;       
	}
    
	protected Double getLatitude(String restAdd){
		Double latitude = null;
		try {
			String sKeyWord = restAdd;
			
			URL urlFromGMap  = new URL(String.format("http://maps.googleapis.com/maps/api/geocode/json?address=%s&sensor=false&language=zh-TW", 
			URLEncoder.encode(sKeyWord, "UTF-8")));//p=%s is KeyWord in	            
			URLConnection connFromGMap = urlFromGMap.openConnection();
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader readerFromGMap = new BufferedReader(new InputStreamReader(connFromGMap.getInputStream(),"utf-8"));
			while ((line = readerFromGMap.readLine()) != null) {builder.append(line);}
				JSONObject json = new JSONObject(builder.toString()); //�ഫjson�榡
			    JSONArray ja = json.getJSONArray("results");//���ojson��Array����
			        for (int i = 0; i < ja.length(); i++) {
		                  
			        latitude = (ja.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
//		            longtitude = (ja.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
		                 
			}
			              
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return latitude;       
	}
	
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
	
	
    public RestaurantServlet() {
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
			
			String restLocate = req.getParameter("restAdd").substring(0,2)+"��";
			if( (restLocate.trim()).length()==0 || restLocate == null ){
				updateError.add("�\�U�����ഫ���~");
			}
			
			Integer restReviewStatus = null;
			try {
				restReviewStatus = Integer.parseInt(req.getParameter("restReviewStatus"));
			} catch (Exception e) {
				updateError.add("�\�U���A��J���~");
			}
			
			Double restLongtitude = null;
			try {
				restLongtitude = getLongtitude(restAdd);
			} catch (Exception e) {
				updateError.add("�\�U�g�׿�J���~");
			}
			
			Double restLatitude = null;
			try {
				restLatitude = getLatitude(restAdd);
			} catch (Exception e) {
				updateError.add("�\�U�n�׿�J���~");
			}
			
			if(!updateError.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/restMember/restMemberManagement.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			
			////////////////////�����///////////////////////////
			
			
			
			RestaurantService restaurantService = new RestaurantService();
			Restaurant restaurant = restaurantService.updateRestForManager(restNo, restName, 
					restAdd, restLocate, restPhone, restIntro, restKind, restReviewStatus, 
					restLongtitude, restLatitude);  
			
			HttpSession session = req.getSession();
			
			
			session.getAttribute("restaurant");
			session.removeAttribute("restaurant");
			session.setAttribute("restaurant", restaurant);
			
			
			
			
			//////////////////���//////////////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/restMember/restMember.jsp");
			requestDispatcher.forward(req, res);
			
			}
			
			
			
			
			///////////////////////////�s�W�\�U//////////////////////////////
			else if("newRestaurant".equals(action)){
				
				List<String> newRestErr = new ArrayList<>();
				req.setAttribute("newRestErr", newRestErr);
				
				
				/////////////////////////����//////////////////////////////
				
				
				
				
				String restName = req.getParameter("restName");
				if( (restName.trim()).length()==0 || restName == null){
					newRestErr.add("�\�U�W�ٽФůd��");
				}
				
				String restAdd = req.getParameter("restAdd");
				if( (restAdd.trim()).length()==0 || restAdd == null ){
					newRestErr.add("�\�U�a�}���~�ίd��");
				}
				
				String restPhone = req.getParameter("restPhone");
				if( (restPhone.trim()).length()==0 || restPhone == null){
					newRestErr.add("�\�U�q�ܽФůd��");
				}
				
				String restIntro = req.getParameter("restIntro");
				if( (restIntro.trim()).length()==0 || restIntro == null){
					newRestErr.add("�\�U���нФůd��");
				}
				
				Integer restKind = null;
				try {
					restKind = Integer.parseInt(req.getParameter("restKind").trim());
				} catch (Exception e) {
					newRestErr.add("�\�U�����Фůd��");
				}
				
				String restLocate = null;
				try {
					restLocate = req.getParameter("restAdd").substring(0,2)+"��";
						if( (restLocate.trim()).length()==0 || restLocate == null ){
							newRestErr.add("�п�J���T����");
						}
				} catch (Exception e) {
					newRestErr.add("�\�U�����ഫ���~");
				}
				
				Integer restReviewStatus = null;
				try {
					restReviewStatus = Integer.parseInt(req.getParameter("restReviewStatus"));
				} catch (Exception e) {
					newRestErr.add("�\�U���A��J���~");
				}
				
				Double restLongtitude = null;
				
				try {
					restLongtitude = getLongtitude(restAdd);
						if(restLongtitude>180.0 || restLongtitude<0.0){
							newRestErr.add("�п�J���T�a�}");
						}
				} catch (Exception e) {
					newRestErr.add("�\�U�g�׿�J���~");
				}
				
				Double restLatitude = null;
				try {
					restLatitude = getLatitude(restAdd);
						if(restLatitude>90.0 || restLatitude<0.0){
							newRestErr.add("�п�J���T�a�}");
						}
				} catch (Exception e) {
					newRestErr.add("�\�U�n�׿�J���~");
				}
				
				if(!newRestErr.isEmpty()){
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/restaurant/newRestaurant.jsp");
					requestDispatcher.forward(req, res);
					return;
				}
				
				///////////////�s�W���///////////////////////////////
				
				RestaurantService restaurantService = new RestaurantService();
				Restaurant restaurant = restaurantService.addRest(restName, restAdd, restLocate, 
						restPhone, restIntro, restKind, restReviewStatus, restLongtitude, restLatitude);
				req.setAttribute("restaurant", restaurant);
				
				////////////////���////////////////////////////////
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/restMember/restMemberList.jsp");
				requestDispatcher.forward(req, res);
				
			}
		}

}
