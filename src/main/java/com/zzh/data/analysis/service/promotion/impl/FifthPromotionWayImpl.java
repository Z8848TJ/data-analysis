package com.zzh.data.analysis.service.promotion.impl;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import org.springframework.stereotype.Component;

/**
 * @author: zzh
 * @description: 无
 */
@Component
public class FifthPromotionWayImpl implements PromotionWay {
    @Override
    public int calculate(double price) {
        return (int)price;
    }
}
