package com.fanqie.dc.dao.base;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @param <T>
 */
public class BasePmsDaoImpl<T> implements IBasePmsDao<T> {

	@Autowired
	protected SqlSessionTemplate templatePms;




	@SuppressWarnings("unchecked")
	public T get(T o) {
		return (T) templatePms.selectOne(getNameSpace(o) + ".query", o);
	}

	public Long getCount(T o) {
		return templatePms.selectOne(getNameSpace(o) + ".count", o);
	}

	public Integer deleteByIds(T o) {
		return templatePms.delete(getNameSpace(o) + ".deleteByIds", o);
	}

	protected String getNameSpace(T o) {
		return getClassName(o);
	}

	@SuppressWarnings("unchecked")
	private String getClassName(T o) {
		Object obj = (Object) o;
		Class<T> cls = (Class<T>) obj.getClass();
		return cls.getName();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private String getClassPath(T o) {
		Object obj = (Object) o;
		Class<T> cls = (Class<T>) obj.getClass();
		return cls.getPackage().getName();
	}

	public Integer save(T o) {
		Integer result = 0;
		try {
			result = templatePms.insert(getNameSpace(o) + ".insert", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Integer update(T o) {
		Integer result = 0;
		try {
			result = templatePms.update(getNameSpace(o) + ".update", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Integer delete(T o) {
		Integer result = 0;
		try {
			result = templatePms.delete(getNameSpace(o) + ".delete", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<T> queryAll(T o) {
		List<T> list = null;
		try {
			list = templatePms.selectList(getNameSpace(o) + ".query", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<T> queryList(T o, String sql, String queryName) {
		List<T> list = templatePms.selectList(getNameSpace(o) + "." + queryName,
				sql);
		return list;
	}




}
