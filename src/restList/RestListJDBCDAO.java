package restList;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import restImg.RestImg;

public class RestListJDBCDAO implements RestListDAO_Interface {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "huang";
	String passwd = "g122003744";

	private static final String INSERT_RESTLIST = "INSERT INTO RESTLIST (RESTLISTNO,RESTLISTNAME,RESTLISTADD,RESTLISTPHONE,"
			+ "RESTLISTINTRO,RESTLISTKIND) " + "VALUES(?,?,?,?,?,?)";
	private static final String UPDATE_RESTLIST = "UPDATE RESTLIST SET RESTLISTNAME=?,RESTLISTADD=?,RESTLISTPHONE=?"
			+ ",RESTLISTINTRO=?,RESTLISTKIND=?,RESTLISTIMG=? WHERE RESTLISTNO=?";
	private static final String DELETE_RESTLIST = "DELETE FROM RESTLIST WHERE RESTLISTNO=?";
	private static final String FIND_BY_PK = "SELECT * FROM RESTLIST WHERE RESTLISTNO=?";
	private static final String GET_ALL = "SELECT * FROM RESTLIST";

	@Override
	public void add(RestList restList) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			

			pstmt = conn.prepareStatement(INSERT_RESTLIST);
			pstmt.setInt(1, restList.getRestListNo());
			pstmt.setString(2, restList.getRestListName());
			pstmt.setString(3, restList.getRestListAdd());
			pstmt.setString(4, restList.getRestListPhone());
			pstmt.setString(5, restList.getRestListIntro());
			pstmt.setInt(6, restList.getRestListKind());

			

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
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
	public void update(RestList restList) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(UPDATE_RESTLIST);

			pstmt.setString(1, restList.getRestListName());
			pstmt.setString(2, restList.getRestListAdd());
			pstmt.setString(3, restList.getRestListPhone());
			pstmt.setString(4, restList.getRestListIntro());
			pstmt.setInt(5, restList.getRestListKind());

			Blob blob = conn.createBlob();
			blob.setBytes(1, restList.getRestListImg());
			pstmt.setBlob(6, blob);

			pstmt.setInt(7, restList.getRestListNo());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
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
	public void delete(Integer restListNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(DELETE_RESTLIST);
			pstmt.setInt(1, restListNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
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
	public RestList findByPK(Integer restListNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RestList restList = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, restListNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				restList = new RestList();
				restList.setRestListNo(rs.getInt("RESTLISTNO"));
				restList.setRestListName(rs.getString("RESTLISTNAME"));
				restList.setRestListAdd(rs.getString("RESTLISTADD"));
				restList.setRestListPhone(rs.getString("RESTLISTPHONE"));
				restList.setRestListIntro(rs.getString("RESTLISTINTRO"));
				restList.setRestListKind(rs.getInt("RESTLISTKIND"));
				restList.setRestListImg(rs.getBytes("RESTLISTIMG"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return restList;
	}

	@Override
	public List<RestList> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RestList restList = null;
		List<RestList> restListAll = new ArrayList<RestList>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				restList = new RestList();
				restList.setRestListNo(rs.getInt("RESTLISTNO"));
				restList.setRestListName(rs.getString("RESTLISTNAME"));
				restList.setRestListAdd(rs.getString("RESTLISTADD"));
				restList.setRestListPhone(rs.getString("RESTLISTPHONE"));
				restList.setRestListIntro(rs.getString("RESTLISTINTRO"));
				restList.setRestListKind(rs.getInt("RESTLISTKIND"));
				restList.setRestListImg(rs.getBytes("RESTLISTIMG"));
				restListAll.add(restList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return restListAll;
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

	public static void main(String[] args) throws IOException {
		RestListJDBCDAO restListJDBCDAO = new RestListJDBCDAO();
		
		RestList restList = new RestList();
//		restList.setRestListNo(4);
//		restList.setRestListName("い胐把");
//		restList.setRestListAdd("いァ厩");
//		restList.setRestListPhone("03-9999");
//		restList.setRestListIntro("代刚ノ");
//		restList.setRestListKind(1);	
//		byte[]	restImg = getPictureByteArray("C:\\BA102_WebApp\\eclipse_WTP_WorkSpace\\Huang\\WebContent\\img\\1.jpg");
//		restList.setRestListImg(restImg);
//		restListJDBCDAO.add(restList);
		
		
//		restList.setRestListNo(1);
//		restList.setRestListName("い胐把1111");
//		restList.setRestListAdd("いァ厩111");
//		restList.setRestListPhone("03-9999111");
//		restList.setRestListIntro("代刚ノ111");
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
