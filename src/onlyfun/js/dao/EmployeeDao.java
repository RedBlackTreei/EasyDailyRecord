package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.Employee;

public interface EmployeeDao {
	public Employee findEmployee(String sql,List<Object> params);
}
