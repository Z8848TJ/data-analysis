package com.zzh.data.analysis;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.data.analysis.entity.Beer;
import com.zzh.data.analysis.entity.BeerSeries;
import com.zzh.data.analysis.service.BeerSeriesService;
import com.zzh.data.analysis.service.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author: zzh
 * @description: 打标签测试类
 */
@SpringBootTest
@Slf4j
public class TestTag {
    
    @Autowired
    private BeerSeriesService beerSeriesService;
    
    @Autowired
    private BeerService beerService;
    
    @Test
    public void test() {
        // 1. 获取映射字典
        Map<String, List<BeerSeries>> beerMap = beerSeriesService.getBeerMap();
        
        // 2. 分批查询商品表
        Page<Beer> beerList = beerService.getBeerList(1, 10);
        
        // 3. 打系列标签
        List<Beer> records = beerList.getRecords();
        int i = 0;
        String[] series = {"其他", "清爽", "雪花其他", "淡爽", "花生巧克力牛奶世涛", "花生巧克力牛奶世涛", "海妖精酿其他"};
        for (Beer record : records) {
            String tag = beerService.confirmTag(record.getBrand(), record.getName(), beerMap);
            Assertions.assertEquals(series[i++], tag);
            record.setSeries(tag);
        }

        log.info("商品列表 ==> {}", records);
        
        // 4. 更新系列标签
        beerService.updateBeer(records);
    }
    
}
