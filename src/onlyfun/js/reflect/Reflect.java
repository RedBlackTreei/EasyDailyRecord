package onlyfun.js.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class Reflect {
	
	private static Reflect reflect = null;
	
	private Reflect() {
		
	}
	
	/**
	 *@Description : 通过反射获取当前对象的保存SQL
	 *@param obj : 当前对象，如：Employee、Company等
	 *@return : String 生成的SQL
	 */
	public String getSaveSql(Object obj) {
		Class<?> object = obj.getClass();
		String className = object.getSimpleName();
		String tableName = className.toLowerCase();
		String sqlHead = "insert into " + tableName + "(";
		Method[] methods = this.getMethods(object);
		if(StringUtils.isEmpty(tableName)) {
			return StringUtils.EMPTY;
		}
		List<String> fieldNames = new ArrayList<String>();
		List<Object> fieldValues = new ArrayList<Object>();
		for(Method method : methods) {
			String methodName = method.getName();
			if(methodName.startsWith("get") && !methodName.startsWith("getClass")) {
				String fieldName = methodName.substring(3, methodName.length());
				fieldNames.add(fieldName);
				try {
					Object fieldValue = method.invoke(obj);
					if(fieldValue instanceof String) {
						fieldValues.add("\"" + fieldValue + "\"");
					} else if(fieldValue instanceof java.sql.Timestamp) {
						fieldValues.add("\"" + fieldValue + "\"");
					} else if(fieldValue instanceof java.sql.Date) {
						fieldValues.add("\"" + fieldValue + "\"");
					}else {
						fieldValues.add(fieldValue);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		String sql = this.generateSql(sqlHead, fieldNames, fieldValues);
		return sql;
	}
	
	/**
	 *@Description : 根据对象删除数据
	 *@param obj ： 删除对象
	 *@return : String
	 */
	public String getDeleteSql(Object obj) {
		Long id = getEntityId(obj); 
		if(id == 0L) {
			return StringUtils.EMPTY;
		}
		String tableName = obj.getClass().getName();
		String sql = "delete from " + tableName + " where id = " + id;
		return sql;
	}
	
	/**
	 *@Description : 根据id删除数据
	 *@param cls ：删除对象
	 *@param id
	 *@return : String
	 */
	public String getDeleteSql(Class<?> cls, Long id) {
		if(id == 0L) {
			return StringUtils.EMPTY;
		}
		String tableName = cls.getName();
		String sql = "delete from " + tableName + " where id = " + id;
		return sql;
	}
	
	private Long getEntityId(Object obj) {
		Long id = 0L;
		if(obj == null || StringUtils.isEmpty(obj.toString())) {
			return 0L;
		}
		try {
			Field field = obj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			id = (Long)field.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return id;
	}
	
	public String getSaveSql2(Object obj) {
		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		String tableName = cls.getSimpleName();
		StringBuilder fieldNames = new StringBuilder();
		StringBuilder parameters = new StringBuilder();
		for(int i = 0; i< fields.length; i++) {
			if(i < fields.length - 1) {
				fieldNames.append(fields[i].getName() + ", ");
				parameters.append("?, ");
			} else {
				fieldNames.append(fields[i].getName());
				parameters.append("?");
			}
		}
		String sql = String.format("INSERT INTO %s(%s) values(%s)", tableName,fieldNames,parameters);
		return sql;
	}
	
	/**
	 *@Description : 生成SQL
	 *@param sqlHead : SQL头
	 *@param fieldNames ：字段名列表
	 *@param fieldValues ：字段值列表
	 *@return : String ：生成的SQL
	 */
	private String generateSql(String sqlHead, List<String> fieldNames, List<Object> fieldValues) {
		String sql = sqlHead;
		for (int i = 0; i < fieldNames.size(); i++) {  
            if (i < fieldNames.size() - 1) {  
            	sql += fieldNames.get(i) + ",";  
            } else {  
            	sql += fieldNames.get(i) + ") values(";  
            }  
        }  
        for (int i = 0; i < fieldValues.size(); i++) {  
            if (i < fieldValues.size() - 1) {  
            	sql += fieldValues.get(i) + ",";  
            } else {  
            	sql += fieldValues.get(i) + ")";  
            }  
        }
        return sql;
	}
	
	/**
	 *@Description : 或去当前Class下的所有方法
	 *@param cls ：当前Class
	 *@return : Method[]，方法数组
	 */
	private Method[] getMethods(Class<?> cls) {
		Method[] methods = cls.getMethods();
		if(ArrayUtils.isEmpty(methods)) {
			return (Method[])ArrayUtils.EMPTY_OBJECT_ARRAY;
		}
		return methods;
	}
	
	public static synchronized Reflect getInstance() {
		if(reflect == null) {
			return new Reflect();
		}
		return reflect;
	}
}
