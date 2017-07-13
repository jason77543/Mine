package restList;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class RestListDAO implements RestListDAO_Interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new javax.naming.InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static final String INSERT_RESTLIST = "INSERT INTO RESTLIST (RESTLISTNO,RESTLISTNAME,RESTLISTADD,RESTLISTPHONE,"
												+ "RESTLISTINTRO,RESTLISTKIND,RESTLISTIMG)" + "VALUES(RESTLIST_SEQ.NEXTVAL,?,?,?,?,?,?)";
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
			conn = ds.getConnection();
			String[] cols = {"RESTLISTNO"};
			
			pstmt = conn.prepareStatement(INSERT_RESTLIST,cols);
			pstmt.setString(1, restList.getRestListName());
			pstmt.setString(2, restList.getRestListAdd());
			pstmt.setString(3, restList.getRestListPhone());
			pstmt.setString(4, restList.getRestListIntro());
			pstmt.setInt(5, restList.getRestListKind());
			
			Blob blob = conn.createBlob();
			blob.setBytes(1, restList.getRestListImg());
			pstmt.setBlob(6, blob);
			
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
	public void update(RestList restList) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = ds.getConnection();
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
		} catch (SQLException e) {
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
	public void delete(Integer restListNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(DELETE_RESTLIST);
			pstmt.setInt(1, restListNo);
			pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
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
	public RestList findByPK(Integer restListNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RestList restList = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, restListNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				restList = new RestList();
				restList.setRestListNo(rs.getInt("RESTLISTNO"));
				restList.setRestListName(rs.getString("RESTLISTNAME"));
				restList.setRestListAdd(rs.getString("RESTLISTADD"));
				restList.setRestListPhone(rs.getString("RESTLISTPHONE"));
				restList.setRestListIntro(rs.getString("RESTLISTINTRO"));
				restList.setRestListKind(rs.getInt("RESTLISTKIND"));
				restList.setRestListImg(rs.getBytes("RESTLISTIMG"));
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return restList;
	}

	@Override
	public List<RestList> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RestList restList = null;
		List<RestList> RestList = new ArrayList<RestList>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				restList = new RestList();
				restList.setRestListNo(rs.getInt("RESTLISTNO"));
				restList.setRestListName(rs.getString("RESTLISTNAME"));
				restList.setRestListAdd(rs.getString("RESTLISTADD"));
				restList.setRestListPhone(rs.getString("RESTLISTPHONE"));
				restList.setRestListIntro(rs.getString("RESTLISTINTRO"));
				restList.setRestListKind(rs.getInt("RESTLISTKIND"));
				restList.setRestListImg(rs.getBytes("RESTLISTIMG"));
				RestList.add(restList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return RestList;
	}
	
	

}






