package com.zzh.data.analysis.service.promotion.impl;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import org.springframework.stereotype.Component;

/**
 * @author: zzh
 * @description: 购买至少1件时可享受优惠, 满2149元减130元
 */
@Component
public class FirstPromotionWayImpl implements PromotionWay {
    @Override
    public int calculate(double price) {
        int i = 1;
        
        while(price * i < 2149) {
            i++;
        }
        
        return (int)(price * i - 130) / i;
    }
}
