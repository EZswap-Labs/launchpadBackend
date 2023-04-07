package com.ezswap.controller;

import cn.hutool.core.date.DateUtil;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.ezswap.common.dto.ResultDto;
import com.ezswap.common.tool.ResultTool;
import com.ezswap.entry.Launchpad;
import com.ezswap.entry.UserAccount;
import com.ezswap.service.ILaunchpadService;
import com.ezswap.component.AwsCompnent;

import com.ezswap.service.IUserAccountService;
import com.ezswap.vo.LaunchpadVo;
import com.google.common.io.Files;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 前端控制器 custom
 * </p>
 *
 * @author mybatisplus
 * @since 2023-04-04
 */
@Validated
@RestController
@RequestMapping("/launchpad")
public class LaunchpadController {
    @Resource
    public ILaunchpadService launchpadService;
    @Resource
    private IUserAccountService userAccountService;
    @Resource
    private AwsCompnent awsCompnent;


    @PostMapping(value = "/addLaunchpad")
    public ResultDto addLaunchpad(@RequestBody LaunchpadVo launchpadVo) {
        Launchpad launchpad = new Launchpad();
        launchpad.setCollectionName(launchpadVo.getCollectionName());
        launchpad.setSymbol(launchpadVo.getSymbol());
        launchpad.setDescription(launchpadVo.getDescription());
        launchpad.setPublicStartTime(launchpadVo.getPublicStartTime());
        launchpad.setPublicEndTime(launchpadVo.getPublicEndTime());
        launchpad.setRoyalties(launchpadVo.getRoyalties());
        launchpad.setBannerUrl(launchpadVo.getBannerUrl());
        launchpad.setImgUrl(launchpadVo.getImgUrl());
        launchpad.setIsDel(launchpadVo.getIsDel());
        launchpad.setUserId(launchpadVo.getUserId());
        launchpad.setStatus(launchpadVo.getStatus());
        launchpad.setTotalSupply(launchpadVo.getTotalSupply());
        launchpad.setMintCount(launchpadVo.getMintCount());
        launchpad.setContractAddress(launchpadVo.getContractAddress());
        launchpad.setPublicEveryUserMintLimit(launchpadVo.getPublicEveryUserMintLimit());
        launchpad.setAirdropStartTime(launchpadVo.getAirdropStartTime());
        launchpad.setAirdropEndTime(launchpadVo.getAirdropEndTime());
        launchpad.setAirdropSupply(launchpadVo.getAirdropSupply());
        launchpad.setAirdropEveryUserMintLimit(launchpadVo.getAirdropEveryUserMintLimit());
        launchpad.setDiscord(launchpadVo.getDiscord());
        launchpad.setTwitter(launchpadVo.getTwitter());
        launchpad.setMedium(launchpadVo.getMedium());
        launchpad.setTelegram(launchpadVo.getTelegram());
        launchpad.setGalxe(launchpadVo.getGalxe());
        launchpad.setPrivateStartTime(launchpadVo.getPrivateStartTime());
        launchpad.setPrivateEndTime(launchpadVo.getPrivateEndTime());
        launchpad.setPrivateEveryUserMintLimit(launchpadVo.getPrivateEveryUserMintLimit());
        launchpad.setPrivateSupply(launchpadVo.getPrivateSupply());
        launchpad.setPublicSupply(launchpadVo.getPublicSupply());
        launchpad.setWebsite(launchpadVo.getWebsite());
        launchpad.setPrivatePrice(launchpadVo.getPrivatePrice());
        launchpad.setPublicPrice(launchpadVo.getPublicPrice());
        launchpadService.save(launchpad);
        return ResultTool.success("");
    }

