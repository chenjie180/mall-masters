package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.model.OmsOrder;
import cn.com.sparknet.model.PmsProductAttributeCategory;
import cn.com.sparknet.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "OmsOrderController", description = "订单管理")
@RestController
public class OmsOrderController {
	
	@Autowired
	private OmsOrderService omsOrderService;
	
	@ApiOperation("分页查询订单管理")
	@RequestMapping(value = "/omsOrder/listPage",method = RequestMethod.POST)
	public CommonResult selectOmsOrderListByPage(@RequestBody OmsOrderParam omsOrderParam,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize",defaultValue = "5") int pageSize) {
			
		List<OmsOrder> selectOmsOrderListByPage = omsOrderService.selectOmsOrderListByPage(omsOrderParam, pageNum, pageSize);
		return	CommonResult.success(selectOmsOrderListByPage);
		
	} 
	
	
	@ApiOperation("关闭订单管理")
	@RequestMapping(value = "/omsOrder/close",method = RequestMethod.POST)
	public CommonResult closeOmsOrderList(@RequestParam(value = "status") int status,
			@RequestParam(value = "ids") List<Long> ids) {
			
		 omsOrderService.closeOmsOrderList(status, ids);
		return	null;//CommonResult.success(selectOmsOrderListByPage);
		
	} 
	
	

}
