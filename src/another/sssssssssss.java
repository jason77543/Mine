package another;
import java.awt.Button;
import java.awt.Event.*;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.actImg.model.ActImg;
import com.actImg.model.ActImgJDBCDAO;
import com.activity.model.Activity;
import com.activity.model.ActivityDAO;
import com.activity.model.ActivityJDBCDAO;
import com.restImg.model.RestImg;
import com.restImg.model.RestImgDAO;
import com.restImg.model.RestImgJDBCDAO;

import javafx.scene.control.DialogEvent;

		
public class sssssssssss {
	private static Dialog d;
		public static void main(String[] args) {
			
			Frame window = new Frame();

			// Create a modal dialog
			d = new Dialog(window, "Alert", true);

			// Use a flow layout
			d.setLayout( new FlowLayout() );

			// Create an OK button
			Button ok = new Button ("OK");
			ok.addActionListener ( new ActionListener()
			{
				public void actionPerformed( ActionEvent e )
				{
					// Hide dialog
					sssssssssss.d.setVisible(false);
				}
			});
			
			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

			d.add( new Label ("Click OK to continue"));
			d.add( ok );

			// Show dialog
			d.pack();
			d.setVisible(true);
			System.exit(0);
			
			
//			String ss = "abcdefgh";
//			String sss = ss.substring(0, 2);
//			System.out.println(sss);
			// 餐廳會員照片修改
//			int i = 7001;
//		    for (File file : new File("WebContent/DummyImg/restImg").listFiles()) { 
//		    	RestImgJDBCDAO restImgJDBCDAO=new RestImgJDBCDAO();
//		        RestImg restImg=restImgJDBCDAO.findByPK(i++);
//		        try {
//					byte[] b = getPictureByteArray(file);
//					restImg.setRestImg(b);
//					restImgJDBCDAO.update(restImg);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}    
//		    }
//		    System.out.println("=============餐廳會員照片新增完畢================");

//		    int j = 8001;
//		    for (File file : new File("WebContent/DummyImg/activityInitImg").listFiles()) { 
//		    	ActivityJDBCDAO activityDAO=new ActivityJDBCDAO();
//		        Activity activity=activityDAO.findByPK(j++);
//		        try {
//					byte[] b = getPictureByteArray(file);
//					activity.setActInitImg(b);
//					activityDAO.update(activity);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}    
//		    }
//		    System.out.println("=============餐廳會員照片新增完畢================");
//
//		}
			
//		    int k = 8001;
//		    for (File file : new File("WebContent/DummyImg/actImg").listFiles()) { 
//		    	ActImgJDBCDAO actImgJDBCDAO=new ActImgJDBCDAO();
//		    	ActImg actImg=actImgJDBCDAO.findByPK(k++);
//		        try {
//					byte[] b = getPictureByteArray(file);
//					actImg.setActImg(b);
//					actImgJDBCDAO.update(actImg);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}    
//		    }
//		    System.out.println("=============餐廳會員照片新增完畢================");

		}	
		
		
			
//			public static byte[] getPictureByteArray(File file) throws IOException {
//				FileInputStream fis = new FileInputStream(file);
//				ByteArrayOutputStream baos = new ByteArrayOutputStream();
//				byte[] buffer = new byte[8192];
//				int i;
//				while ((i = fis.read(buffer)) != -1) {
//					baos.write(buffer, 0, i);
//				}
//				baos.close();
//				fis.close();
//
//				return baos.toByteArray();
//			}
			
		

	}


