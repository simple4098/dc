package com.fanqie.dc.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanqie.dc.common.Constants;
import com.fanqie.dc.support.resolver.EventResolver;
import com.tomato.mq.client.event.listener.MsgEventListener;
import com.tomato.mq.client.event.model.MsgEvent;
import com.tomato.mq.client.event.publisher.MsgEventPublisher;
import com.tomato.mq.support.message.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * DESC : 改价时间处理
 * @author : 番茄木-ZLin
 * @data : 2016/3/7
 * @version: v1.0.0*/


public class MsgConsumer implements MsgEventListener {

    private static  final Logger log = LoggerFactory.getLogger(MsgConsumer.class);
    private String systemName;

    @Resource
    private EventResolver eventResolver;


    public MsgConsumer(String systemName) {
        this.systemName = systemName;
        log.info("=============start listener===================");
        MsgEventPublisher.getInstance().addListener(this, MessageType.SYS_EVENT, systemName);
    }

    @Override
    public void onEvent(MsgEvent msgEvent) {
        JSONObject jsonObject = JSON.parseObject(msgEvent.getSource().toString());
        eventResolver.pushEvent(jsonObject);
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

}
