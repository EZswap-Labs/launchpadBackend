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
public class LaunchpadVo {

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

    private Long userId;
    private String privatePrice;
    private String publicPrice;
    private String roadmap;
    private String team;
    private String mintSalePayoutAddress;
    private String royaltyPayoutAddress;
    private Integer showFirstPage;
    private Integer sortNum;
    private String network;
    private String erc;
    private String currentTokenId;
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
    private Integer haveWhiteMint;
    private Integer havePrivateMint;
    private Integer havePublicMint;
    private Integer launchpadType;

}
