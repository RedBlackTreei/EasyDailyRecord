package onlyfun.js.reflect;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class ReflectProxy implements IReflect {
	private Reflect reflect = Reflect.getInstance();
	private static ReflectProxy proxy = null;
	private static Logger logger = Logger.getLogger(ReflectProxy.class); 
	
	private ReflectProxy() {
		
	}
	
	@Override
	public String getSaveSql(Object obj) {
		String saveSql = reflect.getSaveSql(obj);
		logger.info(saveSql);
		return saveSql;
	}

	@Override
	public String getDeleteSql(Class<?> cls, Long id) {
		String deleteSql = reflect.getDeleteSql(cls, id);
		logger.info(deleteSql);
		return deleteSql;
	}

	@Override
	public String getDeleteSql(Object obj) {
		String deleteSql = reflect.getDeleteSql(obj);
		logger.info(deleteSql);
		return deleteSql;
	}
	
	@Override
	public String getQuerySql(Class<?> cls, Long id) {
		String querySql = reflect.getQuerySql(cls, id);
		logger.info(querySql);
		return querySql;
	}
	
	public Object toObject(ResultSet rs, Class<?> cls) {
		Object obj = reflect.toObject(rs, cls);
		logger.info(obj);
		return obj;
	}
	
	public static synchronized ReflectProxy getInstance() {
		if(proxy == null) {
			return new ReflectProxy();
		}
		return proxy;
	}
}
