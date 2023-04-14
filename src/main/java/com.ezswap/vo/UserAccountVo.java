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
public class UserAccountVo {

    private Long id;

    private String email;

    private String password;

    private String walletAddress;

    private Long createTime;

    private Integer isDel;

    private String userName;

    private String userLogo;

    private Integer isVerify;

    private Integer accountRole;
    private Integer showFirstPage;
    private Integer sortNum;
    private String collectionName;
    private String contractAddress;
    private String contractAddressOrName;
}
