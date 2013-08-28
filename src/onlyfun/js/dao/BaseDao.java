package onlyfun.js.dao;

public interface BaseDao {
	public void save(Object obj);
	public void deleteById(Long id);
	public void delete(Object obj);
}
