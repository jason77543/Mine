package activity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import oracle.net.aso.a;

public class ActivityJDBCDAO implements ActivityDAO_Interface{
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "huang";
	String passwd = "g122003744";
	
	private static final String INSERT_ACTIVITY = "INSERT INTO ACTIVITY (ACTNO,RESTID,ACTNAME,ACTCONTENT,ACTDATE,ACTFDATE,"
											+ "ACTSTATUS,ACTULIMIT,ACTLLIMIT,ACTKIND,ACTANOTHERKIND,ACTIMG)"
											+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)" ;
	private static final String UPDATE_ACTIVITY = "UPDATE ACTIVITY SET RESTID=?,ACTNAME=?,ACTCONTENT=?,ACTDATE=?,ACTFDATE=?,"
											+ "ACTSTATUS=?,ACTULIMIT=?,ACTLLIMIT=?,ACTKIND=?,ACTANOTHERKIND=?,ACTIMG=? WHERE ACTNO=?";
	private static final String DELETE_ACTIVITY = "DELETE FROM ACTIVITY WHERE ACTNO=?" ;
	private static final String FIND_BY_PK = "SELECT * FROM ACTIVITY WHERE ACTNO=?" ;
	private static final String GET_ALL = "SELECT * FROM ACTIVITY" ;
	
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
			pstmt.setBytes(12, activity.getActImg());
			
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
		
	}


	@Override
	public void delete(Integer actNo) {
		
	}


	@Override
	public Activity findByPK(Integer actNo) {
		return null;
	}


	@Override
	public List<Activity> getAll() {
		return null;
	}
	
	
	public static void main(String[] args) {
		
	}


	

}
