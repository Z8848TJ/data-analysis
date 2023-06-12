package com.zzh.data.analysis;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import com.zzh.data.analysis.service.promotion.factory.PromotionWayConfig;
import com.zzh.data.analysis.service.promotion.factory.PromotionWayFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: zzh
 * @description: 计算最低到手价
 */


@SpringBootTest
@Slf4j
public class TestPrice {
    
    @Autowired
    private PromotionWayFactory promotionWayFactory;
    
    @Test
    public void testPrice() {
        Assertions.assertEquals(2004, 
                calculatePrice(2069.00, "购买至少1件时可享受优惠,满2149元减130元"));
        
        Assertions.assertEquals(1959,
                calculatePrice(1969.00, "购买1-3件时享受单件价¥1969，超出数量以结算价为准,满399减10"));
        
        Assertions.assertEquals(1849,
                calculatePrice(1899, "满4999减150,满3999减120,满2999减90,满1999减60,满999减30"));
        
        Assertions.assertEquals(440,
                calculatePrice(440, "购买至少1件时可享受优惠"));
        
        Assertions.assertEquals(529,
                calculatePrice(529, "无"));
                
        
        
    }
    
    public int calculatePrice(double price, String message) {
        PromotionWay promotionWay = promotionWayFactory.getPromotionWay(message);
        
        return promotionWay.calculate(price);
    }
    
}
