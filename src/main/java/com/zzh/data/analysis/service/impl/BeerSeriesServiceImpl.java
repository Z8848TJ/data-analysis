package com.zzh.data.analysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.data.analysis.entity.BeerSeries;
import com.zzh.data.analysis.service.BeerSeriesService;
import com.zzh.data.analysis.mapper.BeerSeriesMapper;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author zzh
* @description 映射字典表 Service 实现类
*/
@Service
public class BeerSeriesServiceImpl extends ServiceImpl<BeerSeriesMapper, BeerSeries>
    implements BeerSeriesService {

    
    @Override
    public Map<String, List<BeerSeries>> getBeerMap() {
        
        List<BeerSeries> beerSeriesList = baseMapper.selectList(new QueryWrapper<>());
        HashMap<String, List<BeerSeries>> result = new HashMap<>();
        
        for (BeerSeries beerSeries : beerSeriesList) {
            String brand = beerSeries.getBrand();
            if (result.containsKey(brand)) {
                List<BeerSeries> list = result.get(brand);
                list.add(beerSeries);
            } else {
                ArrayList<BeerSeries> list = new ArrayList<>();
                list.add(beerSeries);
                result.put(brand, list);
            }
        }
        
        return  result;
    }
}




