package com.zzh.data.analysis.service.promotion.factory;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import org.springframework.stereotype.Component;

/**
 * @author: zzh
 * @description: 优惠方法工厂
 */
@Component
public class PromotionWayFactory extends PromotionWayConfig{
    
    public PromotionWay getPromotionWay(String info) {
        return promotionWayMap.get(info);
    }
    
}
