package com.activity.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.activity.model.Activity;
import com.activity.model.ActivityService;


@WebServlet("/activityServlet")
public class activityServlet extends HttpServlet {
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
       
    //Pattern.compile("[\\p{InCJKUnifiedIdeographs}]"); //只允許中文
	//Pattern.compile("[^\\x00-\\x40\\x5B-\\x60\\x7B-\\x7F]"); //只允許英文字母以及中文
    public activityServlet() {
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
				activityError.add("活動狀態錯誤");
			}
			
			String actName = req.getParameter("actName");
			String meg = "^[\\w\u4E00-\u9FFF]{0,30}";
			
			if(actName==null || (actName.trim()).length()==0 ){
				activityError.add("請輸入活動名稱");
			}
			else if(!actName.trim().matches(meg)){
				activityError.add("請輸入中、英文、數字或是_，長度最大為30字");
			}
			
			String actContent = req.getParameter("actContent");
			String meg1 = "^[\\w\u4E00-\u9FFF]{0,250}";
			
			if(actContent==null||(actContent.trim()).length()==0){
				activityError.add("請輸入活動內容");
			}
			else if(!actContent.trim().matches(meg1)){
				activityError.add("請輸入中、英文、數字或是_，長度最大為250字");
			}
			
			java.sql.Date actDate = null;
			try {
				actDate = java.sql.Date.valueOf(req.getParameter("actDate").trim());
			} catch (Exception e) {
				actDate = new java.sql.Date(System.currentTimeMillis());
				activityError.add("請輸入活動日期");
			}
			
			java.sql.Date actFDate = null;
			try {
				actFDate = java.sql.Date.valueOf(req.getParameter("actFDate").trim());
			} catch (Exception e) {
				actFDate = new java.sql.Date(System.currentTimeMillis());
				activityError.add("請輸入截止日期");
			}
			
			Integer actULimit = null;
			try {
				actULimit = Integer.parseInt(req.getParameter("actULimit").trim());
			} catch (Exception e) {
				actULimit = 0 ;
				activityError.add("請輸入正確人數");
			}
			
			Integer actLLimit = null;
			try {
				actLLimit = Integer.parseInt(req.getParameter("actLLimit").trim());
			} catch (Exception e) {
				actLLimit = 0 ;
				activityError.add("請輸入正確人數");
			}
			
			if(actLLimit>actULimit){
				activityError.add("下限人數不能超越上限人數");
			}
			
			Integer actKind = null;
			try {
				actKind = new Integer(req.getParameter("actKind").trim());
			} catch (Exception e) {
				activityError.add("活動種類限制錯誤");
			}
			
			String actAnotherKind = req.getParameter("actAnotherKind");
			
			byte[] actInitImg =null;
			Collection<Part> parts = req.getParts();
			try {
				for(Part part :parts){
					if(getFileNameFromPart(part)==null || part.getContentType().startsWith("image")){
						actInitImg = getPictureByteArray(part.getInputStream());
						System.out.println("000000");
					}
				}
			} catch (Exception e) {
				activityError.add("照片錯誤");
			}
				
			
			if(!activityError.isEmpty()){
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/activity/newActivity.jsp");
				requestDispatcher.forward(req, res);
				return;
			}
			
			
			/////////////////////////新增活動/////////////////////////////
			ActivityService activityService = new ActivityService();
			Activity activity = activityService.addActivity(restMemId, actName, actContent,
					actDate, actFDate, actStatus, actULimit, actLLimit, actKind, actAnotherKind, actInitImg);
			
			req.setAttribute("activity", activity);
			
			////////////////////////轉存////////////////////////////////
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/restMember/restMember.jsp");
			requestDispatcher.forward(req, res);
		}
		
		
		
	}

}
