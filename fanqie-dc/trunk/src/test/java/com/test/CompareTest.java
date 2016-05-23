
package com.test;

import com.fanqie.dc.bean.cp.ComparePriceConf;
import com.fanqie.dc.bean.cp.OmsComparePriceInnRoom;
import com.fanqie.dc.dto.CrmBangDto;
import com.fanqie.dc.dto.SpiderData;
import com.fanqie.dc.enumeration.ComparePriceEnum;
import com.fanqie.dc.service.IComparePriceConfService;
import com.fanqie.dc.support.helper.InnRoomHelper;
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
        omsComparePriceInnRoom.setSpecialStartDate("2016-05-19");
        omsComparePriceInnRoom.setSpecialEndDate("2016-05-29");
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






}

