package com.fanqie.dc.dao.base;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/11
 * @version: v1.0.0
 */
public interface IBaseDcDao<T> {
    public Integer save(T o);

    public Integer update(T o);

    public Integer delete(T o);

    public List<T> queryAll(T o);
    public T get(T o);

    public Long getCount(T o);

    public Integer deleteByIds(T o);
}
