package com.fanqie.dc.service.impl;

import com.fanqie.dc.bean.order.OrderStat;
import com.fanqie.dc.bean.order.OrderStatBo;
import com.fanqie.dc.dao.IOmsOrderDao;
import com.fanqie.dc.dao.IXyzOrderDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.service.IXyzOrderService;
import com.fanqie.dc.support.util.CommonUtil;
import com.fanqie.dc.support.util.JodaTimeUtil;
import com.fanqie.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * author:lzb
 * date:2015/9/22
 */
@Service
public class XyzOrderService implements IXyzOrderService {
    private static Logger logger = LoggerFactory.getLogger(XyzOrderService.class);

    @Autowired
    private IXyzOrderDao dao;

    @DataSource(name = DataSource.CRM)
    @Override
    public Map<String, Object> updateToOms(List<OrderStat> list, OrderStatBo bo) {
        Map<String, Object> result = new HashMap<>();
        //需要更新的订单
        List<OrderStat> updateOrders = new ArrayList<>();
        //需要保存的订单
        List<OrderStat> saveOrders = new ArrayList<>();
        //订单表中存在innIds的map
        Map<Integer, Boolean> existPmsInnIdMap = new HashMap<>();
        List<Integer> existPmsInnId;
        try {
            existPmsInnId = getExistPmsInnIds(getInnIds(list), bo.getFrom(), bo.getTo());
        } catch (Exception e) {
            logger.debug("=========updateToOms========方法错误==========");
            logger.debug("参数：list:" + JacksonUtil.obj2json(list) + " bo:" + JacksonUtil.obj2json(bo), e);
            CommonUtil.setErrorInfo(result, e.getMessage());
            return result;
        }
        if (existPmsInnId != null) {
            existPmsInnIdMap = getInnIdsMap(existPmsInnId);
        }
        for (OrderStat os : list) {
            Boolean aBoolean = existPmsInnIdMap.get(os.getPmsInnId());
            if (aBoolean != null && aBoolean.booleanValue()) {
                updateOrders.add(os);
            } else {
                saveOrders.add(os);
            }
        }
        saveAndUpdate(updateOrders, saveOrders, JodaTimeUtil.getFirstDayOfMontht(bo.getFrom()));
        CommonUtil.setSuccessInfo(result);
        return result;
    }

    private void saveAndUpdate(List<OrderStat> updateOrders, List<OrderStat> saveOrders, Timestamp monthTime) {
        Map<String, Object> saveMap = new HashMap<>();
        Map<String, Object> updateMap = new HashMap<>();
        if (updateOrders.size() > 0) {
            updateMap.put("orderStatList", updateOrders);
            updateMap.put("monthTime", monthTime);
            dao.updateAll(updateMap, dao.CRM_NS);
        }
        if (saveOrders.size() > 0) {
            saveMap.put("orderStatList", saveOrders);
            saveMap.put("monthTime", monthTime);
            dao.saveAll(saveMap, dao.CRM_NS);
        }
    }

    private Map<Integer, Boolean> getInnIdsMap(List<Integer> existPmsInnId) {
        Map<Integer, Boolean> result = new HashMap<>();
        for (Integer innId : existPmsInnId) {
            result.put(innId, true);
        }
        return result;
    }

    /**
     * 获取PmsInnIds集合
     *
     * @param list
     * @return
     */
    private List<Integer> getInnIds(List<OrderStat> list) {
        List<Integer> pmsInnIds = new ArrayList<>();
        for (OrderStat orderStat : list) {
            pmsInnIds.add(orderStat.getPmsInnId());
        }
        return pmsInnIds;
    }

    public List<Integer> getExistPmsInnIds(List<Integer> innIds, String from, String to) throws Exception {
        return dao.getExistPmsInnId(innIds, from, to);
    }
}
