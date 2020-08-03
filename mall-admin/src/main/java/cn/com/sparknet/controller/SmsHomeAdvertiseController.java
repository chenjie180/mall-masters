package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.SmsHomeAdvertise;
import cn.com.sparknet.service.SmsHomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("分页查询首页轮播广告列表")
    @RequestMapping(value = "/SmsHomeAdvertise/selectByPage",method = RequestMethod.POST)
    public CommonResult selectSmsHomeAdvertiseByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "name" )  String name,
                                                 @RequestParam(value = "type" )Integer type,
                                                     @RequestParam(value = "endTime" )String endTime
    ){
        List<SmsHomeAdvertise> smsFlashPromotionSession = smsHomeAdvertiseService.selectSmsHomeAdvertiseByPage(pageNum, pageSize,name,type,endTime);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));

    }

    @ApiOperation("批量删除首页轮播广告列表")
    @RequestMapping(value = "/SmsHomeAdvertise/deleteByIds",method = RequestMethod.POST)
    public CommonResult deleteSmsHomeAdvertiseByIds(@RequestBody List<Long> ids
    ){
        int i = smsHomeAdvertiseService.deleteSmsHomeAdvertiseByIds(ids);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量删除首页轮播广告列表失败");

    }


    @ApiOperation("修改上线下线状态")
    @RequestMapping(value = "/SmsHomeAdvertise/updateStatusById",method = RequestMethod.GET)
    public CommonResult updateSmsHomeAdvertiseStatusByIds(@RequestParam("id")  Long id,@RequestParam("status") int status
    ){
        int i = smsHomeAdvertiseService.updateSmsHomeAdvertiseStatusByIds(id,status);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("修改上线下线状态失败");
    }

    @ApiOperation("查询单个轮播广告")
    @RequestMapping(value = "/SmsHomeAdvertise/selectById/{id}",method = RequestMethod.GET)
    public CommonResult selectSmsHomeAdvertiseById(@RequestParam("id")  Long id
    ){
        SmsHomeAdvertise smsHomeAdvertise = smsHomeAdvertiseService.selectSmsHomeAdvertiseById(id);

        return  CommonResult.success(smsHomeAdvertise);
    }


    @ApiOperation("修改单个轮播广告")
    @RequestMapping(value = "/SmsHomeAdvertise/update",method = RequestMethod.GET)
    public CommonResult updateSmsHomeAdvertiseInfo(@RequestBody SmsHomeAdvertise smsHomeAdvertise
    ){
        int i = smsHomeAdvertiseService.updateSmsHomeAdvertiseInfo(smsHomeAdvertise);

        return  CommonResult.success(smsHomeAdvertise);
    }


}
