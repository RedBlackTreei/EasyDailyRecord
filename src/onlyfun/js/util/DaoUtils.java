package onlyfun.js.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class DaoUtils {
	private static Connection conn = null;
	private PreparedStatement pstmp = null;
	
	/**
	 *@Description : 获取数据库连接
	 *@Creator : Justin
	 *@Crate date : Aug 26, 2013 3:13:34 PM
	 */
	public static Connection getConnection() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/record");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
