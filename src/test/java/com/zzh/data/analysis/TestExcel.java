package com.zzh.data.analysis;

import com.alibaba.excel.EasyExcel;
import com.zzh.data.analysis.entity.Product;
import com.zzh.data.analysis.listener.PriceInfoListener;
import com.zzh.data.analysis.entity.PriceInfo;
import com.zzh.data.analysis.listener.SKUListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: zzh
 * @description: excel 测试类
 */
@SpringBootTest
@Slf4j
public class TestExcel {
    
    private final String filePath = "D:\\downLoad\\excel\\";

    @Test
    public void testSplitExcel() {
        splitExcel("大区");
    }
    
    @Test
    public void testSKUSplit() {
        String fileName = filePath + "raw_test.xlsx";
        EasyExcel.read(fileName, Product.class, new SKUListener(filePath)).sheet().doRead();
    }
    
    public void splitExcel(String column) {
        String fileName = filePath + "test.xlsx";
        EasyExcel.read(fileName, PriceInfo.class, new PriceInfoListener(column, filePath)).sheet().doRead();
    }
}
