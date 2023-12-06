package com.ezswap.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
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
import com.ezswap.entry.*;
import com.ezswap.mapper.LaunchpadWhiteMapper;
import com.ezswap.service.ILaunchpadService;
import com.ezswap.component.AwsCompnent;

import com.ezswap.service.ILaunchpadWhiteService;
import com.ezswap.service.IUserAccountService;
import com.ezswap.util.JsonCreateFileUtil;
import com.ezswap.vo.LaunchpadVo;
import com.google.common.io.Files;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private LaunchpadWhiteMapper launchpadWhiteMapper;


    @PostMapping(value = "/addLaunchpad")
    public ResultDto addLaunchpad(@RequestBody LaunchpadVo launchpadVo) {
        //将metadata上传到s3
        LaunchpadMetadataStandard launchpadToJson = new LaunchpadMetadataStandard();
        launchpadToJson.setName(launchpadVo.getCollectionName());
        launchpadToJson.setDescription(launchpadVo.getDescription());
        launchpadToJson.setImage_url(launchpadVo.getImgUrl());
        launchpadToJson.setImage(launchpadVo.getImgUrl());
        launchpadToJson.setDecimals(18);
        InputStream aaa = JsonCreateFileUtil.createJsonFile(new Gson().toJson(launchpadToJson), "/Users/zhangnan/Downloads/" + launchpadVo.getContractAddress() + "/", "aaa");
        uploadFile(aaa, launchpadVo.getContractAddress() + "/1", "application/json");

        String s3Url = "https://ezonline.s3.us-west-2.amazonaws.com/" + launchpadVo.getContractAddress() + "/1";

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
        launchpad.setPublicMintCount(launchpadVo.getPublicMintCount());
        launchpad.setPrivateMintCount(launchpadVo.getPrivateMintCount());
        launchpad.setAirdropMintCount(launchpadVo.getAirdropMintCount());
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
        launchpad.setTeam(launchpadVo.getTeam());
        launchpad.setRoadmap(launchpadVo.getRoadmap());
        launchpad.setMintSalePayoutAddress(launchpadVo.getMintSalePayoutAddress());
        launchpad.setRoyaltyPayoutAddress(launchpadVo.getRoyaltyPayoutAddress());
        launchpad.setErc(launchpadVo.getErc());
        launchpad.setNetwork(launchpadVo.getNetwork());
        launchpad.setCanCreditCard(launchpadVo.getCanCreditCard());
        launchpad.setStartMode(launchpadVo.getStartMode());
        launchpad.setPrivateFee(launchpadVo.getPrivateFee());
        launchpad.setWhiteFee(launchpadVo.getWhiteFee());
        launchpad.setPublicFee(launchpadVo.getPublicFee());
        launchpad.setWhiteMintSupply(launchpadVo.getAirdropSupply());
        launchpad.setWhiteMintEndTime(launchpadVo.getAirdropEndTime());
        launchpad.setWhiteMintStartTime(launchpadVo.getAirdropStartTime());
        launchpad.setWhiteMintEveryUserMintLimit(launchpadVo.getAirdropEveryUserMintLimit());
        launchpad.setWhiteMintMintCount(launchpadVo.getAirdropMintCount());
        launchpad.setSigner(launchpadVo.getSigner());
        launchpad.setBaseUri(launchpadVo.getBaseUri());
        launchpad.setAirdropEveryUserMinMintLimit(launchpadVo.getAirdropEveryUserMinMintLimit());
        launchpad.setPublicEveryUserMinMintLimit(launchpadVo.getPublicEveryUserMinMintLimit());
        launchpad.setWhiteMintEveryUserMinMintLimit(launchpadVo.getWhiteMintEveryUserMinMintLimit());
        launchpad.setPrivateEveryUserMinMintLimit(launchpadVo.getPrivateEveryUserMinMintLimit());
        launchpad.setPayType(launchpadVo.getPayType());
        launchpad.setHaveWhiteMint(launchpadVo.getHaveWhiteMint());
        launchpad.setHavePrivateMint(launchpadVo.getHavePrivateMint());
        launchpad.setHavePublicMint(launchpadVo.getHavePublicMint());
        if (launchpadVo.getErc().equals("1155")) {
            launchpad.setCurrentTokenId("1");
        }
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
        launchpad.setPublicMintCount(launchpadVo.getPublicMintCount());
        launchpad.setPrivateMintCount(launchpadVo.getPrivateMintCount());
        launchpad.setAirdropMintCount(launchpadVo.getAirdropMintCount());
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
        launchpad.setTeam(launchpadVo.getTeam());
        launchpad.setRoadmap(launchpadVo.getRoadmap());
        launchpad.setMintSalePayoutAddress(launchpadVo.getMintSalePayoutAddress());
        launchpad.setRoyaltyPayoutAddress(launchpadVo.getRoyaltyPayoutAddress());
        launchpad.setNetwork(launchpadVo.getNetwork());
        launchpad.setErc(launchpadVo.getErc());
        launchpad.setCurrentTokenId(launchpadVo.getCurrentTokenId());
        launchpad.setCanCreditCard(launchpadVo.getCanCreditCard());
        launchpad.setStartMode(launchpadVo.getStartMode());
        launchpad.setPrivateFee(launchpadVo.getPrivateFee());
        launchpad.setWhiteFee(launchpadVo.getWhiteFee());
        launchpad.setPublicFee(launchpadVo.getPublicFee());
        launchpad.setWhiteMintSupply(launchpadVo.getAirdropSupply());
        launchpad.setWhiteMintEndTime(launchpadVo.getAirdropEndTime());
        launchpad.setWhiteMintStartTime(launchpadVo.getAirdropStartTime());
        launchpad.setWhiteMintEveryUserMintLimit(launchpadVo.getAirdropEveryUserMintLimit());
        launchpad.setWhiteMintMintCount(launchpadVo.getAirdropMintCount());
        launchpad.setSigner(launchpadVo.getSigner());
        launchpad.setBaseUri(launchpadVo.getBaseUri());
        launchpad.setAirdropEveryUserMinMintLimit(launchpadVo.getAirdropEveryUserMinMintLimit());
        launchpad.setPublicEveryUserMinMintLimit(launchpadVo.getPublicEveryUserMinMintLimit());
        launchpad.setWhiteMintEveryUserMinMintLimit(launchpadVo.getWhiteMintEveryUserMinMintLimit());
        launchpad.setPrivateEveryUserMinMintLimit(launchpadVo.getPrivateEveryUserMinMintLimit());
        launchpad.setPayType(launchpadVo.getPayType());
        launchpad.setHaveWhiteMint(launchpadVo.getHaveWhiteMint());
        launchpad.setHavePrivateMint(launchpadVo.getHavePrivateMint());
        launchpad.setHavePublicMint(launchpadVo.getHavePublicMint());
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
        if (null == launchpadVo.getUserId()) {
            //查 live launchpad
            lambdaQuery.eq(Launchpad::getStatus, 2)
                    .gt(Launchpad::getPublicEndTime, System.currentTimeMillis())
                    .lt(Launchpad::getPublicStartTime, System.currentTimeMillis());
        }
        List<Launchpad> list = lambdaQuery.list();
//        if (!list.isEmpty() && null != launchpadVo.getId()) {
//            UserAccount userAccount = userAccountService.lambdaQuery().eq(UserAccount::getId, list.get(0).getUserId()).one();
//            userAccount.setPassword("");
//            list.get(0).setUserAccount(userAccount);
//        }
        return ResultTool.success(list);
    }

    @PostMapping(value = "/queryDetail")
    public ResultDto queryDetail(@RequestBody LaunchpadVo launchpadVo) {
        LambdaQueryChainWrapper<Launchpad> lambdaQuery = launchpadService.lambdaQuery();
        lambdaQuery.ne(Launchpad::getStatus, 0)
                .eq(Launchpad::getId, launchpadVo.getId());
        Launchpad launchpad = lambdaQuery.one();
        if (null != launchpad.getUserId()) {
            UserAccount userAccount = userAccountService.lambdaQuery().eq(UserAccount::getId, launchpad.getUserId()).one();
            userAccount.setPassword("");
            launchpad.setUserAccount(userAccount);
        }
        return ResultTool.success(launchpad);
    }


    @PostMapping(value = "/uploadImg")
    public ResultDto uploadImg(MultipartFile file) throws IOException {
        String s3Url = "https://ezonline.s3.us-west-2.amazonaws.com";
        String fileName = System.currentTimeMillis() + "" + +(1 + (int) (Math.random() * 100000000)) + "." + Files.getFileExtension(file.getOriginalFilename());
        s3Url += "/" + fileName;
        uploadFile(file.getInputStream(), fileName, "image/png");
        return ResultTool.success(s3Url);
    }

    private void uploadFile(InputStream file, String fileNameAndPath, String fileType) {
        AWSCredentials credentials = new BasicAWSCredentials(awsCompnent.getAccessKey(), awsCompnent.getSecretKey());
        AmazonS3 amazonS3 = AmazonS3Client.builder()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(fileType);
        amazonS3.putObject("ezonline", fileNameAndPath, file, objectMetadata);
    }

    @PostMapping("uploadWhite")
    @ResponseBody
    public ResultDto uploadWhite(MultipartFile file, Long launchpadId, Integer launchpadStep, Integer mintCount) {
//        EasyExcel.read(file.getInputStream(), UploadData.class, null).sheet().doRead();
        try {
            List<LaunchpadWhite> launchpadWhiteList = new ArrayList<>();
            EasyExcel.read(file.getInputStream(), UploadData.class, new PageReadListener<UploadData>(dataList -> {
                for (UploadData demoData : dataList) {
                    LaunchpadWhite launchpadWhite = new LaunchpadWhite();
                    launchpadWhite.setLaunchpadId(launchpadId);
                    launchpadWhite.setCreateTime(System.currentTimeMillis());
                    launchpadWhite.setIsDel(0);
                    launchpadWhite.setWalletAddress(demoData.getAddress());
                    launchpadWhite.setLaunchpadStep(launchpadStep);
                    launchpadWhite.setMintCount(mintCount);
                    launchpadWhiteList.add(launchpadWhite);
                }
            })).sheet().doRead();
            launchpadWhiteMapper.createBATCH(launchpadWhiteList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultTool.success("");
    }
}


