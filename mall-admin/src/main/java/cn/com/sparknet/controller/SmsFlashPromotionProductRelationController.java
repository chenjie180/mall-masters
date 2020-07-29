package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.SmsFlashPromotionProductRelationReturn;
import cn.com.sparknet.service.SmsFlashPromotionProductRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "SmsFlashPromotionProductRelationController",description = "限时购与商品关系管理")
public class SmsFlashPromotionProductRelationController {

	@Autowired
	private SmsFlashPromotionProductRelationService smsFlashPromotionProductRelationService;
	
	
	   @ApiOperation("分页查询限时购与商品关系")
	    @RequestMapping(value = "/SmsFlashPromotionProductRelation/selectByPage",method = RequestMethod.POST)
	    public CommonResult selectSmsFlashPromotionProductRelationByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
	                                                      @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
	                                                      @RequestParam(value = "promotionId" ) Long promotionId,
	                                                      @RequestParam(value = "promotionSessionId" ) Long promotionSessionId
	                                                      ){
		   List<SmsFlashPromotionProductRelationReturn> selectSmsFlashPromotionProductRelationByPage = smsFlashPromotionProductRelationService.selectSmsFlashPromotionProductRelationByPage(pageNum,pageSize,promotionId,promotionSessionId);
															
		   return CommonResult.success(CommonPage.restPage(selectSmsFlashPromotionProductRelationByPage));
		
	}
	
}
