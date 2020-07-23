package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.OmsOrderSetting;
import cn.com.sparknet.service.OmsOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "OmsOrderSettingController", description = "订单设置管理")
@RestController
public class OmsOrderSettingController {
	
	@Autowired
	private OmsOrderSettingService omsOrderSettingService;
	
	@ApiOperation("查询订单设置")
	@RequestMapping(value = "/selectOrderSettingInfo" ,method = RequestMethod.POST)
	public CommonResult<List<OmsOrderSetting>> selectOrderSettingInfo(){
		List<OmsOrderSetting> selectOrderSettingInfo = omsOrderSettingService.selectOrderSettingInfo();
		return CommonResult.success(selectOrderSettingInfo);
	}

}
