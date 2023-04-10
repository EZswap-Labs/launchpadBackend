package com.ezswap.controller;

import com.ezswap.common.dto.ResultDto;
import com.ezswap.common.tool.ResultTool;
import com.ezswap.entry.LaunchpadNft;
import com.ezswap.service.ILaunchpadNftService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
*  前端控制器 custom
* </p>
*
* @author mybatisplus
* @since 2023-04-07
*/
@Validated
@RestController
@RequestMapping("/launchpadNft")
public class LaunchpadNftController {
    @Resource
    public ILaunchpadNftService launchpadNftService;

    @PostMapping(value = "/addLaunchpadNft")
    public ResultDto addLaunchpadNft(
        Long id,
        Long userId,
        Long launchpadId,
        Long createTime,
        Integer isDel,
        Long tokenId,
        String nftImg,
        String metadataUrl,
        String nftName,
        String nftDescription,
        String nftType,
        String nftAddress
    ){
        LaunchpadNft launchpadNft = new LaunchpadNft();
        launchpadNft.setId(id);
        launchpadNft.setUserId(userId);
        launchpadNft.setLaunchpadId(launchpadId);
        launchpadNft.setCreateTime(createTime);
        launchpadNft.setIsDel(isDel);
        launchpadNft.setTokenId(tokenId);
        launchpadNft.setNftImg(nftImg);
        launchpadNft.setMetadataUrl(metadataUrl);
        launchpadNft.setNftName(nftName);
        launchpadNft.setNftDescription(nftDescription);
        launchpadNft.setNftType(nftType);
        launchpadNft.setNftAddress(nftAddress);
        launchpadNftService.save(launchpadNft);
        return ResultTool.success("");
    }

//    @PostMapping(value = "/deleteLaunchpadNft")
//    @ApiOperation(value = "删除")
//    public ApiResult deleteLaunchpadNft(@NotNull Long id){
//        //TODO
//        return ApiResult.ok();
//    }

//    @PostMapping(value = "/selectLaunchpadNftListByPage")
//    @ApiOperation(value = "分页查询")
//    public ApiResult selectLaunchpadNftListByPage(){
//    }


}
