package com.zzh.data.analysis.service.promotion.factory;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import com.zzh.data.analysis.service.promotion.impl.*;
import com.zzh.data.analysis.util.Constants;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zzh
 * @description: 优惠方法配置类
 */
public class PromotionWayConfig {
    
    @Autowired
    private FirstPromotionWayImpl firstPromotionWay;

    @Autowired
    private SecondPromotionWayImpl secondPromotionWay;

    @Autowired
    private ThirdPromotionWayImpl thirdPromotionWay;

    @Autowired
    private FourthPromotionWayImpl fourthPromotionWay;

    @Autowired
    private FifthPromotionWayImpl fifthPromotionWay;
    
    protected static Map<String, PromotionWay> promotionWayMap = new ConcurrentHashMap<>();
    
    @PostConstruct
    public void init() {
        promotionWayMap.put(Constants.PromotionType.First.getInfo(), firstPromotionWay);
        promotionWayMap.put(Constants.PromotionType.Second.getInfo(), secondPromotionWay);
        promotionWayMap.put(Constants.PromotionType.Third.getInfo(), thirdPromotionWay);
        promotionWayMap.put(Constants.PromotionType.Fourth.getInfo(), fourthPromotionWay);
        promotionWayMap.put(Constants.PromotionType.Fifth.getInfo(), fifthPromotionWay);
    }
    
}
