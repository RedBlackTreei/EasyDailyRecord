package onlyfun.js.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import onlyfun.js.dao.BaseDao;
import onlyfun.js.reflect.IReflect;
import onlyfun.js.reflect.ReflectProxy;
import onlyfun.js.utils.dao.DaoUtils;

public class BaseDaoImpl implements BaseDao {
	
	
	IReflect reflect = ReflectProxy.getInstance();
	
	@Override
	public int save(Object obj) {
		String sql = reflect.getSaveSql(obj);
		PreparedStatement pstmt = DaoUtils.getPreparedStatement(sql);
		int rows = 0;
		try {
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int deleteById(Class<?> cls,Long id) {
		String sql = reflect.getDeleteSql(cls, id);
		if(sql.equals(StringUtils.EMPTY)) {
			return 0;
		}
		PreparedStatement pstmt = DaoUtils.getPreparedStatement(sql);
		int rows = 0;
		try {
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int delete(Object obj) {
		String sql = reflect.getDeleteSql(obj);
		if(sql.equals(StringUtils.EMPTY)) {
			return 0;
		}
		PreparedStatement pstmt = DaoUtils.getPreparedStatement(sql);
		int rows = 0;
		try {
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int update(Object obj) {
		return 0;
	}

	@Override
	public Object findById(Class<?> cls, Long id) {
		Object obj = null;
		String sql = reflect.getQuerySql(cls, id);
		if(sql.equals(StringUtils.EMPTY)) {
			return null;
		}
		PreparedStatement pstmt = DaoUtils.getPreparedStatement(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			obj = reflect.toObject(rs, cls);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Object> findByExample(Object ojb) {
		return null;
	}

	@Override
	public List<Object> findAll() {
		return null;
	}

}
