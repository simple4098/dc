package com.fanqie.dc.domain;

import com.fanqie.dc.common.IPType;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
public class IPEntity implements java.io.Serializable {
    private Integer id;
    private String ip;
    private String port;
    private boolean status;
    private IPType ipType;

    public IPEntity(String ip, String port, boolean status,IPType ipType) {
        this.ip = ip;
        this.port = port;
        this.status = status;
        this.ipType = ipType;
    }

    public IPEntity() {
    }

    public IPType getIpType() {
        return ipType;
    }

    public void setIpType(IPType ipType) {
        this.ipType = ipType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IPEntity ipEntity = (IPEntity) o;

        if (!ip.equals(ipEntity.ip)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ip.hashCode();
    }
}
