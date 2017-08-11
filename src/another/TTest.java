package another;
import java.awt.Button;
import java.awt.Event.*;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.actImg.model.ActImg;
import com.actImg.model.ActImgJDBCDAO;
import com.activity.model.Activity;
import com.activity.model.ActivityDAO;
import com.activity.model.ActivityJDBCDAO;
import com.restImg.model.RestImg;
import com.restImg.model.RestImgDAO;
import com.restImg.model.RestImgJDBCDAO;

import javafx.scene.control.DialogEvent;

		
public class TTest {
	
		public static void main(String[] args) throws IOException, JSONException {
			
			String sKeyWord = "�x������ٰϼy�M��92��"; //�o�O�a�}
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
		                  
		            System.out.println((ja.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat")));
		            System.out.println((ja.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng")));
		            
			    } 
			}
			
}

	


