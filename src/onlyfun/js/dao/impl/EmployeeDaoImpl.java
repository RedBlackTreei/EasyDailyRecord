package onlyfun.js.dao.impl;

import java.util.List;


import onlyfun.js.dao.EmployeeDao;
import onlyfun.js.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
//	private DBHelper dbHelper;
	@Override
	public Employee findEmployee(String sql,List<Object> params) {
//		Connection conn = DaoUtils.getConnection();
//		dbHelper = new DBHelper(conn,sql,params);
//		Result result = dbHelper.executeQuery();
//		if(result.getRowCount() == 0 || result == null) {
//			return null;
//		} else {
//			try {
//				Class<?> entity = Class.forName("onlyfun.js.model.Employee");
//				Field[] fields = entity.getDeclaredFields();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
		return null;
	}

}
