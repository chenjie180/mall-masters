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
import cn.com.sparknet.model.SmsHomeRecommendProduct;
import cn.com.sparknet.model.SmsHomeRecommendSubject;
import cn.com.sparknet.service.SmsHomeRecommendProductService;
import cn.com.sparknet.service.SmsHomeRecommendSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "SmsHomeRecommendSubjectController",description = "首页专题推荐管理")
public class SmsHomeRecommendSubjectController {

	@Autowired
	 private SmsHomeRecommendSubjectService smsHomeRecommendSubjectService;
	
	@ApiOperation("新增首页专题推荐")
   @RequestMapping(value = "/SmsHomeRecommendSubject/insert",method = RequestMethod.POST)
   public CommonResult insertSmsHomeRecommendSubjectInfo(@RequestBody SmsHomeRecommendSubject smsHomeRecommendSubject ){
       int i = smsHomeRecommendSubjectService.insertSmsHomeRecommendSubjectInfo(smsHomeRecommendSubject);
       if(i>0){
           return  CommonResult.success(i);
       }
       return  CommonResult.failed("新增首页专题推荐失败");

   }
	
	@ApiOperation("分页查询首页专题推荐列表")
    @RequestMapping(value = "/SmsHomeRecommendSubject/selectByPage",method = RequestMethod.POST)
    public CommonResult selectSmsHomeRecommendSubjectByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "subjectName" )  String subjectName,
                                                      @RequestParam(value = "recommendStatus" )Integer recommendStatus
                                                      ){
        List<SmsHomeRecommendSubject> smsFlashPromotionSession = smsHomeRecommendSubjectService.selectSmsHomeRecommendSubjectByPage(pageNum, pageSize,subjectName,recommendStatus);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }
	
	@ApiOperation("批量删除首页专题推荐列表")
    @RequestMapping(value = "/SmsHomeRecommendSubject/deleteByIds",method = RequestMethod.POST)
    public CommonResult deleteSmsHomeRecommendSubjectByIds(@RequestBody List<Long> ids
                                                      ){
        int i = smsHomeRecommendSubjectService.deleteSmsHomeRecommendSubjectByIds(ids);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量删除首页专题推荐列表失败");
    }
	
	
	@ApiOperation("批量设为推荐/取消首页专题推荐列表")
    @RequestMapping(value = "/SmsHomeRecommendSubject/updateStatusByIds",method = RequestMethod.GET)
    public CommonResult updateSmsHomeRecommendSubjectStatusByIds(@RequestParam("ids")  List<Long> ids,@RequestParam("recommendStatus") int recommendStatus
                                                      ){
        int i = smsHomeRecommendSubjectService.updateSmsHomeRecommendSubjectStatusByIds(ids,recommendStatus);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量设为推荐/取消首页专题推荐列表失败");
    }
	
	
	@ApiOperation("设置排序首页专题推荐列表")
    @RequestMapping(value = "/SmsHomeRecommendSubject/updateSortById",method = RequestMethod.GET)
    public CommonResult updateSmsHomeRecommendSubjectSortById(@RequestParam("id")  Long id,@RequestParam("sort") int sort
                                                      ){
        int i = smsHomeRecommendSubjectService.updateSmsHomeRecommendSubjectSortById(id,sort);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("设置排序首页专题推荐列表失败");

    }
	
	
}
