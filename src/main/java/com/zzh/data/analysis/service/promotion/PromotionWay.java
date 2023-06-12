package com.zzh.data.analysis.service.promotion;

/**
 * @author: zzh
 * @description: 优惠方式接口
 */
public interface PromotionWay {

    /**
     * 计算最低价
     * @param price 页面价格
     * @return 最低价
     */
    int calculate(double price);
    
}
