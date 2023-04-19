package com.ezswap.entry;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("LaunchpadMetadataStandard")
public class LaunchpadMetadataStandard {

    private String name;
    private String description;
    private String image;
    private Integer decimals;
    private String external_url;
    private String image_url;
    private String tokenId;
    private List<Object> attributes;
}
