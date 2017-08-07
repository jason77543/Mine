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

	// 運用連線池，提高效能 解決交易問題  降低與資料庫的耦合
	// 小心連線的問題，這裡是用實體變數。
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
				// 網址參數錯誤時會顯示404  可以代替顯示
				noData(req);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			//System.out.println(e);
			// 啟動網頁時，讀不到圖片可以代替顯示
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
