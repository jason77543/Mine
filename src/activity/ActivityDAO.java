package activity;


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



public class ActivityDAO implements ActivityDAO_Interface{
	
	private static DataSource ds = null;
	static{
		try {
			Context ctx = new javax.naming.InitialContext();
			ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_ACTIVITY = "INSERT INTO ACTIVITY (ACTNO,RESTID,ACTNAME,ACTCONTENT,ACTDATE,ACTFDATE,"
											+ "ACTSTATUS,ACTULIMIT,ACTLLIMIT,ACTKIND,ACTIMG)"
											+ "VALUES(ACTIVITY_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_ACTIVITY = "UPDATE ACTIVITY SET RESTID=?,ACTNAME=?,ACTCONTENT=?,ACTDATE=?"
											+ ",ACTFDATE=?,ACTSTATUS=?,ACTULIMIT=?,ACTLLIMIT=?,ACTKIND=?,ACTIMG=? WHERE ACTNO=?";
	private static final String DELETE_ACTIVITY = "DELETE FROM ACTIVITY WHERE ACTNO=?";
	private static final String FIND_BY_PK = "SELECT * FROM ACTIVITY WHERE ACTNO=?";
	private static final String GET_ALL = "SELECT * FROM ACTIVITY";
	
	
	@Override
	public void add(Activity activity) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			String[] cols = {"ACTNO"};
			pstmt = conn.prepareStatement(INSERT_ACTIVITY,cols);
			pstmt.setString(1, activity.getRestId());
			pstmt.setString(2, activity.getActName());
			pstmt.setString(3, activity.getActContent());
			pstmt.setDate(4, activity.getActDate());
			pstmt.setDate(5, activity.getActFDate());
			pstmt.setInt(6, activity.getActStatus());
			pstmt.setInt(7, activity.getActULimit());
			pstmt.setInt(8, activity.getActLLimit());
			pstmt.setString(9, activity.getActKind());
			
			Blob blob = conn.createBlob();
			blob.setBytes(1, activity.getActImg());
			pstmt.setBlob(10, blob);
			
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
	public void update(Activity activity) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(UPDATE_ACTIVITY);
			pstmt.setString(1, activity.getRestId());
			pstmt.setString(2, activity.getActName());
			pstmt.setString(3, activity.getActContent());
			pstmt.setDate(4, activity.getActDate());
			pstmt.setDate(5, activity.getActFDate());
			pstmt.setInt(6, activity.getActStatus());
			pstmt.setInt(7, activity.getActULimit());
			pstmt.setInt(8, activity.getActLLimit());
			pstmt.setString(9, activity.getActKind());
			
			Blob blob = conn.createBlob();
			blob.setBytes(1, activity.getActImg());
			pstmt.setBlob(10, blob);
			
			pstmt.setInt(11, activity.getActNo());
			
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
	public void delete(Integer actNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(DELETE_ACTIVITY);
			pstmt.setInt(1, actNo);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
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
			conn = ds.getConnection();
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
				activity.setActKind(rs.getString("ACTKIND"));
				activity.setActImg(rs.getBytes("ACTIMG"));
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
			conn = ds.getConnection();
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
				activity.setActKind(rs.getString("ACTKIND"));
				activity.setActImg(rs.getBytes("ACTIMG"));
				activityList.add(activity);
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
		return activityList;
	}

}
