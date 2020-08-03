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
import cn.com.sparknet.model.SmsHomeBrand;
import cn.com.sparknet.model.SmsHomeNewProduct;
import cn.com.sparknet.service.SmsHomeNewProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "SmsHomeNewProductController",description = "新品推荐商品管理")
public class SmsHomeNewProductController {

	@Autowired
	 private SmsHomeNewProductService smsHomeNewProductService;
	
	@ApiOperation("新增新品推荐")
    @RequestMapping(value = "/SmsHomeNewProduct/insert",method = RequestMethod.POST)
    public CommonResult insertSmsHomeNewProductInfo(@RequestBody SmsHomeNewProduct smsHomeNewProduct ){
        int i = smsHomeNewProductService.insertSmsHomeNewProductInfo(smsHomeNewProduct);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增新品推荐失败");

    }
	
	@ApiOperation("分页查询新品推荐列表")
    @RequestMapping(value = "/SmsHomeNewProduct/selectByPage",method = RequestMethod.POST)
    public CommonResult selectSmsHomeNewProductByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "productName" )  String productName,
                                                      @RequestParam(value = "recommendStatus" )Integer recommendStatus
                                                      ){
        List<SmsHomeNewProduct> smsFlashPromotionSession = smsHomeNewProductService.selectSmsHomeNewProductByPage(pageNum, pageSize,productName,recommendStatus);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }

	@ApiOperation("批量删除新品推荐列表")
    @RequestMapping(value = "/SmsHomeNewProduct/deleteByIds",method = RequestMethod.POST)
    public CommonResult deleteSmsHomeNewProductByIds(@RequestBody List<Long> ids
                                                      ){
        int i = smsHomeNewProductService.deleteSmsHomeNewProductByIds(ids);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量删除新品推荐列表失败");
    }
	
	
	@ApiOperation("批量设为推荐/取消新品推荐列表")
    @RequestMapping(value = "/SmsHomeNewProduct/updateStatusByIds",method = RequestMethod.GET)
    public CommonResult updateSmsHomeNewProductStatusByIds(@RequestParam("ids")  List<Long> ids,@RequestParam("recommendStatus") int recommendStatus
                                                      ){
        int i = smsHomeNewProductService.updateSmsHomeNewProductStatusByIds(ids,recommendStatus);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量设为推荐/取消新品推荐列表失败");
    }
	
	
	@ApiOperation("设置排序新品推荐列表")
    @RequestMapping(value = "/SmsHomeNewProduct/updateSortById",method = RequestMethod.GET)
    public CommonResult updateSmsHomeNewProductSortById(@RequestParam("id")  Long id,@RequestParam("sort") int sort
                                                      ){
        int i = smsHomeNewProductService.updateSmsHomeNewProductSortById(id,sort);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("设置排序新品推荐列表失败");

    }
	
	
}
