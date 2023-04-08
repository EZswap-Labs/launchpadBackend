package com.ezswap.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
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
import com.ezswap.entry.LaunchpadMetadataStandard;
import com.ezswap.entry.UploadData;
import com.ezswap.entry.UserAccount;
import com.ezswap.listener.UploadDataListener;
import com.ezswap.service.ILaunchpadService;
import com.ezswap.component.AwsCompnent;

import com.ezswap.service.IUserAccountService;
import com.ezswap.util.JsonCreateFileUtil;
import com.ezswap.vo.LaunchpadVo;
import com.google.common.io.Files;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
        //将metadata上传到s3
        LaunchpadMetadataStandard launchpadToJson = new LaunchpadMetadataStandard();
        launchpadToJson.setName(launchpadVo.getCollectionName());
        launchpadToJson.setDescription(launchpadVo.getDescription());
        launchpadToJson.setImage_url(launchpadVo.getImgUrl());
        launchpadToJson.setDecimals(18);
        InputStream aaa = JsonCreateFileUtil.createJsonFile(new Gson().toJson(launchpadToJson), "/Users/zhangnan/Downloads/" + launchpadVo.getContractAddress() + "/", "aaa");
        uploadFile(aaa, launchpadVo.getContractAddress()+"/1","application/json");

        String s3Url = "https://ezonline.s3.us-west-2.amazonaws.com/"+launchpadVo.getContractAddress()+"/1";

        Launchpad launchpad = new Launchpad();
        launchpad.setTokenUrl(s3Url);
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
        lambdaQuery.ne(Launchpad::getStatus, 0);
        if (null != launchpadVo.getUserId()) {
            lambdaQuery.eq(Launchpad::getUserId, launchpadVo.getUserId());
        }
        if (null != launchpadVo.getId()) {
            lambdaQuery.eq(Launchpad::getId, launchpadVo.getId());
        }
        if (null == launchpadVo.getId() && null == launchpadVo.getUserId()){
            //查 live launchpad
            lambdaQuery.eq(Launchpad::getStatus, 2)
                    .gt(Launchpad::getPublicEndTime,System.currentTimeMillis())
                    .lt(Launchpad::getPublicStartTime,System.currentTimeMillis());
        }
        List<Launchpad> list = lambdaQuery.list();
        if (!list.isEmpty() && null != launchpadVo.getId()) {
            UserAccount userAccount = userAccountService.lambdaQuery().eq(UserAccount::getId, list.get(0).getUserId()).one();
            userAccount.setPassword("");
            list.get(0).setUserAccount(userAccount);
        }
        return ResultTool.success(list);
    }

    @PostMapping(value = "/uploadImg")
    public ResultDto uploadImg(MultipartFile file) throws IOException {
        String s3Url = "https://ezonline.s3.us-west-2.amazonaws.com";
        String fileName = System.currentTimeMillis() + "" + +(1 + (int) (Math.random() * 100000000)) + "." + Files.getFileExtension(file.getOriginalFilename());
        s3Url += "/" + fileName;
        uploadFile(file.getInputStream(), fileName,"image/png");
        return ResultTool.success(s3Url);
    }

    private void uploadFile(InputStream file, String fileNameAndPath,String fileType) {
        AWSCredentials credentials = new BasicAWSCredentials(awsCompnent.getAccessKey(), awsCompnent.getSecretKey());
        AmazonS3 amazonS3 = AmazonS3Client.builder()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(fileType);
        amazonS3.putObject("ezonline", fileNameAndPath, file, objectMetadata);
    }

//    @PostMapping("uploadWhite")
//    @ResponseBody
//    public String uploadWhite(MultipartFile file) {
////        EasyExcel.read(file.getInputStream(), UploadData.class, null).sheet().doRead();
//        EasyExcel.read(file, UploadData.class, new PageReadListener<UploadData>(dataList -> {
//            for (UploadData demoData : dataList) {
//                System.out.println(JSON.toJSONString(demoData));
////                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
//            }
//        })).sheet().doRead();
//        return "success";
//    }
}
