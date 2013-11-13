package onlyfun.js.reflect;

import java.sql.ResultSet;

public interface IReflect {
	String getSaveSql(Object obj);
	String getDeleteSql(Class<?> cls, Long id);
	String getDeleteSql(Object obj);
	String getQuerySql(Class<?> cls, Long id);
	Object toObject(ResultSet rs, Class<?> cls);
}
