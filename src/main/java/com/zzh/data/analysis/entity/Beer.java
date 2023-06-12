package com.zzh.data.analysis.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 啤酒标签表 beer
 */
@TableName(value ="beer")
@Getter
@Setter
public class Beer implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 系列
     */
    private String series;

    /**
     * 创建时间
     */
    @TableField(exist = false)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(exist = false)
    private Date updateTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}