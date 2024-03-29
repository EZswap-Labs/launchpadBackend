package com.ezswap.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ezswap.entry.LaunchpadWhite;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-07
 */
public interface LaunchpadWhiteMapper extends BaseMapper<LaunchpadWhite> {
    public void createBATCH(List<LaunchpadWhite> list);
}
