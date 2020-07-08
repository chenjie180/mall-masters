package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.CmsPrefrenceArea;
import cn.com.sparknet.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "CmsPrefrenceAreaController",description = "商品关联优选管理")
public class CmsPrefrenceAreaController {
	
	@Autowired
	private CmsPrefrenceAreaService cmsPrefrenceAreaService;
	
	@ApiOperation("查询商品关联优选集合")
	@RequestMapping(value = "/cmsPrefrenceArea/list" ,method = RequestMethod.POST)
	public CommonResult selectCmsPrefrenceAreaList() {
		List<CmsPrefrenceArea> selectCmsPrefrenceAreaList = cmsPrefrenceAreaService.selectCmsPrefrenceAreaList();
		if(!StringUtils.isEmpty(selectCmsPrefrenceAreaList)) {
			return  CommonResult.success(selectCmsPrefrenceAreaList);
		}else {
			return CommonResult.failed("查询商品关联优选失败");
		}
		
	}
	

}
