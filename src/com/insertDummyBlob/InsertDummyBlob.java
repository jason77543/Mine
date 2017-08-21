package com.insertDummyBlob;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.actImg.model.ActImg;
import com.actImg.model.ActImgJDBCDAO;
import com.activity.model.Activity;
import com.activity.model.ActivityJDBCDAO;
import com.ad.model.Ad;
import com.ad.model.AdJDBCDAO;
import com.album.model.Album;
import com.album.model.AlbumJDBCDAO;
import com.albumimg.model.AlbumImg;
import com.albumimg.model.AlbumImgJDBCDAO;
import com.dateitem.model.DateItemJDBCDAO;
import com.dateitem.model.DateItemVO;
import com.member.model.Member;
import com.member.model.MemberJDBCDAO;
import com.pet.model.Pet;
import com.pet.model.PetJDBCDAO;
import com.product.model.Product;
import com.product.model.ProductJDBCDAO;
import com.restImg.model.RestImg;
import com.restImg.model.RestImgJDBCDAO;
import com.slide.model.Slide;
import com.slide.model.SlideJDBCDAO;

public class InsertDummyBlob {
	static int fixed_width=400;
	static int fixed_height=300;
	
	
	public static void main(String[] args) {


	// �|���Ӥ��ק�
//	int i=5001;
//    for (File file : new File("WebContent/DummyImg/member").listFiles()) { 
//    	MemberJDBCDAO dao=new MemberJDBCDAO();
//        Member member=dao.findByPk(i++);
//        try {
//        	byte[] b = getPictureByteArrayNoChangeSize(file);
//			member.setMemImg(b);
//			dao.update(member);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}    
//    }
//    System.out.println("=============�|���s�W����================");

    //�ק��d���Ӥ�
	int p=1001;
    for (File file : new File("WebContent/DummyImg/pet").listFiles()) { 
    	
    	PetJDBCDAO dao=new PetJDBCDAO();
    	Pet pet=dao.findByPk(p++);
        try {
			byte[] b = getPictureByteArray(file);
			pet.setPetImg(b);
			dao.update(pet);
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
    System.out.println("=============�d���s�W����================");
    
  //�ק��ï�Ӥ�
	int a=1;
    for (File file : new File("WebContent/DummyImg/album").listFiles()) { 
    	AlbumJDBCDAO dao=new AlbumJDBCDAO();
        Album album=dao.findByPk(a++);
        try {
			byte[] b = getPictureByteArray(file);
			album.setAlbumImgFile(b);;
			dao.update(album);
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
    System.out.println("=============��ï�s�W����================");
    
  //�ק�Ӥ�(table)���Ӥ����
	int ai=1;
    for (File file : new File("WebContent/DummyImg/albumimg").listFiles()) { 
    	AlbumImgJDBCDAO dao=new AlbumImgJDBCDAO();
    	AlbumImg albumImg=dao.findByPk(ai++);
        try {
			byte[] b = getPictureByteArray(file);
			albumImg.setImgFile(b);;
			dao.update(albumImg);
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
    System.out.println("=============��ï�s�W����================");
//    
	//�ӫ~�Ӥ��ק�
	int pro=2001;
    for (File file : new File("WebContent/DummyImg/product").listFiles()) { 
    	ProductJDBCDAO dao=new ProductJDBCDAO();
        Product product=dao.findByPk(pro++);
        try {
			byte[] b = getPictureByteArray(file);
			product.setProdImg(b);
			dao.update(product);
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
    System.out.println("=============�ӫ~�s�W����================");
    
    
	    
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type,int fixed_width,int fixed_height ){
		BufferedImage resizedImage = new BufferedImage(fixed_width, fixed_height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, fixed_width, fixed_height, null);
		g.dispose();

		return resizedImage;
	    }
	
	
	public static byte[] getPictureByteArray(File file) throws IOException {
		BufferedImage originalImage = ImageIO.read(file);
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizeImageJpg = resizeImage(originalImage, type,fixed_width,fixed_height);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( resizeImageJpg, "jpg", baos );
		baos.flush();
		baos.close();

		return baos.toByteArray();
	}
	
	public static byte[] getPictureByteArrayNoChangeSize(File file) throws IOException {
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
	
	
	public static byte[] getPictureByteArrayForMemberAndDateItem(File file) throws IOException {
		BufferedImage originalImage = ImageIO.read(file);
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizeImageJpg = resizeImage(originalImage, type,300,300);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( resizeImageJpg, "jpg", baos );
		baos.flush();
		baos.close();

		return baos.toByteArray();
	}
	
}
