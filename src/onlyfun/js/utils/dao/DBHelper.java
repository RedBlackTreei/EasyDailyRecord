package onlyfun.js.utils.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import org.apache.commons.lang.StringUtils;

public class DBHelper {
	private Connection con;
	private String sql;
	private List<Object> parameters;
	
	public DBHelper() {
		
	}
	
	public DBHelper(Connection conn,String sql,List<Object> parameters) {
		this.con = conn;
		this.sql = sql;
		this.parameters = parameters;
	}

	// 设置连接
	public void setCon(Connection con) {
		this.con = con;
	}

	// 设置sql语句；
	public void setSql(String sql) {
		this.sql = sql;
	}

	// 设置sql语句参数；
	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}
	
	/**
	 * 执行查询；
	 * 
	 * @return
	 */
	public Result executeQuery() {
		Result result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			// 如果sql语句有参数；
			if (parameters != null && parameters.size() > 0) {
				pstmt = con.prepareStatement(sql);
				setParameters(pstmt, parameters);
				rs = pstmt.executeQuery();
			}
			// 如果没有参数；
			else {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 将ResultSet转换成Result;
		result = ResultSupport.toResult(rs);
		return result;
	}

	/**
	 * 执行更新；
	 * 
	 * @return 返回受影响行数；
	 */
	public int executeUpdate() {
		int noOfRows = 0;
		PreparedStatement pstmt = null;
		try {
			// 如果参数不为空；
			if (parameters != null && parameters.size() > 0) {
				pstmt = con.prepareStatement(sql);
				setParameters(pstmt, parameters);
				noOfRows = pstmt.executeUpdate();
			} else {
				pstmt = con.prepareStatement(sql);
				noOfRows = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noOfRows;
	}

	/**
	 * 方法，为sql语句设置参数；
	 * 
	 * @param pstmt
	 *            指令
	 * @param parameters
	 *            参数集合；
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement pstmt, List<Object> parameters)
			throws SQLException {
		for (int i = 0; i < parameters.size(); i++) {
			Object v = parameters.get(i);
			pstmt.setObject(i + 1, v);
		}
	}
}
