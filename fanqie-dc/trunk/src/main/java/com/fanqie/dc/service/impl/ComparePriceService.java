package com.fanqie.dc.service.impl;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.ComparePriceData;
import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.bean.cp.OmsOtaRoomType;
import com.fanqie.dc.common.CommonApi;
import com.fanqie.dc.common.Constants;
import com.fanqie.dc.dao.IComparePriceConfDao;
import com.fanqie.dc.dao.IComparePriceDataDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.dto.*;
import com.fanqie.dc.enumeration.ComparePriceEnum;
import com.fanqie.dc.service.IComparePriceService;
import com.fanqie.dc.support.helper.InnRoomHelper;
import com.fanqie.dc.support.notify.NotifyDto;
import com.fanqie.dc.support.util.ComparePriceUtil;
import com.fanqie.dc.support.util.MQUtil;
import com.fanqie.util.DateUtil;
import com.fanqie.util.DcUtil;
import com.fanqie.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DESC : 比价实现类
 * @author : 番茄木-ZLin
 * @data : 2016/5/12
 * @version: v1.0.0
 */
@Service
public class ComparePriceService implements IComparePriceService {
    private static final Logger logger = LoggerFactory.getLogger(ComparePriceService.class);

    @Resource
    private IComparePriceDataDao comparePriceDataDao;
    @Resource
    private IComparePriceConfDao comparePriceConfDao;


    @DataSource(name = DataSource.CP)
    @Override
    public void updateComparePrice( OmsComparePriceInnRoom omsComparePriceInnRoom,ComparePriceConf comparePriceConf) throws Exception {
        logger.info("=================改价监听start=====================");
        logger.info(omsComparePriceInnRoom.getInnId().toString());
        if (comparePriceConf!=null){
            List<OmsOtaRoomType> roomTypeList = omsComparePriceInnRoom.getTomatoOmsOtaRoomtypeList();
            for (OmsOtaRoomType omsOtaRoomType:roomTypeList){
                //获取oms 房态
                String room_type = DcUtil.omsRoomTypeUrl(comparePriceConf.getAccount(), comparePriceConf.getPassword(), comparePriceConf.getOtaId(),
                        omsComparePriceInnRoom.getInnId(), omsOtaRoomType.getId(), CommonApi.checkRoom, comparePriceConf.getSpiderDay());
                List<RoomDetail> roomDetail = InnRoomHelper.getRoomDetail(room_type);
                logger.info("房态信息:"+JacksonUtil.obj2json(roomDetail));
                //crm绑定关系
                List<CrmBangDto> crmBangDto = InnRoomHelper.obtCrmBang(omsComparePriceInnRoom.getInnId(), omsOtaRoomType.getRoomTypeId(), comparePriceConf.getOtaCode());
                if (!CollectionUtils.isEmpty(crmBangDto)){
                    for (CrmBangDto crmBang:crmBangDto){
                        //获取spider 去哪儿房价数据
                        List<SpiderData> spiderData = InnRoomHelper.obtSpider(omsComparePriceInnRoom,crmBang.getChannelRoomTypeId());
                        //比价
                        List<ComparePriceData> list = ComparePriceUtil.comparePrice(roomDetail,spiderData,omsOtaRoomType,omsComparePriceInnRoom, comparePriceConf);
                        updateOrSaveComparePrice(list);
                    }
                }
            }
            //通知crm 客栈房型改价。
            MQUtil.send(new NotifyDto(Constants.COMPARE_PRICE_PRICE_AUDIT, JacksonUtil.obj2json(omsComparePriceInnRoom)));
            logger.info("=================改价监听end=====================");
        }
    }


    @DataSource(name = DataSource.CP)
    @Override
    public void updateOrSaveComparePrice(List<ComparePriceData> list) {
        if (!CollectionUtils.isEmpty(list)){
            ComparePriceDataDto comparePriceDataDto =ComparePriceUtil.encapsulation(list);
            comparePriceDataDao.deletedComparePrice(comparePriceDataDto);
            comparePriceDataDao.saveComparePrice(comparePriceDataDto);
        }
    }



    @DataSource(name = DataSource.CP)
    @Override
    public void updateTimerComparePrice()  {
        logger.info("=================改价定时任务start=====================");
        ComparePriceConf comparePriceConf = comparePriceConfDao.selectComparePriceConf();
        try {
            List<CrmBangDto> crmBangDto = InnRoomHelper.obtCrmBang(null,null, comparePriceConf.getOtaCode());
            if (!CollectionUtils.isEmpty(crmBangDto)){
                String startDate = DateUtil.formatDateToString(new Date(), DateUtil.DATE_CENTER_FROM);
                String endDate = DateUtil.formatDateToString(DateUtil.addDay(new Date(),comparePriceConf.getSpiderDay()),DateUtil.DATE_CENTER_FROM);
                OmsComparePriceInnRoom omsComparePriceInnRoom = new OmsComparePriceInnRoom();
                omsComparePriceInnRoom.setSpecialStartDate(startDate);
                omsComparePriceInnRoom.setSpecialStartDate(endDate);
                OmsOtaRoomType omsOtaRoomType = null;
                for (CrmBangDto crmBang:crmBangDto){
                    omsComparePriceInnRoom.setInnId(crmBang.getInnId());
                    List<RoomDetail> roomDetail = InnRoomHelper.getRoomDetail(comparePriceConf, crmBang.getInnId(), crmBang.getOtaRoomTypeId(),comparePriceConf.getSpiderDay());
                    omsOtaRoomType = new OmsOtaRoomType(crmBang.getOtaRoomTypeId(),crmBang.getRoomTypeName());
                    //获取spider 去哪儿房价数据
                    List<SpiderData> spiderData = InnRoomHelper.obtSpider(omsComparePriceInnRoom,crmBang.getChannelRoomTypeId());
                    //比价
                    List<ComparePriceData> list = ComparePriceUtil.comparePrice(roomDetail,spiderData,omsOtaRoomType,omsComparePriceInnRoom, comparePriceConf);
                    if (ComparePriceEnum.PROBLEM.equals(omsComparePriceInnRoom.getPriceEnum())){
                        //通知crm 客栈异常。
                        MQUtil.send(new NotifyDto(Constants.COMPARE_PRICE_PRICE_AUDIT, JacksonUtil.obj2json(omsComparePriceInnRoom)));
                    }
                    updateOrSaveComparePrice(list);
                }
            }

        } catch (Exception e) {
            logger.error("查询crm绑定异常",e);
        }


    }
    @DataSource(name = DataSource.CP)
    @Override
    public CrmComparePriceDto findComparePrice(ComparePriceData priceData)throws Exception{
        ComparePriceData comparePriceData = comparePriceDataDao.selectInnInfo(priceData);
        List<CrmComparePriceDataDto> list = comparePriceDataDao.selectComparePrice(priceData);
        CrmComparePriceDto priceDto = new CrmComparePriceDto();
        //TODO 联系电话
        priceDto.setContact("1528101706");
        priceDto.setInnName(comparePriceData.getInnName());
        priceDto.setCreatedTime(DateUtil.format(comparePriceData.getCreatedDate(),DateUtil.FORMAT_DATE_STR_SECOND));
        priceDto.setPriceDtoList(list);
        return priceDto;
    }
}