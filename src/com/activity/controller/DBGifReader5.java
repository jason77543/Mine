package com.activity.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class DBGifReader5 extends HttpServlet {

	// �B�γs�u���A�����į� �ѨM������D  ���C�P��Ʈw�����X
	// �p�߳s�u�����D�A�o�̬O�ι����ܼơC
	Connection con;
	ServletOutputStream out;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		out = res.getOutputStream();

		try {

			req.setCharacterEncoding("big5");
			Integer actNo = Integer.parseInt(req.getParameter("actNo"));
			

			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT actinitimg FROM activity WHERE actNo='" + actNo + "' ");

			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("actinitimg"));
				byte[] buf = new byte[1000 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				in.close();
			} else {
				//res.sendError(HttpServletResponse.SC_NOT_FOUND);
				// ���}�Ѽƿ��~�ɷ|���404  �i�H�N�����
				noData(req);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			//System.out.println(e);
			// �Ұʺ����ɡAŪ����Ϥ��i�H�N�����
			noData(req);
		}
	}

	public void init() throws ServletException {
		try { 
		 
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/petym");
			con = ds.getConnection();
		} catch (Exception e) {
			throw new UnavailableException("Couldn't get db connection");
		}
	}

	public void destroy() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void noData(HttpServletRequest req){
		try {
		InputStream in = req.getServletContext().getResourceAsStream("/NoData/1.jpg");
		byte[] buff = new byte[in.available()];
		in.read(buff);
		out.write(buff);
		in.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
