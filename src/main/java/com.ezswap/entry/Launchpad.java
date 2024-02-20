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
//    {
//        0: 'Deleted',
//            1: 'Draft',
//            2: 'Deployed',
//            3: 'Minting',
//            4: 'Mint Ended',
//    }
    private Integer status;

    private Integer totalSupply;

    private Integer publicMintCount;
    private Integer privateMintCount;
    private Integer airdropMintCount;
    private Integer whiteMintMintCount;

    private String contractAddress;

    private Integer publicEveryUserMintLimit;

    private Long airdropStartTime;
    private Long whiteMintStartTime;

    private Long airdropEndTime;
    private Long whiteMintEndTime;

    private Integer airdropSupply;
    private Integer whiteMintSupply;

    private Integer airdropEveryUserMintLimit;
    private Integer whiteMintEveryUserMintLimit;

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

    private String privatePrice;
    private String publicPrice;
    private String tokenUrl;
    private String roadmap;
    private String team;
    private String mintSalePayoutAddress;
    private String royaltyPayoutAddress;
    private Integer showFirstPage;
    private Integer sortNum;
    private String network;
    private String erc;
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String userLogo;
    private String currentTokenId;

    @TableField(exist = false)
    private UserAccount userAccount;
    private Integer canCreditCard;
    private Integer startMode;
    private String whiteFee;
    private String privateFee;
    private String publicFee;
    private String baseUri;
    private String signer;
    private Integer publicEveryUserMinMintLimit;
    private Integer privateEveryUserMinMintLimit;
    private Integer whiteMintEveryUserMinMintLimit;
    private Integer airdropEveryUserMinMintLimit;
    private String payType;
    private Integer jumpType;
    private String jumpUrl;
    private Integer haveWhiteMint;
    private Integer havePrivateMint;
    private Integer havePublicMint;
    private Integer launchpadType;
}
