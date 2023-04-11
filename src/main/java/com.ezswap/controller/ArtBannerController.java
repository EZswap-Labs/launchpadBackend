package com.ezswap.controller;

import com.ezswap.common.dto.ResultDto;
import com.ezswap.common.tool.ResultTool;
import com.ezswap.entry.Launchpad;
import com.ezswap.mapper.ArtBannerMapper;
import com.ezswap.vo.ArtBannerVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器 custom
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-07
 */
@Validated
@RestController
@RequestMapping("/artBanner")
public class ArtBannerController {
    @Resource
    public ArtBannerMapper artBannerMapper;

    @PostMapping(value = "/queryList")
    public ResultDto queryList(@RequestBody ArtBannerVo artBannerVo) {
        artBannerVo.setStartTime(System.currentTimeMillis());
        artBannerVo.setEndTime(System.currentTimeMillis());
        List<Launchpad> artBannerList = artBannerMapper.selfFindList(artBannerVo);
        return ResultTool.success(artBannerList);
    }
}
