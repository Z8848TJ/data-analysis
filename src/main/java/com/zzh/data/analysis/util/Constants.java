package com.zzh.data.analysis.util;

/**
 * @author: zzh
 * @description: 常亮枚举类
 */
public class Constants {
    
    public enum PromotionType {

        First("购买至少1件时可享受优惠,满2149元减130元"),
        Second ("购买1-3件时享受单件价¥1969，超出数量以结算价为准,满399减10"),
        Third("满4999减150,满3999减120,满2999减90,满1999减60,满999减30"),
        Fourth("购买至少1件时可享受优惠"),
        Fifth ("无");
        
        private String info;

        PromotionType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }
    
}
