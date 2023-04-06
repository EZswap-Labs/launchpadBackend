package com.ezswap.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ezswap.common.dto.ResultDto;
import com.ezswap.common.tool.ResultTool;
import com.ezswap.entry.UserAccount;
import com.ezswap.service.IUserAccountService;
import com.ezswap.vo.UserAccountVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器 custom
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-04
 */
@Log4j2
@RestController
@RequestMapping("userAccount")
public class UserAccountController {
    @Resource
    public IUserAccountService userAccountService;

    @PostMapping(value = "/register")
    public ResultDto register(@RequestBody UserAccountVo userAccountVo) {

        List<UserAccount> list = userAccountService.lambdaQuery()
                .eq(UserAccount::getWalletAddress, userAccountVo.getWalletAddress())
                .or().eq(UserAccount::getEmail, userAccountVo.getEmail())
                .list();
        if (null != list && list.size() > 0) {
            return ResultTool.fail("wallet or email have registered");
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(userAccountVo.getEmail());
        userAccount.setPassword(userAccountVo.getPassword());
        userAccount.setWalletAddress(userAccountVo.getWalletAddress());
        userAccount.setCreateTime(System.currentTimeMillis());
        userAccount.setIsDel(0);
        userAccount.setUserName(userAccountVo.getUserName());
        userAccount.setUserLogo(userAccountVo.getUserLogo());
        userAccount.setIsVerify(userAccountVo.getIsVerify());
        userAccountService.save(userAccount);
        return ResultTool.success(userAccount);
    }

    @PostMapping(value = "/deleteUserAccount")
    @ApiOperation(value = "删除")
    public ResultDto deleteUserAccount() {
        //TODO
        return ResultTool.success("");
    }

    @PostMapping(value = "/login")
    public ResultDto login(@RequestBody UserAccountVo userAccountVo) {
        UserAccount userAccount = userAccountService.lambdaQuery().eq(UserAccount::getWalletAddress, userAccountVo.getWalletAddress()).one();
        return ResultTool.success(userAccount);
    }
}
