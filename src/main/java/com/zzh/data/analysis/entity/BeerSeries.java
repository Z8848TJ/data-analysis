package com.zzh.data.analysis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 映射字典 beer_map
 */
@TableName(value ="beer_series_map")
@Data
public class BeerSeries implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 第一关键字
     */
    private String firstKey;

    /**
     * 第二关键字
     */
    private String secondKey;

    /**
     * 第三关键字
     */
    private String thirdKey;

    /**
     * 第四关键字
     */
    private String fourthKey;

    /**
     * 映射值
     */
    private String result;

    /**
     *  创建时间
     */
    @TableField(exist = false)
    private Date createTime;

    /**
     *  更新时间
     */
    @TableField(exist = false)
    private Date updateTime;

    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = 1L;
}