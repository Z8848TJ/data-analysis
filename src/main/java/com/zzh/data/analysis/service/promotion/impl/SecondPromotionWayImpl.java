package com.zzh.data.analysis.service.promotion.impl;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import org.springframework.stereotype.Component;

/**
 * @author: zzh
 * @description: 购买1-3件时享受单件价¥1969，超出数量以结算价为准,满399减10
 */
@Component
public class SecondPromotionWayImpl implements PromotionWay {
    
    @Override
    public int calculate(double price) {
        return (int)price - 10;
    }
}
