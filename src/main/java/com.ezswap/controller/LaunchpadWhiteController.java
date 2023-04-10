package com.ezswap.controller;

import com.ezswap.common.dto.ResultDto;
import com.ezswap.common.tool.ResultTool;
import com.ezswap.entry.LaunchpadWhite;
import com.ezswap.service.ILaunchpadWhiteService;
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
@RequestMapping("/launchpadWhite")
public class LaunchpadWhiteController {
    @Resource
    public ILaunchpadWhiteService launchpadWhiteService;

    @PostMapping(value = "/addLaunchpadWhite")
    public ResultDto addLaunchpadWhite(
        Long id,
        Long userId,
        Long launchpadId,
        Long createTime,
        Integer isDel,
        String walletAddress,
        Integer launchpadStep,
        Integer mintCount
    ){
        LaunchpadWhite launchpadWhite = new LaunchpadWhite();
        launchpadWhite.setId(id);
        launchpadWhite.setUserId(userId);
        launchpadWhite.setLaunchpadId(launchpadId);
        launchpadWhite.setCreateTime(createTime);
        launchpadWhite.setIsDel(isDel);
        launchpadWhite.setWalletAddress(walletAddress);
        launchpadWhite.setLaunchpadStep(launchpadStep);
        launchpadWhite.setMintCount(mintCount);
        launchpadWhiteService.save(launchpadWhite);
        return ResultTool.success("");
    }

//    @PostMapping(value = "/deleteLaunchpadWhite")
//    @ApiOperation(value = "删除")
//    public ApiResult deleteLaunchpadWhite(@NotNull Long id){
//        //TODO
//        return ApiResult.ok();
//    }
//
//    @PostMapping(value = "/selectLaunchpadWhiteListByPage")
//    @ApiOperation(value = "分页查询")
//    public ApiResult selectLaunchpadWhiteListByPage(
//        @NotNull(message = "page不能为空") @Min(value = 1, message = "page不能小于1") Integer page,
//        @NotNull(message = "size不能为空") @Min(value = 1, message = "size不能小于1") @Max(value = 20, message = "size不能大于20") Integer size
//    ){
//        BasePage<LaunchpadWhite> pageResult = launchpadWhiteService.lambdaQuery().page(new BasePage<>(page, size));
//        return ApiResult.ok(new BasePage(page,size,pageResult.getTotal(),launchpadWhiteService.poToDto(pageResult.getResult(),LaunchpadWhiteDTO.class)));
//    }


}
