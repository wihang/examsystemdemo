package com.xiaoyingjie.dao;
/** 
 * @author XiaoYingJie
 * @date 创建时间：2019年10月20日 下午5:39:01 
 * @version 1.0 
 **/
import java.sql.*;

public class BaseDao {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/systemdemo?serverTimezone=GMT%2B8";
	private static final String user = "root";
	private static final String pwd = "admin";
	Connection conn = null;
 
	// 建立与数据库的连接
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
 
	public void close(Connection conn, Statement st, ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public void close(Connection conn, Statement st) {
		this.close(conn, st, null);
	}
}
