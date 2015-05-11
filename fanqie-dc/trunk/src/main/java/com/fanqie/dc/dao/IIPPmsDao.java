package com.fanqie.dc.dao;


import com.fanqie.dc.dao.base.IBasePmsDao;
import com.fanqie.dc.domain.IPEntity;

import java.util.List;
import java.util.Set;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
public interface IIPPmsDao extends IBasePmsDao<IPEntity> {

    /**
     * 批量保存
     * @param ipList
     */
    void  saveIp(List<IPEntity> ipList);

    /**
     * 查询全部IP库的ip
     */
    List<IPEntity> findAll();

    /**
     * 删除无效的ip
     * @param entity
     */
    void removeIp(IPEntity entity);

    List<IPEntity> findValidIp(String ipType,Integer limit);

    /**
     * 批量保存有限ip
     */
    void saveBatchIp(Set<IPEntity> set);

    /**
     * 批量更新数据库本来有的ip
     * @param oldSet
     */
    void updateBatchIp(Set<IPEntity> oldSet);

    /**
     * 批量删除过期的ip
     * @param set
     */
    void deletedIds(List<IPEntity> set);
}
