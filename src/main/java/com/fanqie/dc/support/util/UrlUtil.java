package com.fanqie.dc.support.util;

import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.common.CommonApi;
import com.fanqie.dc.enumeration.ComparePriceEnum;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class UrlUtil {


    public static String obtCrmBangUrl(Integer innId, Integer roomTypeId, String otaCode) {
        String url = CommonApi.crmBangUrl.concat("?channelType=").concat(otaCode);
        if (innId!=null){
            url = url.concat("&innId=").concat(innId.toString());
        }
        if (roomTypeId!=null){
            url = url.concat("&roomTypeId=").concat(roomTypeId.toString());
        }
        return url;
    }

    /*public static String obtSpiderUrl(String specialStartDate, String specialEndDate, String channelRoomTypeId) {
        return CommonApi.spiderUrl.concat("?begin_date=").concat(specialStartDate).concat("&end_date=").concat(specialEndDate).
                concat("&search_key=").concat("room_type_id").concat("&search_value=").concat(channelRoomTypeId);
    }*/

    public static String updateRecordCode(OmsComparePriceInnRoom omsComparePriceInnRoom, ComparePriceEnum problem) {
        return CommonApi.updateOmsPriceRecord.concat("?recordCode=").concat(omsComparePriceInnRoom.getRecordCode()).concat("&status=").concat(problem.name());
    }
}