    @PostMapping(value = "/update")
    public ResultDto update(@RequestBody LaunchpadVo launchpadVo) {
        Launchpad launchpad = new Launchpad();
        launchpad.setCollectionName(launchpadVo.getCollectionName());
        launchpad.setSymbol(launchpadVo.getSymbol());
        launchpad.setDescription(launchpadVo.getDescription());
        launchpad.setPublicStartTime(launchpadVo.getPublicStartTime());
        launchpad.setPublicEndTime(launchpadVo.getPublicEndTime());
        launchpad.setRoyalties(launchpadVo.getRoyalties());
        launchpad.setBannerUrl(launchpadVo.getBannerUrl());
        launchpad.setImgUrl(launchpadVo.getImgUrl());
        launchpad.setIsDel(0);
        launchpad.setUserId(launchpadVo.getUserId());
        launchpad.setCreateTime(System.currentTimeMillis());
        launchpad.setStatus(launchpadVo.getStatus());
        launchpad.setTotalSupply(launchpadVo.getTotalSupply());
        launchpad.setMintCount(launchpadVo.getMintCount());
        launchpad.setContractAddress(launchpadVo.getContractAddress());
        launchpad.setPublicEveryUserMintLimit(launchpadVo.getPublicEveryUserMintLimit());
        launchpad.setAirdropStartTime(launchpadVo.getAirdropStartTime());
        launchpad.setAirdropEndTime(launchpadVo.getAirdropEndTime());
        launchpad.setAirdropSupply(launchpadVo.getAirdropSupply());
        launchpad.setAirdropEveryUserMintLimit(launchpadVo.getAirdropEveryUserMintLimit());
        launchpad.setDiscord(launchpadVo.getDiscord());
        launchpad.setTwitter(launchpadVo.getTwitter());
        launchpad.setMedium(launchpadVo.getMedium());
        launchpad.setTelegram(launchpadVo.getTelegram());
        launchpad.setGalxe(launchpadVo.getGalxe());
        launchpad.setPrivateStartTime(launchpadVo.getPrivateStartTime());
        launchpad.setPrivateEndTime(launchpadVo.getPrivateEndTime());
        launchpad.setPrivateEveryUserMintLimit(launchpadVo.getPrivateEveryUserMintLimit());
        launchpad.setPrivateSupply(launchpadVo.getPrivateSupply());
        launchpad.setPublicSupply(launchpadVo.getPublicSupply());
        launchpad.setWebsite(launchpadVo.getWebsite());
        launchpad.setId(launchpadVo.getId());
        launchpad.setPrivatePrice(launchpadVo.getPrivatePrice());
        launchpad.setPublicPrice(launchpadVo.getPublicPrice());
        launchpadService.updateById(launchpad);
        return ResultTool.success("");
    }

    @PostMapping(value = "/queryList")
    public ResultDto queryList(@RequestBody LaunchpadVo launchpadVo) {
        LambdaQueryChainWrapper<Launchpad> lambdaQuery = launchpadService.lambdaQuery();

        if (null != launchpadVo.getUserId()) {
            lambdaQuery.eq(Launchpad::getUserId, launchpadVo.getUserId());
        }
        if (null != launchpadVo.getId()) {
            lambdaQuery.eq(Launchpad::getId, launchpadVo.getId());
        }
        List<Launchpad> list = lambdaQuery.list();
        if (!list.isEmpty() && null != launchpadVo.getId()) {
            UserAccount userAccount = userAccountService.lambdaQuery().eq(UserAccount::getId, list.get(0).getUserId()).one();
            list.get(0).setUserAccount(userAccount);
        }
        return ResultTool.success(list);
    }

    @PostMapping(value = "/uploadImg")
    public ResultDto uploadImg(MultipartFile file) throws IOException {
        String s3Url = "https://ezonline.s3.us-west-2.amazonaws.com";
        String bucket_name = "ezonline";
        String key_name = System.currentTimeMillis() + "" + +(1 + (int) (Math.random() * 100000000)) + "." + Files.getFileExtension(file.getOriginalFilename());
        s3Url += "/" + key_name;
        AWSCredentials credentials = new BasicAWSCredentials(awsCompnent.getAccessKey(), awsCompnent.getSecretKey());
        AmazonS3 amazonS3 = AmazonS3Client.builder()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/png");
        amazonS3.putObject(bucket_name, key_name, file.getInputStream(), objectMetadata);
        return ResultTool.success(s3Url);
    }
}
