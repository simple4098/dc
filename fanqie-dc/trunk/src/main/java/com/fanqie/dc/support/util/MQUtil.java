package com.fanqie.dc.support.util;

import com.fanqie.dc.support.notify.NotifyDto;
import com.fanqie.util.JacksonUtil;
import com.tomato.mq.client.produce.MQProducer;
import com.tomato.mq.client.support.MQClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DESC : 发消息工具类
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class MQUtil {
    private static final Logger log = LoggerFactory.getLogger(MQUtil.class);

    public static void  send(NotifyDto notifyDto){
        log.debug("======MQUtil====向消息中心发送消息===消息体：notify:" + JacksonUtil.obj2json(notifyDto));
        MQProducer mqProducer = MQClientBuilder.build();
        mqProducer.send(notifyDto);
    }
}
