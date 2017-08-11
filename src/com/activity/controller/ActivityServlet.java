package com.activity.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.*;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.activity.model.Activity;
import com.activity.model.ActivityService;
import com.restMember.model.RestMember;
import com.restMember.model.RestMemberService;
import com.restaurant.model.Restaurant;
import com.restaurant.model.RestaurantService;


@WebServlet("/ActivityServlet")
@MultipartConfig
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static byte[] getPictureByteArray(InputStream fis) throws IOException {
		
		BufferedImage originalImage = ImageIO.read(fis);
		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(resizeImageJpg, "jpg", baos);
		baos.flush();
		baos.close();
		return baos.toByteArray();
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
		BufferedImage resizedImage = new BufferedImage(400, 300, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 400, 300, null);
		g.dispose();
		
		return resizedImage;
	}

	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
       
    //Pattern.compile("[\\p{InCJKUnifiedIdeographs}]"); //�u���\����
	//Pattern.compile("[^\\x00-\\x40\\x5B-\\x60\\x7B-\\x7F]"); //�u���\�^��r���H�Τ���
    public ActivityServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("newActivity".equals(action)){
			
			List<String> activityError = new ArrayList<>();
			req.setAttribute("activityError", activityError);
			
			
			
			String restMemId = req.getParameter("restMemId");
			
			Integer actStatus = null;
			try {
				actStatus = Integer.parseInt(req.getParameter("actStatus"));
			} catch (Exception e) {
				activityError.add("���ʪ��A���~");
			}
			
			String actName = req.getParameter("actName");
			String meg = "^[a-zA-Z0-9_\u4E00-\u9FFF]{0,30}";
			
			if(actName==null || (actName.trim()).length()==0 ){
				activityError.add("�п�J���ʦW��");
			}
			else if(!actName.trim().matches(meg)){
				activityError.add("�п�J���B�^��B�Ʀr�άO_�A���׳̤j��30�r");
			}
			
			String actContent = req.getParameter("actContent");
			String meg1 = "^[a-zA-Z0-9_\u4E00-\u9FFF]";
			
			if(actContent==null||(actContent.trim()).length()==0){
				activityError.add("�п�J���ʤ��e");
			}
			
			
			java.sql.Date actDate = null;
			try {
				actDate = java.sql.Date.valueOf(req.getParameter("actDate").trim());
			} catch (Exception e) {
				actDate = new java.sql.Date(System.currentTimeMillis());
				activityError.add("�п�J���ʤ��");
			}
			
			java.sql.Date actFDate = null;
			try {
				actFDate = java.sql.Date.valueOf(req.getParameter("actFDate").trim());
			} catch (Exception e) {
				actFDate = new java.sql.Date(System.currentTimeMillis());
				activityError.add("�п�J�I����");
			}
			
			if(!actDate.after(actFDate) || actDate.equals(actFDate)){
				activityError.add("�I��������W�L���ʤ���άO�P�@��");
			}
			
			
			
			Integer actULimit = null;
			try {
				actULimit = Integer.parseInt(req.getParameter("actULimit").trim());
				if(actULimit<0){
					activityError.add("�п�J���T�W���H��");
				}
			} catch (Exception e) {
				actULimit = 0 ;
				activityError.add("�п�J���T�W���H��");
			}
			
			Integer actLLimit = null;
			try {
				actLLimit = Integer.parseInt(req.getParameter("actLLimit").trim());
				if(actLLimit<0){
					activityError.add("�п�J���T�U���H��");
				}
			} catch (Exception e) {
				actLLimit = 0 ;
				activityError.add("�п�J���T�U���H��");
			}
			
			if(actLLimit>actULimit){
				activityError.add("�U���H�Ƥ���W�V�W���H��");
			}
			
			Integer actKind = null;
			try {
				actKind = new Integer(req.getParameter("actKind").trim());
			} catch (Exception e) {
				activityError.add("���ʺ���������~");
			}
			
			String actAnotherKind = req.getParameter("actAnotherKind");
			
			
			byte[] actInitImg =null;
			Collection<Part> parts = req.getParts();
			
			try {
				for(Part part :parts){
					
					if(part.getName().equals("actInitImg") && getFileNameFromPart(part) != null
							&& part.getContentType().startsWith("image")){
						
						actInitImg = getPictureByteArray(part.getInputStream());
					}
				}
			} catch (Exception e) {
				activityError.add("�Ӥ����~");
			}
			
			
			
			
			
			
			if(!activityError.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/activity/newActivity.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			
			/////////////////////////�s�W����/////////////////////////////
			ActivityService activityService = new ActivityService();
			Activity activity = activityService.addActivity(restMemId, actName, actContent,
					actDate, actFDate, actStatus, actULimit, actLLimit, actKind, actAnotherKind, actInitImg);
			
			req.setAttribute("activity", activity);
			
			////////////////////////��s////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/restMember/restMember.jsp");
			requestDispatcher.forward(req, res);
		}
		
		
		
		//////////////////////////��s/////////////////////////////////////
		else if("updateActivity".equals(action)){
			List<String> updateErr = new ArrayList<>();
			req.setAttribute("updateErr", updateErr);
			///////////////////////����/////////////////////////////////////
			
			Integer actNo = null;
			try {
				actNo = Integer.parseInt(req.getParameter("actNo").trim());
			} catch (Exception e) {
				updateErr.add("���ʽs�����~");
			}
			
			
			String restMemId = req.getParameter("restMemId");
			if((restMemId.trim()).length()==0 || restMemId==null){
				updateErr.add("�\�U�|���b�����~");
			}
			
			
			String actName = req.getParameter("actName");
			if((actName.trim()).length()==0 || actName==null){
				updateErr.add("�ж�g���T���ʦW��");
			}
			
			
			
			String actContent = req.getParameter("actContent");
			if((actContent.trim()).length()==0 || actContent==null){
				updateErr.add("�ж�g���T���ʤ��e");
			}
			
			
			
			java.sql.Date actDate = null;
			try {
				actDate = java.sql.Date.valueOf(req.getParameter("actDate").trim());
			} catch (Exception e) {
				actDate = new java.sql.Date(System.currentTimeMillis());
				updateErr.add("�ж�g���T���ʤ��");
			}
			
			java.sql.Date actFDate = null;
			try {
				actFDate = java.sql.Date.valueOf(req.getParameter("actFDate").trim());
			} catch (Exception e) {
				actFDate = new java.sql.Date(System.currentTimeMillis());
				updateErr.add("�п�J�I����");
			}
			
			if(!actDate.after(actFDate) || actDate.equals(actFDate)){
				updateErr.add("�I��������W�L���ʤ���άO�P�@��");
			}
			
			
			
			Integer actULimit = null;
			try {
				actULimit = Integer.parseInt(req.getParameter("actULimit").trim());
				if(actULimit<0){
					updateErr.add("�п�J���T�W���H��");
				}
			} catch (Exception e) {
				actULimit = 0 ;
				updateErr.add("�п�J���T�W���H��");
			}
			
			Integer actLLimit = null;
			try {
				actLLimit = Integer.parseInt(req.getParameter("actLLimit").trim());
				if(actLLimit<0){
					updateErr.add("�п�J���T�U���H��");
				}
			} catch (Exception e) {
				actLLimit = 0 ;
				updateErr.add("�п�J���T�U���H��");
			}
			
			if(actLLimit>actULimit){
				updateErr.add("�U���H�Ƥ���W�V�W���H��");
			}
			
			Integer actKind = null;
			try {
				actKind = new Integer(req.getParameter("actKind").trim());
			} catch (Exception e) {
				updateErr.add("���ʺ���������~");
			}
			
			Integer actStatus = null;
			try {
				actStatus = Integer.parseInt(req.getParameter("actStatus").trim());
			} catch (Exception e) {
				updateErr.add("���ʪ��A���~");
			}
			
			byte[] actInitImg = null;
			Collection<Part> parts = req.getParts();
			
			try {
				for(Part part:parts){
					
					
					if(getFileNameFromPart(part)!=null && part.getName().equals("actInitImg")){
						
						actInitImg = getPictureByteArray(part.getInputStream());
						
					}
				}
			} catch (Exception e) {
				
				updateErr.add("�Ӥ����~");
			}
			
			
			
			String actAnotherKind = req.getParameter("actAnotherKind");
			
			if(!updateErr.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/activity/activityManagent.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			
			/////////////////////////��s�������/////////////////////////////
			ActivityService activityService = new ActivityService();
			Activity activity = activityService.updateActivity(actNo, restMemId, actName, actContent, actDate,
					actFDate, actStatus, actULimit, actLLimit, actKind, actAnotherKind, actInitImg);
			
			req.setAttribute("activity", activity);
			
			////////////////////////��s////////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/front_end/activity/activityManagent.jsp");
			requestDispatcher.forward(req, res);
			
		}
		
		
		else if("north".equals(action)){
			
			
			
			ActivityService activityService = new ActivityService();
			List<Activity> activityList = activityService.getAllByStatus(2);
			Set<String> restaurantSet = new TreeSet<>();
			
			
			for(Activity activity:activityList){
				
				RestMemberService restMemberService = new RestMemberService();
				RestMember restMember = restMemberService.getOneRestMember(activity.getRestMemId());
				
				RestaurantService restaurantService = new RestaurantService();
				Restaurant restaurant = restaurantService.getOneRest(restMember.getRestNo());
				
				restaurantSet.add(restaurant.getRestLocate());
				
			}
			
			Iterator<String> northSet = restaurantSet.iterator();
			System.out.println();
			while(northSet.hasNext()){
				System.out.println(northSet.next());
			}
			
			
		}
		
		
	}

}
