package com.ezswap.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ezswap.entry.Launchpad;
import com.ezswap.entry.UserAccount;
import com.ezswap.vo.UserAccountVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-04
 */
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    List<Launchpad> selfFindList(UserAccountVo userAccountVo);
}
