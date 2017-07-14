package activity;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.a;

public class ActivityJDBCDAO implements ActivityDAO_Interface{
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "huang";
	String passwd = "g122003744";
	
	private static final String INSERT_ACTIVITY = "INSERT INTO ACTIVITY (ACTNO,RESTID,ACTNAME,ACTCONTENT,ACTDATE,ACTFDATE,"
			+ "ACTSTATUS,ACTULIMIT,ACTLLIMIT,ACTKIND,ACTANOTHERKIND,ACTINITIMG)"
			+ "VALUES(ACTIVITY_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_ACTIVITY = "UPDATE ACTIVITY SET RESTID=?,ACTNAME=?,ACTCONTENT=?,ACTDATE=?"
			+ ",ACTFDATE=?,ACTSTATUS=?,ACTULIMIT=?,ACTLLIMIT=?,ACTKIND=?,ACTANOTHERKIND=?,ACTINITIMG=? WHERE ACTNO=?";
	private static final String DELETE_ACTIVITY = "DELETE FROM ACTIVITY WHERE ACTNO=?";
	private static final String FIND_BY_PK = "SELECT * FROM ACTIVITY WHERE ACTNO=?";
	private static final String GET_ALL = "SELECT * FROM ACTIVITY";
	
	@Override
	public void add(Activity activity) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = conn.prepareStatement(INSERT_ACTIVITY);
			pstmt.setInt(1, activity.getActNo());
			pstmt.setString(2, activity.getRestId());
			pstmt.setString(3, activity.getActName());
			pstmt.setString(4,activity.getActContent());
			pstmt.setDate(5, activity.getActDate());
			pstmt.setDate(6, activity.getActFDate());
			pstmt.setInt(7, activity.getActStatus());
			pstmt.setInt(8, activity.getActULimit());
			pstmt.setInt(9, activity.getActLLimit());
			pstmt.setInt(10, activity.getActKind());
			pstmt.setString(11, activity.getActAnotherKind());
			Blob blob = conn.createBlob();
			blob.setBytes(1, activity.getActInitImg());
			pstmt.setBlob(12, blob);
			
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
	public void update(Activity activity) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = conn.prepareStatement(UPDATE_ACTIVITY);
			pstmt.setString(1, activity.getRestId());
			pstmt.setString(2, activity.getActName());
			pstmt.setString(3, activity.getActContent());
			pstmt.setDate(4, activity.getActDate());
			pstmt.setDate(5, activity.getActFDate());
			pstmt.setInt(6, activity.getActStatus());
			pstmt.setInt(7, activity.getActULimit());
			pstmt.setInt(8, activity.getActLLimit());
			pstmt.setInt(9, activity.getActKind());
			
			Blob blob = conn.createBlob();
			blob.setBytes(1, activity.getActInitImg());
			pstmt.setBlob(10, blob);
			pstmt.setString(11, activity.getActAnotherKind());
			pstmt.setInt(12, activity.getActNo());
			
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
	public void delete(Integer actNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = conn.prepareStatement(DELETE_ACTIVITY);
			pstmt.setInt(1, actNo);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
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
	public Activity findByPK(Integer actNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Activity activity = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = conn.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, actNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				activity = new Activity();
				activity.setActNo(rs.getInt("ACTNO"));
				activity.setRestId(rs.getString("RESTID"));
				activity.setActName(rs.getString("ACTNAME"));
				activity.setActContent(rs.getString("ACTCONTENT"));
				activity.setActDate(rs.getDate("ACTDATE"));
				activity.setActFDate(rs.getDate("ACTFDATE"));
				activity.setActStatus(rs.getInt("ACTSTATUS"));
				activity.setActULimit(rs.getInt("ACTULIMIT"));
				activity.setActLLimit(rs.getInt("ACTLLIMIT"));
				activity.setActKind(rs.getInt("ACTKIND"));
				activity.setActAnotherKind(rs.getString("ACTANOTHERKIND"));
				activity.setActInitImg(rs.getBytes("ACTINITIMG"));
			}
		} catch (Exception e) {
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
		return activity;
	}


	@Override
	public List<Activity> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Activity activity = null;
		ResultSet rs = null;
		List<Activity> activityList = new ArrayList<Activity>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = conn.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				activity = new Activity();
				activity.setActNo(rs.getInt("ACTNO"));
				activity.setRestId(rs.getString("RESTID"));
				activity.setActName(rs.getString("ACTNAME"));
				activity.setActContent(rs.getString("ACTCONTENT"));
				activity.setActDate(rs.getDate("ACTDATE"));
				activity.setActFDate(rs.getDate("ACTFDATE"));
				activity.setActStatus(rs.getInt("ACTSTATUS"));
				activity.setActULimit(rs.getInt("ACTULIMIT"));
				activity.setActLLimit(rs.getInt("ACTLLIMIT"));
				activity.setActKind(rs.getInt("ACTKIND"));
				activity.setActAnotherKind(rs.getString("ACTANOTHERKIND"));
				activity.setActInitImg(rs.getBytes("ACTINITIMG"));
				activityList.add(activity);
			}
		} catch (Exception e) {
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
		return activityList;
	}
	
	
	
	public static void main(String[] args) {
		
	}


	

}
