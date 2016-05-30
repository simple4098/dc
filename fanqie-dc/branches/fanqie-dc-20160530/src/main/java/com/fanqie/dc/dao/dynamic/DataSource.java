package com.fanqie.dc.dao.dynamic;

import java.lang.annotation.*;

/**
 * desc:数据源类型标签
 * author:lzb
 * date:2015/9/10
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String name() default DataSource.DC;

    public static final String DC = "dc";

    public static final  String PMS = "pms";

    public  static final String OMS = "oms";

    public static final  String CRM = "crm";
    public static final  String CP = "cp";

}
