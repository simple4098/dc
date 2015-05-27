package com.fanqie.dc.support.util;

import com.fanqie.core.domain.InnCustomer;
import org.apache.commons.lang3.StringUtils;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
public class CustomerUtil {
    private CustomerUtil(){}

    public static void innCustomerCityAndProvince(InnCustomer customer){
        if (StringUtils.isEmpty(customer.getProvince())){
            customer.setProvince(null);
        }else {
            if (customer.getProvince().indexOf("-")!=-1){
                customer.setProvince(null);
            }
        }
        if (StringUtils.isEmpty(customer.getCity())){
            customer.setCity(null);
        }else {
            if (customer.getCity().indexOf("-")!=-1){
                customer.setCity(null);
            }
        }
    }
}
