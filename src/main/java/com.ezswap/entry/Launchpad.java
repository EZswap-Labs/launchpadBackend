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
@TableName("launchpad")
public class Launchpad implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String collectionName;

    private String symbol;

    private String description;

    private Long publicStartTime;

    private Long publicEndTime;

    private Double royalties;

    private String bannerUrl;

    private String imgUrl;

    private Integer isDel;

    private Long userId;

    private Long createTime;

    private Integer status;

    private Integer totalSupply;

    private Integer mintCount;

    private String contractAddress;

    private Integer publicEveryUserMintLimit;

    private Long airdropStartTime;

    private Long airdropEndTime;

    private Integer airdropSupply;

    private Integer airdropEveryUserMintLimit;

    private String discord;

    private String twitter;

    private String medium;

    private String telegram;

    private String galxe;

    private Long privateStartTime;

    private Long privateEndTime;

    private Integer privateEveryUserMintLimit;

    private Integer privateSupply;

    private Integer publicSupply;

    private String website;

    private Long privatePrice;
    private Long publicPrice;
    private String tokenUrl;
    @TableField(exist = false)
    private UserAccount userAccount;

}
