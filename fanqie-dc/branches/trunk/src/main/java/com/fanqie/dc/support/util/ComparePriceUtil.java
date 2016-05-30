package com.fanqie.dc.support.util;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.ComparePriceData;
import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.bean.cp.OmsOtaRoomType;
import com.fanqie.dc.common.Constants;
import com.fanqie.dc.dto.ComparePriceDataDto;
import com.fanqie.dc.dto.RoomDetail;
import com.fanqie.dc.dto.SpiderData;
import com.fanqie.dc.enumeration.ComparePriceEnum;
import com.fanqie.dc.support.helper.InnRoomHelper;
import com.fanqie.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DESC : 比较工具类
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class ComparePriceUtil {


    public static List<ComparePriceData> comparePrice(List<RoomDetail> roomDetail, List<SpiderData> spiderData,
                                                      OmsOtaRoomType omsOtaRoomType,OmsComparePriceInnRoom omsComparePriceInnRoom,
                                                      ComparePriceConf comparePriceConf) {
        BigDecimal divide = divide(new BigDecimal(comparePriceConf.getPercentage()), Constants.PERCENTAGE);
        List<ComparePriceData> list = new ArrayList<>();

        if (!CollectionUtils.isEmpty(roomDetail)){
            ComparePriceData comparePriceData = null;
            for (RoomDetail detail:roomDetail){
                Date parseDate = DateUtil.parseDate(detail.getRoomDate());
                comparePriceData = new ComparePriceData(omsComparePriceInnRoom.getInnId(),omsComparePriceInnRoom.getInnName(),omsOtaRoomType.getRoomTypeName(),
                        omsOtaRoomType.getRoomTypeId().toString(),parseDate,detail.getRoomPrice(),null,null,null,comparePriceConf.getOtaCode());
                comparePriceSpider(spiderData, detail, comparePriceData, divide);
                list.add(comparePriceData);
            }
            updateRecord(list,omsComparePriceInnRoom);
        }
        return list;
    }


    public static void comparePriceSpider(List<SpiderData> spiderData,RoomDetail detail,  ComparePriceData comparePriceData,BigDecimal divide ){
        if (!CollectionUtils.isEmpty(spiderData)) {
            for (SpiderData spider : spiderData) {
                if (detail.getRoomDate().equals(spider.getPriceDate())) {
                    comparePriceData.setOtaSellingPrice(spider.getPrice().doubleValue());
                    comparePriceData.setOtaRoomTypeId(spider.getRoomTypeId());
                    comparePriceData.setOtaInnId(spider.getHouseId());
                    //true 番茄价格 比 去哪儿 大；true 去哪儿价格比我们高（divide）15%
                    if (compareTo(detail.getRoomPrice(), spider.getPrice()) || compareTo(detail.getRoomPrice(), spider.getPrice(), divide)) {
                        comparePriceData.setPriceEnum(ComparePriceEnum.PROBLEM);
                    }
                }
            }
        }
    }

    public static void updateRecord( List<ComparePriceData> list,OmsComparePriceInnRoom omsComparePriceInnRoom){
        if (!CollectionUtils.isEmpty(list)){
            for (ComparePriceData comparePriceData:list){
                if (ComparePriceEnum.PROBLEM.equals(comparePriceData.getPriceEnum())) {
                    InnRoomHelper.updateRecordCode(omsComparePriceInnRoom, ComparePriceEnum.PROBLEM);
                    omsComparePriceInnRoom.setPriceEnum(ComparePriceEnum.PROBLEM);
                }
            }
        }
    }

    public static BigDecimal divide(BigDecimal dividend, int divisor) {
        return divisor != 0?dividend.divide(new BigDecimal(divisor)):null;
    }

    /**
     * 比较大小   b>d  true;
     * @param d
     * @param b
     * @return
     */
    public static boolean compareTo(double d,BigDecimal b){
       return new BigDecimal(d).compareTo(b)==1;
    }

    /**
     *
     * @param d 番茄价格
     * @param b 去哪儿价格
     * @param divide 百分比
     */
    public static boolean compareTo(double d,BigDecimal b,BigDecimal divide){
        Double divideD = divide.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue()+1;
        BigDecimal price = new BigDecimal(d).multiply(new BigDecimal(divideD));
       return b.compareTo(price)==1;
    }



    public static ComparePriceDataDto encapsulation(List<ComparePriceData> list) {
        ComparePriceDataDto comparePriceDataDto = new ComparePriceDataDto();
        for (ComparePriceData comparePriceData:list){
            if (comparePriceData.getPriceEnum()==null){
                comparePriceData.setPriceEnum(ComparePriceEnum.RESOLVED);
            }
        }
        comparePriceDataDto.setComparePriceDataList(list);
        ComparePriceData start = list.get(0);
        ComparePriceData end = list.get(list.size()-1);
        comparePriceDataDto.setStartDate(DateUtil.format(start.getSellingDate(), DateUtil.DATE_CENTER_FROM));
        comparePriceDataDto.setEndDate(DateUtil.format(end.getSellingDate(), DateUtil.DATE_CENTER_FROM));
        comparePriceDataDto.setInnId(start.getInnId());
        comparePriceDataDto.setOtaCode(start.getOtaCode());
        return comparePriceDataDto;
    }

    /**
     * 去哪儿时间转换
     * @param time 时间戳
     * @return
     */
    public static  String  spiderDate(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long timeV = new Long(time)*1000;
        return  sdf.format(new Date(timeV));
    }


    public static void main(String[] args) {
        boolean b = compareTo(135.0, new BigDecimal(168),new BigDecimal(0.15));
    }
}
