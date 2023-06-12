package com.zzh.data.analysis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.data.analysis.entity.BeerSeries;
import com.zzh.data.analysis.entity.Beer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author zzh
* @description 啤酒商品表 Service 接口
*/
public interface BeerService extends IService<Beer> {

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 页容量
     * @return 查询结果
     */
    Page<Beer> getBeerList(int pageNo, int pageSize);

    /**
     * 打系列标签
     * @param brand 品牌
     * @param name 商品名称
     * @param beerMap 映射字典
     * @return 系列标签
     */
    String confirmTag(String brand, String name, Map<String, List<BeerSeries>> beerMap);

    /**
     * 更新系列标签
     * @param beers 商品列表
     */
    void updateBeer(List<Beer> beers);
    
}
