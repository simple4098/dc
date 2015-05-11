package com.fanqie.dc.dao.base;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @param <T>
 */
public class BaseDcDaoImpl<T> implements IBaseDcDao<T> {

	@Autowired
	protected SqlSessionTemplate templateDc;




	@SuppressWarnings("unchecked")
	public T get(T o) {
		return (T) templateDc.selectOne(getNameSpace(o) + ".query", o);
	}

	public Long getCount(T o) {
		return templateDc.selectOne(getNameSpace(o) + ".count", o);
	}

	public Integer deleteByIds(T o) {
		return templateDc.delete(getNameSpace(o) + ".deleteByIds", o);
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
			result = templateDc.insert(getNameSpace(o) + ".insert", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Integer update(T o) {
		Integer result = 0;
		try {
			result = templateDc.update(getNameSpace(o) + ".update", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Integer delete(T o) {
		Integer result = 0;
		try {
			result = templateDc.delete(getNameSpace(o) + ".delete", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<T> queryAll(T o) {
		List<T> list = null;
		try {
			list = templateDc.selectList(getNameSpace(o) + ".query", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<T> queryList(T o, String sql, String queryName) {
		List<T> list = templateDc.selectList(getNameSpace(o) + "." + queryName,
				sql);
		return list;
	}




}
