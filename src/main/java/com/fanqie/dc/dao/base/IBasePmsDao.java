package com.fanqie.dc.dao.base;



import java.util.List;

public interface IBasePmsDao<T> {
	
	public Integer save(T o);
	
	public Integer update(T o);
	
	public Integer delete(T o);
	
	public List<T> queryAll(T o);
	public T get(T o);
	
	public Long getCount(T o);
	
	public Integer deleteByIds(T o);
	
}
