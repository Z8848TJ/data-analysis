package com.zzh.data.analysis.service.promotion.impl;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import org.springframework.stereotype.Component;

/**
 * @author: zzh
 * @description: 购买至少1件时可享受优惠
 */
@Component
public class FourthPromotionWayImpl implements PromotionWay {
    
    @Override
    public int calculate(double price) {
        return (int)price;
    }
}
