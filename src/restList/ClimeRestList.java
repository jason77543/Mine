package restList;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


@WebServlet("/ClimeRestList")
public class ClimeRestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static BufferedReader reader;
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new javax.naming.InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_RESTLIST_STMT = "INSERT INTO RESTLIST(RESTLISTNO,RESTLISTNAME,RESTLISTADD,RESTLISTPHONE,RESTLISTINTRO,RESTLISTKIND,RESTLISTIMG,RESTLISTRECCSTATUS)"
			+ "VALUES(RESTLIST_SEQ.NEXTVAL,?, ?, ?, ?, ?, ?,?)"; 
	Connection conn;
	PreparedStatement pstmt;
	List<String> list =  new ArrayList<String>();;
	List<String> list1=  new ArrayList<String>();;
	List<String> list2=  new ArrayList<String>();;
    
    public ClimeRestList() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			URL url = new URL("http://tinyurl.com/3bp8zf7");
					
			Document xmlDoc = Jsoup.parse(url, 3000);

			conn = ds.getConnection();
			

			FileWriter writer = new FileWriter("D://restname.csv");

			Elements tr = xmlDoc.select("tr");
			for (int i = 2; i < 85; i++) {
				String rest = (String) tr.get(i).text();
				writer.write(rest);
			}
			writer.close();

			reader = new BufferedReader(new FileReader("D://restname.csv"));
			String name = reader.readLine().replaceAll("[?]", "");
			String name0 = name.replace("(�۫~���s����)", "�۫~���s����-");
			String name1 = name0.replace("(�Ȧ̶����d���ͬ��])", "�Ȧ̶����d���ͬ��]-");
			String name2 = name1.replace("0931-331220", "(03)955-6783");
			String name3 = name2.replace("(", ",(");
			String name4 = name3.replace("��26", "��26��");
			String name5 = name4.replace("�G�q806", "�G�q806��");
			String name6 = name5.replace("��", "��,");
			String name7 = name6.replace("1F", "");
			String name8 = name7.replace("2F", "");
			String name9 = name8.replace("��1", "");
			String name10 = name9.replace("2��", "");
			String name11 = name10.replace("�\ �U �W �q �� �a �}", "");
			String name12 = name11.replace("�x", ",�x");
			String name13 = name12.replace("�]", ",�]");
			String name14 = name13.replace("�s��", ",�s��");
			String name15 = name14.replace("���", ",���");

			FileWriter writer1 = new FileWriter("D://Trestname.csv");
			writer1.write(name15);
			writer1.close();

			String[] name16 = name15.split(",");

			Blob blob = conn.createBlob();
			byte[] restImg = getPictureByteArray("C:\\BA102_WebApp\\eclipse_WTP_WorkSpace\\Huang\\WebContent\\img\\1.jpg");
			blob.setBytes(1, restImg);
			
			for (int j = 0; j < name16.length; j++) {
				if (j % 3 == 0) {
					list.add(name16[j]);
				} else if (j % 3 == 1) {
					list1.add(name16[j]);
				} else {
					list2.add(name16[j]);
				}
			}
			Iterator<String> itr = list.iterator();
			Iterator<String> itr1 = list1.iterator();
			Iterator<String> itr2 = list2.iterator();
			
			String[] cols = { "RESTLISTNO" };
			
			
			for (int k = 0; k < 77; k++) {
				pstmt = conn.prepareStatement(INSERT_RESTLIST_STMT, cols);
				int kindOfPet = (int) (Math.random() * 3);
				pstmt.setString(1,itr.next());
				pstmt.setString(2,itr1.next());
				pstmt.setString(3,itr2.next());
				pstmt.setString(4, "petRestaurant");
				pstmt.setInt(5, kindOfPet);
				pstmt.setBlob(6, blob);
				pstmt.setInt(7, k);
				pstmt.executeUpdate();
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
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
