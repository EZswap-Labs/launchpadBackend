package com.ezswap.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
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
@Builder
public class ArtBannerVo {

    private Long id;

    private Long launchpadId;
    private Integer sortNum;
    private Integer isDel;
    private Long createTime;
    private Long startTime;
    private Long endTime;
    private String network;


}
