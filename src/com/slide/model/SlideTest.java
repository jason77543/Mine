package com.slide.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class SlideTest {

	public static void main(String[] args) throws IOException {
		SlideJDBCDAO dao = new SlideJDBCDAO();

//		 ?°å¢?
		Slide slide1 = new Slide();
		byte[] slideImg = getPictureByteArray("C:\\Users\\Phate\\Downloads\\IMG_4099.jpg");
		slide1.setSlideImg(slideImg);
		slide1.setSlideCategory("?æ¯?§?é?å¥");
		slide1.setSlideTitle("?æ¯?§?æ¬? ­");
		dao.insert(slide1);
		System.out.println("?°å¢å?æ¹");

//		 ä¿®æ¹
//		Slide slide2 = new Slide();
//		byte[] slideImg = getPictureByteArray("C:\\Users\\Phate\\Downloads\\IMG_4099.jpg");
//		slide2.setSlideImg(slideImg);
//		slide2.setSlideCategory("??å½±??ç?é?å¥");
//		slide2.setSlideTitle("??å½±??ç?æ¬? ­");
//		slide2.setSlideNo(1);
//		dao.update(slide2);
//		System.out.println("ä¿®æ¹å®æ¹");

//		 ?ª?¤
//		dao.delete(3);
//		System.out.println("?ª??æ¹,ç³ç??");

//		 ?¥è©?
//		Slide slide3 = dao.findByPrimaryKey(4);
//		System.out.println(slide3.getSlideNo());
//		System.out.println(slide3.getSlideImg());
//		System.out.println(slide3.getSlideCategory());
//		System.out.println(slide3.getSlideTitle());
//		System.out.println("?¾å®æ¹");

//		 ?¥?¨?¨
//		 List<Slide> slideList=dao.getAll();
//		 for(Slide slide : slideList){
//		 System.out.println(slide.getSlideNo());
//		 System.out.println(slide.getSlideImg());
//		 System.out.println(slide.getSlideCategory());
//		 System.out.println(slide.getSlideTitle());
//		 System.out.println("===================");
//		 }

	}
	
	// ä½¿ç¨byte[]?¹å¼?
		public static byte[] getPictureByteArray(String path) throws IOException {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[8192];
			int i;
			while ((i = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, i);
			}
			baos.close();
			fis.close();

			return baos.toByteArray();
		}

}