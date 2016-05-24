package com.fanqie.dc.support.helper;

import com.alibaba.fastjson.JSONArray;
import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.common.CommonApi;
import com.fanqie.dc.common.Constants;
import com.fanqie.dc.dto.*;
import com.fanqie.dc.enumeration.ComparePriceEnum;
import com.fanqie.dc.support.util.ComparePriceUtil;
import com.fanqie.dc.support.util.CpHttpClient;
import com.fanqie.dc.support.util.UrlUtil;
import com.fanqie.util.*;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * DESC : 获取oms客栈 房型  房态数据
 * @author : 番茄木-ZLin
 * @data : 2015/12/17
 * @version: v1.0.0
 */
public class InnRoomHelper {

    private static  final Logger log = LoggerFactory.getLogger(InnRoomHelper.class);


    /**
     * 获取oms 某一个房型的房态信息
     * @param checkRoomUrl 单个房型 房态信息
     * @return
     * @throws java.io.IOException
     */
    public static List<RoomDetail> getRoomDetail(String checkRoomUrl)throws IOException{
        String roomTypeGets = HttpClientUtil.httpGets(checkRoomUrl, null);
        JSONObject jsonObject = JSONObject.fromObject(roomTypeGets);
        if (TomsConstants.SUCCESS.equals(jsonObject.get("status").toString())) {
            Object o1 = jsonObject.get("data");
            if(!JSONNull.getInstance().equals(o1)){
                String data = jsonObject.getJSONArray("data").toString();
                if (!StringUtils.isEmpty(data)){
                    return  JacksonUtil.json2list(jsonObject.getJSONArray("data").toString(), RoomDetail.class);
                }
            }
        }
        return null;
    }

    public static List<RoomDetail> getRoomDetail(ComparePriceConf comparePriceConf,Integer innId,Integer roomTypeId,Integer day) throws Exception {
        String room_type = DcUtil.omsRoomTypeUrl(comparePriceConf.getAccount(), comparePriceConf.getPassword(), comparePriceConf.getOtaId(),
                innId, roomTypeId, CommonApi.checkRoom, day);
        return  InnRoomHelper.getRoomDetail(room_type);
    }

    public static List<CrmBangDto> obtCrmBang(Integer innId, Integer roomTypeId, String otaCode) throws Exception{
        String crmUrl = UrlUtil.obtCrmBangUrl(innId,roomTypeId,otaCode);
        String roomTypeGets = HttpClientUtil.httpGets(crmUrl, null);
        JSONObject jsonObject = JSONObject.fromObject(roomTypeGets);
        if (TomsConstants.SUCCESS.equals(jsonObject.get("status").toString())) {
            Object o1 = jsonObject.get("data");
            if(!JSONNull.getInstance().equals(o1)){
                String data = jsonObject.getJSONArray("data").toString();
                if (!StringUtils.isEmpty(data)){
                    return  JacksonUtil.json2list(jsonObject.getJSONArray("data").toString(), CrmBangDto.class);
                }
            }
        }
        return null;
       /* List<CrmBangDto> list = new ArrayList<>();
        CrmBangDto crmBangDto = new CrmBangDto();
        crmBangDto.setChannelRoomTypeId("573cd69e80fe083e8cf2f697");
        list.add(crmBangDto);
        return  list;*/
    }

    public static List<SpiderData> obtSpider(OmsComparePriceInnRoom omsComparePriceInnRoom,String channelRoomTypeId) throws Exception {
        SpiderJson spiderJson = new SpiderJson();
        spiderJson.setBegin_date(omsComparePriceInnRoom.getSpecialStartDate());
        spiderJson.setEnd_date(omsComparePriceInnRoom.getSpecialEndDate());
        List<SpiderJsonCondition> list = new ArrayList<SpiderJsonCondition>();
        SpiderJsonCondition s1 = new SpiderJsonCondition("room_type_id",channelRoomTypeId);
        SpiderJsonCondition s2 = new SpiderJsonCondition("payment","预付");
        list.add(s1);
        list.add(s2);
        spiderJson.setSearch_condition(list);

        String roomTypeGets = CpHttpClient.httpPost(CommonApi.spiderUrl, spiderJson);
        JSONObject jsonObject = JSONObject.fromObject(roomTypeGets);
        if (Constants.spiderSUCCESS.equals(jsonObject.get("status").toString())) {
            List<JSONObject> o1 = (List)jsonObject.get("result");
            List<SpiderData> spList = new ArrayList<>();
            SpiderData spiderData = null;
            if(!JSONNull.getInstance().equals(o1)){
                for(JSONObject object:o1){
                    spiderData = new SpiderData();
                    String hotel = object.getString("hotel");
                    String breakfast = object.getString("breakfast");
                    String house = object.getString("house");
                    String house_name = object.getString("house_name");
                    String revoke = object.getString("revoke");
                    String price = object.getString("price");
                    String prize_data = object.getString("prize_data");
                    spiderData.setHouseId(hotel);
                    spiderData.setRoomTypeId(house);
                    spiderData.setHouseName(house_name);
                    spiderData.setPrice(new BigDecimal(price));
                    spiderData.setPriceDate(ComparePriceUtil.spiderDate(new Long(prize_data)));
                    spiderData.setBreakfast(breakfast);
                    spiderData.setRevoke(revoke);
                    spList.add(spiderData);
                }
                return spList;
                /*String data = jsonObject.getJSONArray("result").toString();
                if (!StringUtils.isEmpty(data)){
                    return  JacksonUtil.json2list(jsonObject.getJSONArray("data").toString(), SpiderData.class);
                }*/
            }
        }
        return null;
    }

    public static void updateRecordCode(OmsComparePriceInnRoom omsComparePriceInnRoom, ComparePriceEnum problem) {
        /*String spiderUrl = UrlUtil.updateRecordCode(omsComparePriceInnRoom, problem);
        try{
            String roomTypeGets = HttpClientUtil.httpGets(spiderUrl, null);
            JSONObject jsonObject = JSONObject.fromObject(roomTypeGets);
            if (TomsConstants.SUCCESS.equals(jsonObject.get("status").toString())) {
               log.info("更新改价记录成功!!!");
            }else {
               log.info("更新改价记录失败!!!");
            }
        }catch (Exception e){
            log.error("更新改价记录异常",e);
        }*/

    }
}
