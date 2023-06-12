package com.zzh.data.analysis.listener;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.zzh.data.analysis.entity.PriceInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author: zzh
 * @description: 商品信息监听器
 */
@Slf4j
public
class PriceInfoListener implements ReadListener<PriceInfo> {
    
    private final String filePath;
    
    private final String column;
    
    private final Map<String, List<PriceInfo>> map = new HashMap<>();
    
    public PriceInfoListener(String column, String filePath) {
        this.column = column;
        this.filePath = filePath;
    }
    
    
    
    @Override
    public void invoke(PriceInfo data, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        Field field = PriceInfo.filedMap.get(column);
        field.setAccessible(true);
        
        try {
            String o = field.get(data).toString();
            List<PriceInfo> list;
            if (map.containsKey(o)) {
                list = map.get(o);
                list.add(data);
            } else {
                list = ListUtils.newArrayListWithCapacity(200);
                list.add(data);
                map.put(o, list);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        
        Set<String> keySet = map.keySet();
        
        for (String key : keySet) {
            String fileName = filePath + "\\" + key + ".xlsx";
            File file = new File(fileName);
            // 创建文件
            if(!file.exists()) {
                try {
                    boolean newFile = file.createNewFile();
                    log.info("创建文件{} ==> {}", fileName, newFile);
                } catch (IOException e) {
                    log.error("创建文件失败 ==> {}, {}", fileName, e.getMessage());
                }
            }
            
            EasyExcel.write(fileName, PriceInfo.class)
                    .sheet("模板")
                    .doWrite(map.getOrDefault(key, new ArrayList<>()));
        }
        
        log.info("所有数据解析完成！");
    }
}
