package com.ezswap.entry;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("launchpad_nft")
public class LaunchpadNft implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long launchpadId;

    private Long createTime;

    private Integer isDel;

    private Long tokenId;

    private String nftImg;

    private String metadataUrl;

    private String nftName;

    private String nftDescription;

    private String nftType;

    private String nftAddress;


}
