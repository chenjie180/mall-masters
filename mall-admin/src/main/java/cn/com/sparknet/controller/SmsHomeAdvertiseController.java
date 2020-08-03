package cn.com.sparknet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.SmsHomeAdvertise;
import cn.com.sparknet.model.SmsHomeBrand;
import cn.com.sparknet.service.SmsHomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "SmsHomeAdvertiseController",description = "首页轮播广告管理")
public class SmsHomeAdvertiseController {
	@Autowired
	private SmsHomeAdvertiseService smsHomeAdvertiseService;
	
	@ApiOperation("新增首页轮播广告")
    @RequestMapping(value = "/SmsHomeAdvertise/insert",method = RequestMethod.POST)
    public CommonResult insertSmsHomeAdvertiseInfo(@RequestBody SmsHomeAdvertise smsHomeAdvertise ){
        int i = smsHomeAdvertiseService.insertSmsHomeAdvertiseInfo(smsHomeAdvertise);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增首页轮播广告");

    }

}
