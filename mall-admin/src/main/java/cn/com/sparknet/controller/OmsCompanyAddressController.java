package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.OmsCompanyAddress;
import cn.com.sparknet.service.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "OmsCompanyAddressController", description = "公司收货地址管理")
@RestController
public class OmsCompanyAddressController {

	@Autowired
	private OmsCompanyAddressService omsCompanyAddressService;
	
	
	
	@ApiOperation("查询公司公司收货地址")
	@RequestMapping(value = "/omsCompanyAddress/select",method = RequestMethod.POST)
	public CommonResult selectOmsCompanyAddressList() {
		List<OmsCompanyAddress> omsCompanyAddressList= omsCompanyAddressService.selectOmsCompanyAddressList();
      return 		CommonResult.success(omsCompanyAddressList);
	} 
	
}
