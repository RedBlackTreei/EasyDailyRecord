package onlyfun.js.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TestDao {
//	public void testJNDI() throws NamingException, SQLException {   
//		Context ctx = new InitialContext();   
//		DataSource ds = (DataSource) ctx.lookup("java:comp/env/sqlconn");   
//		Connection conn = ds.getConnection();   
//		System.out.println(conn.isClosed());   
//	} 
	public void testJNDI() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/record");
			Connection conn = ds.getConnection();
			System.out.println("--------" + conn.isClosed());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
