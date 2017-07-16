package restMember;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RestMemberDAO implements RestMemberDAO_Interface{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new javax.naming.InitialContext();
			ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/petym");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void add(RestMember restMember) {
		
	}

	@Override
	public void update(RestMember restMember) {
		
	}

	@Override
	public void delete(String restMemId) {
		
	}

	@Override
	public RestMember findByPK(String restMemId) {
		return null;
	}

	@Override
	public List<RestMember> getAll() {
		return null;
	}
	
}
