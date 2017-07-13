package restImg;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class RestImgJDBCDAO implements RestImgDAO_interface{

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "huang";
	String passwd = "g122003744";

	private static final String INSERT_RESTIMG = "INSERT INTO RESTIMG(RESTIMGNO,RESTID,RESTIMGNAME,RESTIMGINTRO)"
			+ "VALUES(?,?, ?, ?)";
	private static final String UPDATE_RESTIMG = "UPDATE RESTIMG SET RESTID=?,RESTIMGNAME=?,RESTIMGINTRO=? WHERE RESTIMGNO=?";	
	private static final String DELETE_RESTIMG = "DELETE FROM RESTIMG WHERE RESTIMGNO=?";
	private static final String FIND_BY_PK = "SELECT * FROM RESTIMG WHERE RESTIMGNO = ?";
	private static final String GET_ALL = "SELECT * FROM RESTIMG";

	@Override
	public void add(RestImg restImg) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = conn.prepareStatement(INSERT_RESTIMG);
			pstmt.setInt(1, restImg.getRestImgNo());
			pstmt.setString(2, restImg.getRestId());
			pstmt.setString(3, restImg.getRestImgName());
			pstmt.setString(4, restImg.getRestImgIntro());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	@Override
	public void update(RestImg restImg) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {	
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = conn.prepareStatement(UPDATE_RESTIMG);
			pstmt.setString(1, restImg.getRestId());
			pstmt.setString(2, restImg.getRestImgName());
			pstmt.setString(3, restImg.getRestImgIntro());
			pstmt.setInt(4, restImg.getRestImgNo());
			pstmt.executeUpdate();
			
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

	@Override
	public void delete(Integer restImgNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {	
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(DELETE_RESTIMG);
			pstmt.setInt(1, restImgNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.getMessage();
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

	@Override
	public RestImg findByPK(Integer restImgNo) {
		RestImg restImg = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, restImgNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				restImg = new RestImg();
				restImg.setRestId(rs.getString("RESTID"));
				restImg.setRestImgNo(rs.getInt("RESTIMGNO"));
				restImg.setRestImgName(rs.getString("RESTIMGNAME"));
				restImg.setRestImgIntro(rs.getString("RESTIMGINTRO"));
			}
		} catch (Exception e){
			e.getMessage();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		return restImg;
	}

	@Override
	public List<RestImg> getAll() {
		List<RestImg> restImgList = new ArrayList<RestImg>();
		RestImg restImg = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				restImg = new RestImg();
				restImg.setRestId(rs.getString("RESTID"));
				restImg.setRestImgNo(rs.getInt("RESTIMGNO"));
				restImg.setRestImgName(rs.getString("RESTIMGNAME"));
				restImg.setRestImgIntro(rs.getString("RESTIMGINTRO"));
				restImgList.add(restImg);
			}
		} catch (Exception e){
			e.getMessage();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		
		return restImgList;
	}

	
	

	public static void main(String[] args) throws IOException {
		RestImgJDBCDAO restImgJDBCDAO = new RestImgJDBCDAO();
		
		RestImg restImg = new RestImg();
		restImg.setRestImgNo(3);
		restImg.setRestId("AAA");
		restImg.setRestImgName("我是相片名稱");
		restImg.setRestImgIntro("我是寵物餐廳相片");
		restImgJDBCDAO.add(restImg);
		
//		restList.setRestListNo(1);
//		restList.setRestListName("中大寵參1111");
//		restList.setRestListAdd("中央大學111");
//		restList.setRestListPhone("03-9999111");
//		restList.setRestListIntro("測試用111");
//		restList.setRestListKind(11111);	
//		byte[]	restImg = getPictureByteArray("C:\\BA102_WebApp\\eclipse_WTP_WorkSpace\\Huang\\WebContent\\img\\1.jpg");
//		restList.setRestListImg(restImg);
//		restListJDBCDAO.update(restList);
		
//		restListJDBCDAO.delete(1);
		
//		restList = restListJDBCDAO.findByPK(1);
//		System.out.println(restList.getRestListNo());
//		System.out.println(restList.getRestListName());
//		System.out.println(restList.getRestListAdd());
//		System.out.println(restList.getRestListPhone());
//		System.out.println(restList.getRestListIntro());
//		System.out.println(restList.getRestListKind());
		
//		List<RestList> RestList = restListJDBCDAO.getAll();
//		for(RestList restListE : RestList){
//			System.out.println(restListE.getRestListNo());
//			System.out.println(restListE.getRestListName());
//			System.out.println(restListE.getRestListAdd());
//			System.out.println(restListE.getRestListPhone());
//			System.out.println(restListE.getRestListIntro());
//			System.out.println(restListE.getRestListKind());
//		}
	}


}
