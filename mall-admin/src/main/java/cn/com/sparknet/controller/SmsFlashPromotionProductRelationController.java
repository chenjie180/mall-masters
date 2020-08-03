package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.SmsFlashPromotionProductRelationReturn;
import cn.com.sparknet.model.SmsFlashPromotionProductRelation;
import cn.com.sparknet.service.SmsFlashPromotionProductRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "SmsFlashPromotionProductRelationController",description = "限时购与商品关系管理")
@Slf4j
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
	   
	   @ApiOperation("新增限时购与商品关系")
	    @RequestMapping(value = "/SmsFlashPromotionProductRelation/insert",method = RequestMethod.POST)
	    public CommonResult insertSmsFlashPromotionProductRelationbatch(@RequestBody List<SmsFlashPromotionProductRelation>  smsFlashPromotionProductRelationList
	                                                      ){
		   log.debug("smsFlashPromotionProductRelationList"+smsFlashPromotionProductRelationList);

		  int i = smsFlashPromotionProductRelationService.insertSmsFlashPromotionProductRelationbatch(smsFlashPromotionProductRelationList);
		  if(i>0){
	            return  CommonResult.success(i);
	        }
	        return  CommonResult.failed("新增限时购与商品关系失败");
		
	}
	   
	   @ApiOperation("修改限时购与商品关系")
	    @RequestMapping(value = "/SmsFlashPromotionProductRelation/update",method = RequestMethod.POST)
	    public CommonResult updateSmsFlashPromotionProductRelation(@RequestBody SmsFlashPromotionProductRelation  smsFlashPromotionProductRelation
	                                                      ){

		  int i = smsFlashPromotionProductRelationService.updateSmsFlashPromotionProductRelation(smsFlashPromotionProductRelation);
		  if(i>0){
	            return  CommonResult.success(i);
	        }
	        return  CommonResult.failed("修改限时购与商品关系失败");
		
	}
	   
	   @ApiOperation("删除限时购与商品关系")
	    @RequestMapping(value = "/SmsFlashPromotionProductRelation/delete",method = RequestMethod.POST)
	    public CommonResult deleteSmsFlashPromotionProductRelation(Long id
	                                                      ){

		  int i = smsFlashPromotionProductRelationService.deleteSmsFlashPromotionProductRelation(id);
		  if(i>0){
	            return  CommonResult.success(i);
	        }
	        return  CommonResult.failed("删除限时购与商品关系失败");
		
	}
	   
	
}
