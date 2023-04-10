package com.ezswap.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("art_banner")
public class ArtBanner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long launchpadId;
    private Integer sortNum;
    private Integer isDel;
    private Long createTime;
    private Long startTime;
    private Long endTime;
    private String network;


}
