package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.SmsFlashPromotionParam;
import cn.com.sparknet.model.SmsFlashPromotion;
import cn.com.sparknet.service.SmsFlashPromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-27 20:12
 */
@RestController
@Api(tags = "SmsFlashPromotionController",description = "秒杀活动列表管理")
public class SmsFlashPromotionController {
    @Autowired
    private SmsFlashPromotionService smsFlashPromotionService;
    @ApiOperation("分页查询秒杀活动列表")
    @RequestMapping(value = "/SmsFlashPromotion/selectByPage",method = RequestMethod.POST)
    public CommonResult selectSmsFlashPromotionByPage( @RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "title")String title ){
        List<SmsFlashPromotion> smsFlashPromotions = smsFlashPromotionService.selectSmsFlashPromotionByPage(pageNum, pageSize, title);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotions));

    }

    @ApiOperation("新增秒杀活动列表")
    @RequestMapping(value = "/SmsFlashPromotion/insert",method = RequestMethod.POST)
    public CommonResult insertSmsFlashPromotionInfo(@RequestBody SmsFlashPromotionParam smsFlashPromotionParam ){
        int i = smsFlashPromotionService.insertSmsFlashPromotionInfo(smsFlashPromotionParam);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增秒杀活动失败");

    }

    @ApiOperation("修改秒杀状态值")
    @RequestMapping(value = "/SmsFlashPromotion/updateStatus",method = RequestMethod.POST)
    public CommonResult updateSmsFlashPromotionStatus(@RequestParam(name ="id" )  long id,@RequestParam(name ="status" )int status ){
        int i = smsFlashPromotionService.updateSmsFlashPromotionStatus(id,status);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("修改秒杀状态值失败");

    }

    @ApiOperation("删除秒杀活动")
    @RequestMapping(value = "/SmsFlashPromotion/delete/{id}",method = RequestMethod.POST)
    public CommonResult deleteSmsFlashPromotion(@PathVariable("id")  long id ){
        int i = smsFlashPromotionService.deleteSmsFlashPromotion(id);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("删除秒杀活动失败");

    }

    @ApiOperation("查询单个秒杀活动")
    @RequestMapping(value = "/SmsFlashPromotion/select/{id}",method = RequestMethod.POST)
    public CommonResult selectSmsFlashPromotionById(@PathVariable("id")  long id ){
      SmsFlashPromotion smsFlashPromotion   = smsFlashPromotionService.selectSmsFlashPromotionById(id);
            return  CommonResult.success(smsFlashPromotion);

    }

}
