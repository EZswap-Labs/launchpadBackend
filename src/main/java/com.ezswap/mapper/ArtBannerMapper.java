package com.ezswap.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ezswap.entry.ArtBanner;
import com.ezswap.entry.Launchpad;
import com.ezswap.entry.LaunchpadNft;
import com.ezswap.vo.ArtBannerVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-07
 */
public interface ArtBannerMapper extends BaseMapper<ArtBanner> {

    List<Launchpad> selfFindList(ArtBannerVo artBannerVo);
}
