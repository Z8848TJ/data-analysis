package com.zzh.data.analysis.util;

import java.util.UUID;

/**
 * @author: zzh
 * @description: 工具类
 */
public class Util {

    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    
    // 判断是否为 null
    public static boolean isNull(String... values) {
        for (String value : values) {
            if(value == null) {
                return true;
            }
        }
        
        return false;
    }
}
