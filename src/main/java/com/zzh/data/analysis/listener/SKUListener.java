package com.zzh.data.analysis.listener;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson2.JSON;
import com.zzh.data.analysis.entity.Product;
import com.zzh.data.analysis.entity.SUKInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zzh
 * @description: SUK 监听器
 */
@Slf4j
public class SKUListener implements ReadListener<Product> {

    private final List<Product> cachedList = new ArrayList<>();
    
    private final String filePath;

    public SKUListener(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void invoke(Product data, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        
        String sukJSON = data.getSkuJSON();
        List<SUKInfo> sukInfoList = JSON.parseArray(sukJSON, SUKInfo.class);

        for (SUKInfo sukInfo : sukInfoList) {
            data.setSkuId(sukInfo.getSku_id());
            data.setSkuName(sukInfo.getSku_name());
            data.setSkuOriginalPrice(sukInfo.getSku_original_price());
            data.setSkuCurrentPrice(sukInfo.getSku_current_price());
            data.setSkuStock(sukInfo.getSku_stock());
            cachedList.add(data);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        String fileName = filePath + "sku.xlsx";
        ArrayList<String> column = new ArrayList<>();
        column.add("skuJSON");
        EasyExcel.write(fileName, Product.class)
                .excludeColumnFieldNames(column)
                .sheet("模板")
                .doWrite(cachedList);
    }
}
