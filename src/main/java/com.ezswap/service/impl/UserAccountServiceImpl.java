package com.ezswap.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ezswap.entry.UserAccount;
import com.ezswap.mapper.UserAccountMapper;
import com.ezswap.service.IUserAccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类 c
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-04
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
