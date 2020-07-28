package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.SmsFlashPromotionSessionReturn;
import cn.com.sparknet.model.SmsFlashPromotionSession;
import cn.com.sparknet.service.SmsFlashPromotionSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-27 21:39
 */
@RestController
@Api(tags = "SmsFlashPromotionSessionController",description = "限时购场次表管理")
public class SmsFlashPromotionSessionController {
    @Autowired
    private SmsFlashPromotionSessionService smsFlashPromotionSessionService;
    @ApiOperation("分页查询秒杀时间段活动列表")
    @RequestMapping(value = "/SmsFlashPromotionSession/selectByPage",method = RequestMethod.POST)
    public CommonResult selectSmsFlashPromotionSessionByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize
                                                      ){
        List<SmsFlashPromotionSession> smsFlashPromotionSession = smsFlashPromotionSessionService.selectSmsFlashPromotionSessionByPage(pageNum, pageSize);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));

    }

    @ApiOperation("新增秒杀秒杀时间段")
    @RequestMapping(value = "/SmsFlashPromotionSession/insert",method = RequestMethod.POST)
    public CommonResult insertSmsFlashPromotionSessionInfo(@RequestBody SmsFlashPromotionSession smsFlashPromotionSession ){
        int i = smsFlashPromotionSessionService.insertSmsFlashPromotionSessionInfo(smsFlashPromotionSession);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增秒杀活动失败");

    }

    @ApiOperation("修改秒杀时间段状态值")
    @RequestMapping(value = "/SmsFlashPromotionSession/updateStatus",method = RequestMethod.POST)
    public CommonResult updateSmsFlashPromotionSessionStatus(@RequestParam(name ="id" )  long id,@RequestParam(name ="status" )int status ){
        int i = smsFlashPromotionSessionService.updateSmsFlashPromotionSessionStatus(id,status);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("修改秒杀状态值失败");

    }


    @ApiOperation("删除秒杀时间段活动")
    @RequestMapping(value = "/SmsFlashPromotionSession/delete/{id}",method = RequestMethod.POST)
    public CommonResult deleteSmsFlashPromotionSession(@PathVariable("id")  long id ){
        int i = smsFlashPromotionSessionService.deleteSmsFlashPromotionSession(id);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("删除秒杀活动失败");

    }

    @ApiOperation("查询单个秒杀时间段活动")
    @RequestMapping(value = "/SmsFlashPromotionSession/select/{id}",method = RequestMethod.POST)
    public CommonResult selectSmsFlashPromotionSessionById(@PathVariable("id")  long id ){
        SmsFlashPromotionSession smsFlashPromotion   = smsFlashPromotionSessionService.selectSmsFlashPromotionSessionById(id);
        return  CommonResult.success(smsFlashPromotion);

    }
    
    @ApiOperation("查询有效的秒杀时间段活动和商品数量")
    @RequestMapping(value = "/SmsFlashPromotionSession/selectCount",method = RequestMethod.POST)
    public CommonResult selectSmsFlashPromotionSessionCount(@RequestParam(value = "flashPromotionId") long flashPromotionId){
       List<SmsFlashPromotionSessionReturn> selectSmsFlashPromotionSessionCount = smsFlashPromotionSessionService.selectSmsFlashPromotionSessionCount(flashPromotionId);
        return  CommonResult.success(selectSmsFlashPromotionSessionCount);

    }

}
