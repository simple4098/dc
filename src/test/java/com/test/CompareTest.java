
package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.dto.CrmBangDto;
import com.fanqie.dc.dto.SpiderData;
import com.fanqie.dc.enumeration.ComparePriceEnum;
import com.fanqie.dc.service.IComparePriceConfService;
import com.fanqie.dc.support.helper.InnRoomHelper;
import com.fanqie.dc.support.resolver.EventResolver;
import com.fanqie.util.DateUtil;
import com.fanqie.util.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/6/23
 * @version: v1.0.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "dev")
@ContextConfiguration(locations = "classpath:spring.xml")
public class CompareTest {
    private static  final Logger log = LoggerFactory.getLogger(CompareTest.class);

    @Resource
    private IComparePriceConfService comparePriceConfService;
    @Resource
    private EventResolver eventResolver;

    @Test
    public void  testBangCrm(){
        ComparePriceConf comparePriceConf = comparePriceConfService.selectComparePriceConf();
        //crm绑定关系
        try {
            List<CrmBangDto> crmBangDto = InnRoomHelper.obtCrmBang(22634,100, comparePriceConf.getOtaCode());
            log.info("CRM数据json:"+ JacksonUtil.obj2json(crmBangDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCp(){
        OmsComparePriceInnRoom omsComparePriceInnRoom = new OmsComparePriceInnRoom();
        omsComparePriceInnRoom.setSpecialStartDate("2016-05-25");
        omsComparePriceInnRoom.setSpecialEndDate("2016-06-05");
        //获取spider 去哪儿房价数据
        try {
            List<SpiderData> spiderData = InnRoomHelper.obtSpider(omsComparePriceInnRoom,"573cd69e80fe083e8cf2f697");
            log.info("spider数据json:"+ JacksonUtil.obj2json(spiderData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testComparePrice(){
        OmsComparePriceInnRoom omsComparePriceInnRoom = new OmsComparePriceInnRoom();
        omsComparePriceInnRoom.setRecordCode("2016032518460514589027654388");
        InnRoomHelper.updateRecordCode(omsComparePriceInnRoom, ComparePriceEnum.PROBLEM);
    }

    @Test
    public void  testPush(){
        String json = "{\"projectName\":\"oms\",\"bizType\":\"PRICE_AUDIT\",\"content\":{\"innId\":\"49463\",\"accountId\":33557,\"recordCode\":\"2016052018034014637386200411\",\"priceStatus\":\"CHECKED\",\"priceTime\":\"2016-05-20 10:03:41\",\"context\":\"温馨大床房温馨大床房温馨大床房温馨大床房,改价了!时间范围(2016-05-20~2016-05-20)\",\"innName\":\"番茄mumu测试客栈\",\"otaId\":102,\"otaName\":\"代销平台\",\"userCode\":\"DX\",\"specialStartDate\":\"2016-05-24\",\"specialEndDate\":\"2016-05-30\",\"tomatoOmsOtaRoomtypeList\":[{\"primaryKeys\":null,\"id\":115765,\"accountId\":null,\"roomTypeId\":78435,\"sellingPrice\":null,\"initialPrice\":null,\"createAt\":null,\"status\":null,\"roomTypeName\":\"温馨大床房温馨大床房温馨大床房温馨大床房\",\"wgRoomTypeId\":null,\"wgProductIds\":null,\"wgOrderType\":null,\"maxRoomNums\":null}]}}";
        JSONObject jsonObject = JSON.parseObject(json);
        eventResolver.pushEvent(jsonObject);
    }

    @Test
    public void testDateUtil(){
        String startDate = DateUtil.fromDate(0);
        String endDate = DateUtil.fromDate(30);
        System.out.println(startDate+endDate);
    }





}

