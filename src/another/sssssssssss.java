package another;
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

		
public class sssssssssss {
		public static void main(String[] args) {


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
			
			public static byte[] getPictureByteArray(File file) throws IOException {
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


