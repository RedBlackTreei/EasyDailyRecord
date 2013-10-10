package onlyfun.js.dao;

import java.util.List;

public interface BaseDao {
	public int save(Object obj);
	public int deleteById(Class<?> cls,Long id);
	public int delete(Object obj);
	public int update(Object obj);
	public Object findById(Long id);
	public List<Object> findByExample(Object ojb);
	public List<Object> findAll();
}
