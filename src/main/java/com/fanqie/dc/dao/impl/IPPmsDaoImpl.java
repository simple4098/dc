package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IIPPmsDao;
import com.fanqie.dc.dao.base.BasePmsDaoImpl;
import com.fanqie.dc.domain.IPEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
@Repository
public class IPPmsDaoImpl extends BasePmsDaoImpl<IPEntity> implements IIPPmsDao {

    private static  final String NA = "com.fanqie.dc.domain.IPEntity.";
    @Override
    public void saveIp(List<IPEntity> ipList) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ipList", ipList);
       templatePms.insert(NA.concat("saveListIp"),map) ;
    }

    @Override
    public List<IPEntity> findAll() {
        return   templatePms.selectList(NA.concat("findAll"));
    }

    @Override
    public void removeIp(IPEntity entity) {
        this.delete(entity);
    }

    @Override
    public  List<IPEntity> findValidIp(String ipType,Integer limit) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("type",ipType);
        param.put("limit",limit);
        return templatePms.selectList(NA.concat("findValidIp"),param);
    }

    @Override
    public void saveBatchIp(Set<IPEntity> set) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ipList", set);
        templatePms.insert(NA.concat("saveBatchIp"),map) ;
    }

    @Override
    public void updateBatchIp(Set<IPEntity> oldSet) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ipList", oldSet);
        templatePms.insert(NA.concat("updateBatchIp"),map) ;
    }

    @Override
    public void deletedIds(List<IPEntity> set) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ipList", set);
        templatePms.delete(NA.concat("deletedIds"), map);
    }
}
