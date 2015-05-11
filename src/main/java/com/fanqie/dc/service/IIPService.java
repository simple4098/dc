package com.fanqie.dc.service;

import com.fanqie.dc.domain.IPEntity;

import java.util.List;

/**
 * DESC : 代理ip库service
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
public interface IIPService {

    /**
     * 先查询自己ip库了如果达到50个有限 结束；
     * 如果小于50个， 获取代理ip库30有效的ip 保存到本地库
     */
     void saveIP() throws Exception;

    /**
     * 获取一个ip:端口
     * @return
     */
    List<IPEntity>  findValidIp(String type, String limit);

}
