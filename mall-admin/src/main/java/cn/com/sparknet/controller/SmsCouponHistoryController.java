package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.SmsCouponHistory;
import cn.com.sparknet.model.SmsFlashPromotion;
import cn.com.sparknet.service.SmsCouponHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "SmsCouponHistoryController",description = "用户秒杀活动记录管理")
public class SmsCouponHistoryController {

	
	@Autowired
	private  SmsCouponHistoryService smsCouponHistoryService;
	
	
	@ApiOperation("查询用户秒杀活动列表")
    @RequestMapping(value = "/SmsCouponHistory/select/{couponId}",method = RequestMethod.POST)
	  public CommonResult selectSmsCouponHistoryByCouponId( @RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
			  @RequestParam(value = "useStatus") Integer useStatus,@RequestParam(value = "orderId") Long orderId ,
              @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize, @PathVariable("couponId") Long couponId){
List<SmsCouponHistory> selectSmsCouponHistoryByCouponId = smsCouponHistoryService.selectSmsCouponHistoryByCouponId(pageNum,pageSize,couponId,useStatus,orderId);
return  CommonResult.success(CommonPage.restPage(selectSmsCouponHistoryByCouponId));

}
}
