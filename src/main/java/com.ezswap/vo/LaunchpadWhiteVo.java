package com.ezswap.vo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("launchpad_white")
public class LaunchpadWhiteVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long launchpadId;

    private Long createTime;

    private Integer isDel;

    private String walletAddress;

    private Integer launchpadStep;

    private Integer mintCount;


}
