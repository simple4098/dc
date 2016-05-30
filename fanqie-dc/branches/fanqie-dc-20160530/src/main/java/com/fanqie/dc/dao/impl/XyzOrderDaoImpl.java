package com.fanqie.dc.dao.impl;

import com.fanqie.dc.bean.order.OrderStat;
import com.fanqie.dc.dao.IXyzOrderDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * author:lzb
 * date:2015/9/22
 */
@Repository
public class XyzOrderDaoImpl extends BaseDaoImpl<OrderStat> implements IXyzOrderDao {

    @Override
    public List<Integer> getExistPmsInnId(List<Integer> innIds, String from, String to) {
        Map<String, Object> map = new HashMap<>();
        map.put("from", from);
        map.put("to", to);
        map.put("innIds", innIds);
        return template.selectList(CRM_NS + ".getExistPmsInnId", map);
    }
}
