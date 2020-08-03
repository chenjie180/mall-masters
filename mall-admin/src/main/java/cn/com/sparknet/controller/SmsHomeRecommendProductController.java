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
import cn.com.sparknet.model.SmsHomeNewProduct;
import cn.com.sparknet.model.SmsHomeRecommendProduct;
import cn.com.sparknet.service.SmsHomeNewProductService;
import cn.com.sparknet.service.SmsHomeRecommendProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(tags = "SmsHomeRecommendProductController",description = "人气推荐商品管理")
public class SmsHomeRecommendProductController {

	@Autowired
	 private SmsHomeRecommendProductService smsHomeRecommendProductService;
	
	@ApiOperation("新增人气推荐商品")
    @RequestMapping(value = "/SmsHomeRecommendProduct/insert",method = RequestMethod.POST)
    public CommonResult insertSmsHomeRecommendProductInfo(@RequestBody SmsHomeRecommendProduct smsHomeRecommendProduct ){
        int i = smsHomeRecommendProductService.insertSmsHomeRecommendProductInfo(smsHomeRecommendProduct);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增新品推荐失败");

    }
	
	@ApiOperation("分页查询人气推荐商品列表")
    @RequestMapping(value = "/SmsHomeRecommendProduct/selectByPage",method = RequestMethod.POST)
    public CommonResult selectSmsHomeRecommendProductByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "productName" )  String productName,
                                                      @RequestParam(value = "recommendStatus" )Integer recommendStatus
                                                      ){
        List<SmsHomeRecommendProduct> smsFlashPromotionSession = smsHomeRecommendProductService.selectSmsHomeRecommendProductByPage(pageNum, pageSize,productName,recommendStatus);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }

	@ApiOperation("批量删除人气推荐商品列表")
    @RequestMapping(value = "/SmsHomeRecommendProduct/deleteByIds",method = RequestMethod.POST)
    public CommonResult deleteSmsHomeRecommendProductByIds(@RequestBody List<Long> ids
                                                      ){
        int i = smsHomeRecommendProductService.deleteSmsHomeRecommendProductByIds(ids);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量删除人气推荐商品列表失败");
    }
	
	
	@ApiOperation("批量设为推荐/取消人气推荐商品列表")
    @RequestMapping(value = "/SmsHomeRecommendProduct/updateStatusByIds",method = RequestMethod.GET)
    public CommonResult updateSmsHomeRecommendProductStatusByIds(@RequestParam("ids")  List<Long> ids,@RequestParam("recommendStatus") int recommendStatus
                                                      ){
        int i = smsHomeRecommendProductService.updateSmsHomeRecommendProductStatusByIds(ids,recommendStatus);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量设为推荐/取消新品推荐列表失败");
    }
	
	
	@ApiOperation("设置排序人气推荐商品列表")
    @RequestMapping(value = "/SmsHomeRecommendProduct/updateSortById",method = RequestMethod.GET)
    public CommonResult updateSmsHomeRecommendProductSortById(@RequestParam("id")  Long id,@RequestParam("sort") int sort
                                                      ){
        int i = smsHomeRecommendProductService.updateSmsHomeRecommendProductSortById(id,sort);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("设置排序人气推荐商品列表失败");

    }
	
}
