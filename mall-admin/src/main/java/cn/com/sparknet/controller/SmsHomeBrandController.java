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
import cn.com.sparknet.model.SmsFlashPromotionSession;
import cn.com.sparknet.model.SmsHomeBrand;
import cn.com.sparknet.service.SmsHomeBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "SmsHomeBrandController",description = "首页品牌推荐管理")
public class SmsHomeBrandController {
	@Autowired
	private SmsHomeBrandService smsHomeBrandService;

	@ApiOperation("新增首页品牌推荐")
    @RequestMapping(value = "/SmsHomeBrand/insert",method = RequestMethod.POST)
    public CommonResult insertSmsHomeBrandInfo(@RequestBody SmsHomeBrand smsHomeBrand ){
        int i = smsHomeBrandService.insertSmsFlashPromotionSessionInfo(smsHomeBrand);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增首页品牌推荐失败");

    }
	
	@ApiOperation("分页查询首页品牌推荐列表")
    @RequestMapping(value = "/SmsHomeBrand/selectByPage",method = RequestMethod.POST)
    public CommonResult selectSmsHomeBrandByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "brandName" )  String brandName,
                                                      @RequestParam(value = "recommendStatus" )Integer recommendStatus
                                                      ){
        List<SmsHomeBrand> smsFlashPromotionSession = smsHomeBrandService.selectSmsHomeBrandByPage(pageNum, pageSize,brandName,recommendStatus);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));

    }
	
	
	@ApiOperation("批量删除首页品牌推荐列表")
    @RequestMapping(value = "/SmsHomeBrand/deleteByIds",method = RequestMethod.POST)
    public CommonResult deleteSmsHomeBrandByIds(@RequestBody List<Long> ids
                                                      ){
        int i = smsHomeBrandService.deleteSmsHomeBrandByIds(ids);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量删除首页品牌推荐列表失败");

    }
	
	@ApiOperation("批量设为推荐/取消首页品牌推荐列表")
    @RequestMapping(value = "/SmsHomeBrand/updateStatusByIds",method = RequestMethod.GET)
    public CommonResult updateSmsHomeBrandStatusByIds(@RequestParam("ids")  List<Long> ids,@RequestParam("recommendStatus") int recommendStatus
                                                      ){
        int i = smsHomeBrandService.updateSmsHomeBrandStatusByIds(ids,recommendStatus);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量删除首页品牌推荐列表失败");
    }
	
	@ApiOperation("设置排序首页品牌推荐列表")
    @RequestMapping(value = "/SmsHomeBrand/updateSortById",method = RequestMethod.GET)
    public CommonResult updateSmsHomeBrandSortById(@RequestParam("id")  Long id,@RequestParam("sort") int sort
                                                      ){
        int i = smsHomeBrandService.updateSmsHomeBrandSortById(id,sort);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("设置排序首页品牌推荐列表失败");

    }
	
	
}
