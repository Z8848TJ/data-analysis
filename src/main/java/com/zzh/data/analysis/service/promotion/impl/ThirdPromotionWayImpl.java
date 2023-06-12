package com.zzh.data.analysis.service.promotion.impl;

import com.zzh.data.analysis.service.promotion.PromotionWay;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: zzh
 * @description: 满4999减150, 满3999减120, 满2999减90, 满1999减60, 满999减30
 */
@Component
public class ThirdPromotionWayImpl implements PromotionWay {
    @Override
    public int calculate(double price) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int i = 1;
        
        while(true) {
            int num = (int)price * i;
            if(num >= 4999) {
                list.add((num - 150) / i);
                list.add((num - 120) / i);
                list.add((num - 90) / i);
                list.add((num - 60) / i);
                list.add((num - 30) / i);
                break;
            } else if(num >= 3999) {
                list.add((num - 120) / i);
                list.add((num - 90) / i);
                list.add((num - 60) / i);
                list.add((num - 30) / i);
            } else if(num > 2999) {
                list.add((num - 90) / i);
                list.add((num - 60) / i);
                list.add((num - 30) / i);
            } else if(num >= 1999){
                list.add((num - 60) / i);
                list.add((num - 30) / i);
            } else if(num >= 999) {
                list.add((num - 30) / i);
            }
            i++;
        }
        
        return Collections.min(list);
    }
}
