package com.fanqie.dc.support.resolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.common.Constants;
import com.fanqie.dc.service.IComparePriceConfService;
import com.fanqie.dc.service.IComparePriceService;
import com.fanqie.util.JacksonUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeoutException;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/3/15
 * @version: v1.0.0
 */
@Component
public class EventResolver {
    private static  final Logger log = LoggerFactory.getLogger(EventResolver.class);

    @Resource
    private IComparePriceService comparePriceService;
    @Resource
    private IComparePriceConfService comparePriceConfService;
    @Resource
    private MemcachedClient memcachedClient;


    public void pushEvent(JSONObject jsonObject){

        String bizType = jsonObject.getString("bizType");
        String content = jsonObject.getString("content");
        String sys =  jsonObject.getString("projectName");
        if (Constants.OMS_MESPRICE_TYPE.equals(bizType) && Constants.OMS_PROJECT.equals(sys)){
            log.info("=====监听到改价消息==================参数："+content);

            OmsComparePriceInnRoom omsComparePriceInnRoom = JSON.parseObject(content, new TypeReference<OmsComparePriceInnRoom>() {
            });
            //todo 1:查询比价系统的配置信息放在缓存中， 2：客栈id omsRoomTypeId 查询crm 绑定关系  3 根据绑定关系查询 渠道房价信息 4 进行比价
            String defaultOta = Constants.DEFAULT_OTA;
            ComparePriceConf comparePriceConf = null;
            try {
                 String conf  = memcachedClient.get(defaultOta);
                 log.info("===========获取 memcachedClient ============"+conf);
                 comparePriceConf = JacksonUtil.json2obj(conf,ComparePriceConf.class);
                if (comparePriceConf==null){
                    comparePriceConf = comparePriceConfService.selectComparePriceConf();
                }
            } catch (Exception e) {
                 comparePriceConf = comparePriceConfService.selectComparePriceConf();
            }
            try {
                comparePriceService.updateComparePrice(omsComparePriceInnRoom,comparePriceConf);
            } catch (Exception e) {
                log.error("比价异常",e);
            }
        }

    }
}
