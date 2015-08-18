package com.fanqie.dc.dao.base;


import com.fanqie.util.Pagination;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Override
	public Map<String, Object> queryByPage(T o, Pagination page) {
		return queryByPage(o, page, getNameSpace(o) + ".query");
	}

	@Override
	public Map<String, Object> queryByPage(Object o, Pagination page, String queryName) {
		List<T> list = null;
		handlePage(o, page, queryName);
		if (page.isPaging()) {
			list = templateDc.selectList(queryName, o, getRowBounds(page));
		} else {
			list = templateDc.selectList(queryName, o);
		}
		Map<String, Object> map = getResultMap(list, page);
		return map;
	}

	public RowBounds getRowBounds(Pagination page) {
		return new RowBounds(page.getOffset(), page.getRows());
	}

	public Pagination handlePage(Object o, Pagination page, String queryName) {
		// 查询行数
		Integer rowsCount = null;
		try {
			rowsCount = templateDc.selectOne(queryName + "Count", o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("handlePage错误,参数："+o.toString());
		}
		page.calcPage(rowsCount);
		return page;
	}
	private Map<String, Object> getResultMap(List<T> list, Pagination page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("page", page);
		return map;
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
