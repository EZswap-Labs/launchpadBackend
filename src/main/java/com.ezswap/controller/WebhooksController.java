package com.ezswap.controller;

import com.ezswap.common.dto.ResultDto;
import com.ezswap.common.tool.ResultTool;
import com.ezswap.entry.UserAccount;
import com.ezswap.entry.wert.WertWebhook;
import com.ezswap.service.IUserAccountService;
import com.ezswap.vo.UserAccountVo;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("Webhooks")
public class WebhooksController {


    @PostMapping(value = "/wert")
    public ResultDto register(@RequestBody WertWebhook wertWebhook) {

        return ResultTool.success("");
    }

}
