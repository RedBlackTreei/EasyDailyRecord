package onlyfun.js.utils.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;


public class DaoUtils {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	
	/**
	 *@Description : 获取数据库连接
	 *@Creator : Justin
	 *@Crate date : Aug 26, 2013 3:13:34 PM
	 */
	public static Connection getConnection() {
//		try {
//			Context ctx = new InitialContext();
//			DataSource ds = (DataSource) ctx.lookup("java:comp/env/record");
//			conn = ds.getConnection();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		try{   
		    Class.forName("com.mysql.jdbc.Driver") ;   
		}catch(ClassNotFoundException e){   
		    System.out.println("找不到驱动程序类 ，加载驱动失败！");   
		    e.printStackTrace() ;   
		}    
	     String url = "jdbc:mysql://localhost:3306/record" ;    
	     String username = "root" ;   
	     String password = "101" ;   
	     try{   
	    	 conn = DriverManager.getConnection(url , username , password ) ;   
	     }catch(SQLException se){   
		    System.out.println("数据库连接失败！");   
		    se.printStackTrace() ;   
	     }    
		return conn;
	}
	
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
}
