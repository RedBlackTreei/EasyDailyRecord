package onlyfun.js.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import onlyfun.js.dao.BaseDao;
import onlyfun.js.reflect.Reflect;
import onlyfun.js.utils.dao.DaoUtils;

public class BaseDaoImpl implements BaseDao {
	
	Reflect reflect = Reflect.getInstance();
	
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
		String sql = reflect.getDeleteSql(id);
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
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByExample(Object ojb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
