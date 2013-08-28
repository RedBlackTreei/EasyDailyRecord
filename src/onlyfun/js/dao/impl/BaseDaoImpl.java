package onlyfun.js.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import onlyfun.js.dao.BaseDao;
import onlyfun.js.reflect.Reflect;
import onlyfun.js.utils.dao.DaoUtils;

public class BaseDaoImpl implements BaseDao {

	@Override
	public int save(Object obj) {
		String sql = new Reflect().getSaveSql(obj);
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
	public int deleteById(Long id) {
		return 0;
	}

	@Override
	public int delete(Object obj) {
		return 0;
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
