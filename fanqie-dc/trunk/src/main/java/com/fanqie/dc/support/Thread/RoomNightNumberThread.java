package com.fanqie.dc.support.Thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fanqie.dc.bean.RoomNightNumber;
import com.fanqie.dc.service.IOmsStatisticalService;
import com.fanqie.util.DateUtil;

public class RoomNightNumberThread extends Thread {
	// 统计间夜数的月份，格式"yyyy-MM"
	private String nowDate;
	private IOmsStatisticalService omsStatisticalService;
	private Logger logger = LoggerFactory.getLogger(RoomNightNumberThread.class);

	public String getNowDate() {
		return nowDate;
	}

	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}

	public RoomNightNumberThread(String nowDate, IOmsStatisticalService omsStatisticalService) {
		this.nowDate = nowDate;
		this.omsStatisticalService = omsStatisticalService;
	}

	public void run() {
		List<Date> list = new ArrayList<>();
		if (nowDate == null || nowDate.equals("")) {
			Date pastDate = DateUtil.addDay(new Date(), -1);
			Date pastDateFormat = DateUtil.parseDate(DateUtil.format(pastDate));
			list.add(pastDateFormat);
		} else {
			list = DateUtil.mouthDays(nowDate);
		}
		try {
			for (Date date : list) {
				logger.debug("========statistical the date of room night number is : "
						+ DateUtil.format(date, DateUtil.FORMAT_DATE_STR_SECOND));
				List<RoomNightNumber> roomNightNumberList = omsStatisticalService.getRoomNightNumber(date);
				omsStatisticalService.addRoomNightNumberToCrm(roomNightNumberList, date);
			}
			logger.info("========statistical the date of room night number is successful");
		} catch (Exception e) {
			logger.error("fail to statistical number of room nights.Parameter : nowDate = " + nowDate, e);
		}
	}

}
