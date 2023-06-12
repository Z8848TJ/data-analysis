package com.zzh.data.analysis.service;

import com.zzh.data.analysis.entity.BeerSeries;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author zhh
* @description 映射字典表 Service 接口
*/
public interface BeerSeriesService extends IService<BeerSeries> {

    Map<String, List<BeerSeries>> getBeerMap();
    
}
