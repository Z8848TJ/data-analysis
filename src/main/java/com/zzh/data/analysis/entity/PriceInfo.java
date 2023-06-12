package com.zzh.data.analysis.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@EqualsAndHashCode
public class PriceInfo {

    public static Map<String, Field> filedMap;
    
    static {
        filedMap = new HashMap<>();
        Class<PriceInfo> priceInfoClass = PriceInfo.class;
        try {
            
            filedMap.put("查价时间", priceInfoClass.getDeclaredField("checkTime"));
            filedMap.put("平台名称", priceInfoClass.getDeclaredField("platformName"));
            filedMap.put("大区", priceInfoClass.getDeclaredField("region"));
            filedMap.put("城市", priceInfoClass.getDeclaredField("city"));
            filedMap.put("单价", priceInfoClass.getDeclaredField("unitPrice"));
            filedMap.put("到手价", priceInfoClass.getDeclaredField("finalPrice"));
            filedMap.put("产品日期", priceInfoClass.getDeclaredField("priceDifference"));
            filedMap.put("限购件数", priceInfoClass.getDeclaredField("purchaseLimit"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    
    @ExcelProperty("查价时间")
    private String checkTime;     // 查价时间
    @ExcelProperty("平台名称")
    private String platformName;  // 平台名称
    @ExcelProperty("大区")
    private String region;        // 大区
    @ExcelProperty("城市")
    private String city;          // 城市
    @ExcelProperty("单价")
    private double unitPrice;     // 单价
    @ExcelProperty("到手价")
    private double finalPrice;    // 到手价
    @ExcelProperty("差价")
    private double priceDifference;  // 差价
    @ExcelProperty("产品日期")
    private String productDate;   // 产品日期
    @ExcelProperty("限购件数")
    private int purchaseLimit;    // 限购件数
    
    
}

