package com.zzh.data.analysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.data.analysis.entity.BeerSeries;
import com.zzh.data.analysis.entity.Beer;
import com.zzh.data.analysis.service.BeerService;
import com.zzh.data.analysis.mapper.BeerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.zzh.data.analysis.util.Util.isNull;

/**
 * @author zzh
 * @description 啤酒商品表 Service 实现类
 */
@Service
@Slf4j
public class BeerServiceImpl extends ServiceImpl<BeerMapper, Beer>
    implements BeerService {
    
    private static final String OTHER = "其他";
    
    @Autowired
    private BeerMapper beerMapper;

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 页容量
     * @return 查询结果
     */
    @Override
    public Page<Beer> getBeerList(int pageNo, int pageSize) {
        Page<Beer> beerPage = new Page<>(pageNo, pageSize);
        
        return baseMapper.selectPage(beerPage, new QueryWrapper<>());
    }

    /**
     * 打系列标签 
     * @param brand 品牌
     * @param name 商品名称
     * @param beerMap 映射字典     
     * @return 系列标签
     */
    @Override
    public String confirmTag(String brand, 
                             String name, 
                             Map<String, List<BeerSeries>> beerMap) {

        // 1.先识别品牌，如果品牌值是其他，那么系列就是其他
        if(OTHER.equals(brand)) {
            log.info("name ==> {}, tag ==> {}",name, OTHER);
            return OTHER;
        } else {
            // 2.如果品牌有值，那么根据商品名称去匹配第一关键字，匹配到了 就打上映射值的标签
            List<BeerSeries> beerSeriesList = beerMap.get(brand);
            
            String res;
            
            if((res = matchFirstKey(name, beerSeriesList)) != null) {
                log.info("name ==> {}, tag ==> {}",name, res);
                return res;
            }
            // 3.如果第一关键字匹配不到  就要求匹配2，3，4关键字（2 3 4是 and关系。需要都匹配到才可以）
            else if((res = matchOtherKey(name, beerSeriesList)) != null) {
                log.info("name ==> {}, tag ==> {}",name, res);
                return res;
            } else {
                // 4.如果最终品牌有值，系列没打上标签，那么系列值就等于 品牌+其他
                log.info("name ==> {}, tag ==> {}",name, brand + OTHER);
                return brand + OTHER;
            }

        }
        
    }

    /**
     * 更新系列标签
     * @param beers 商品列表
     */
    public void updateBeer(List<Beer> beers) {
        beerMapper.updateBeers(beers);
    }

    private String matchFirstKey(String name, List<BeerSeries> beerSeriesList) {
        
        for (BeerSeries beerSeries : beerSeriesList) {
            if(name.contains(beerSeries.getFirstKey())) {
                return beerSeries.getResult();
            }
        }
        
        return null;
    }
    
    private String matchOtherKey(String name, List<BeerSeries> beerSeriesList) {
        for (BeerSeries beerSeries : beerSeriesList) {
            String secondKey = beerSeries.getSecondKey();
            String thirdKey = beerSeries.getThirdKey();
            String fourthKey = beerSeries.getFourthKey();

            boolean flag = isNull(secondKey, thirdKey, fourthKey);
            
            if(!flag && name.contains(secondKey) &&
                    name.contains(thirdKey) &&
                    name.contains(fourthKey)){
                return beerSeries.getResult();
            }
        }
        
        return null;
    }
}




