package com.zzh.data.analysis.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class Product {
    @ExcelProperty("平台")
    private String platform; // 平台

    @ExcelProperty("关键词")
    private String keywords; // 关键词

    @ExcelProperty("品类")
    private String category; // 品类

    @ExcelProperty("商品名称")
    private String productName; // 商品名称

    @ExcelProperty("商品id")
    private String productId; // 商品ID
    
    @ExcelProperty("商品链接")
    private String productLink; // 商品链接

    @ExcelProperty("商品sku详情")
    private String skuJSON;   // SUN Json

    @ExcelProperty("SKU ID")
    private String skuId; // SKU ID

    @ExcelProperty("SKU 名称")
    private String skuName; // SKU 名称

    @ExcelProperty("SKU 现价")
    private double skuCurrentPrice; // SKU 现价

    @ExcelProperty("SKU 原价")
    private double skuOriginalPrice; // SKU 原价

    @ExcelProperty("SKU 库存")
    private int skuStock; // SKU 库存

    @ExcelProperty("现价")
    private String currentPrice; // 现价

    @ExcelProperty("原价")
    private String originalPrice; // 原价

    @ExcelProperty("月销量")
    private int monthlySales; // 月销量

    @ExcelProperty("评论数量")
    private int commentCount; // 评论数量

    @ExcelProperty("库存数量")
    private int stockCount; // 库存数量

    @ExcelProperty("收藏数量")
    private int favoriteCount; // 收藏数量

    @ExcelProperty("商品评分")
    private double productRating; // 商品评分

    @ExcelProperty("商品状态")
    private String productStatus; // 商品状态

    @ExcelProperty("发货地")
    private String deliveryLocation; // 发货地

    @ExcelProperty("促销信息")
    private String promotionInfo; // 促销信息

    @ExcelProperty("商品描述")
    private String productDescription; // 商品描述

    @ExcelProperty("商品规格")
    private String productSpecification; // 商品规格

    @ExcelProperty("支付方式")
    private String paymentMethod; // 支付方式

    @ExcelProperty("服务承诺")
    private String servicePromise; // 服务承诺

    @ExcelProperty("店铺名称")
    private String storeName; // 店铺名称

    @ExcelProperty("店铺评分")
    private String storeRating; // 店铺评分

    @ExcelProperty("店铺ID")
    private String storeId; // 店铺ID

    @ExcelProperty("店铺链接")
    private String storeLink; // 店铺链接

    @ExcelProperty("店铺粉丝数量")
    private int storeFanCount; // 店铺粉丝数量

    @ExcelProperty("开店时间")
    private String storeOpeningTime; // 开店时间

    @ExcelProperty("商品详情")
    private String productDetails; // 商品详情

    @ExcelProperty("商品主图")
    private String productMainImage; // 商品主图

    @ExcelProperty("商品详图")
    private String productDetailedImages; // 商品详图

    @ExcelProperty("旺旺ID")
    private String wangwangId; // 旺旺ID

    @ExcelProperty("旺旺名称")
    private String wangwangName; // 旺旺名称

    

}
