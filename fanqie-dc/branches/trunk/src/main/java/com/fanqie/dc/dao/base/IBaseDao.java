package com.fanqie.dc.dao.base;

import com.fanqie.util.Pagination;

import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/11
 * @version: v1.0.0
 */
public interface IBaseDao<T> {
    public Integer save(T o);

    Integer saveAll(Map map,String ns);

    public Integer update(T o);

    Integer updateAll(Map map,String ns);

    public Integer delete(T o);

    public List<T> queryAll(T o);

    public T get(T o);

    public Long getCount(T o);

    public Integer deleteByIds(T o);

    /**
     * 默认分页查询，根据T反射找到包名：即mybaits空间名  默认查询名称：bean报地址+query
     * @param o
     * @param page
     * @return
     */
    public Map<String,Object> queryByPage(T o,Pagination page);

    public Map<String, Object> queryByPage(Object o, Pagination page, String queryName);
}
