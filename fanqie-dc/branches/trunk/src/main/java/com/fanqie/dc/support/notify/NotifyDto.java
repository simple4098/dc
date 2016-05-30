package com.fanqie.dc.support.notify;

import com.tomato.mq.support.core.AbstractMessage;
import com.tomato.mq.support.message.MessageType;

import java.util.UUID;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class NotifyDto extends AbstractMessage {
    private String projectName = "dc";
    private String bizType;
    private String clientId;

    public NotifyDto() {
    }

    public NotifyDto(String bizType, String content) {
        this.setBizType(bizType);
        this.setContent(content);
        this.setMessageType(MessageType.SYS_EVENT);
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public void setClientId() {
        this.clientId = this.projectName + "-" + this.bizType + "-" + UUID.randomUUID();
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

}
