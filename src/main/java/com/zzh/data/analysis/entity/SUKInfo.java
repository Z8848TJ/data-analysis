package com.zzh.data.analysis.entity;

import lombok.Data;

/**
 * @author: zzh
 * @description:
 */
@Data
public class SUKInfo {

    private String sku_id; // SKU ID

    private String sku_name; // SKU 名称

    private double sku_current_price; // SKU 现价

    private double sku_original_price; // SKU 原价

    private int sku_stock; // SKU 库存
    
}
