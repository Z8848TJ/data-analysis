package com.zzh.data.analysis.mapper;

import com.zzh.data.analysis.entity.Beer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzh
* @description 啤酒系列表 Mapper
*/
@Mapper
public interface BeerMapper extends BaseMapper<Beer> {

    void updateBeers(@Param("beers") List<Beer> beers);
}




