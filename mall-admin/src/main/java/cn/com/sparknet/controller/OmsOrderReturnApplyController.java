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
import cn.com.sparknet.dto.OmsOrderReturnApplyParam;
import cn.com.sparknet.dto.OmsUpdateStatusParam;
import cn.com.sparknet.model.OmsOrderReturnApply;
import cn.com.sparknet.model.OmsOrderReturnReason;
import cn.com.sparknet.service.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "OmsOrderReturnApplyController", description = "退货申请处理管理")
@RestController
public class OmsOrderReturnApplyController {
	@Autowired
	private OmsOrderReturnApplyService omsOrderReturnApplyService;

	@ApiOperation("分页查询退货申请处理")
	@RequestMapping(value = "/OmsOrderReturnApply/listPage",method = RequestMethod.POST)
	public CommonResult selectOmsOrderReturnApplyByPage(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize",defaultValue = "5") int pageSize,OmsOrderReturnApplyParam omsOrderReturnApplyParam) {
		List<OmsOrderReturnApply> selectOmsOrderReturnReasonListByPage = omsOrderReturnApplyService.selectOmsOrderReturnApplyByPage(omsOrderReturnApplyParam,pageNum, pageSize);
		return	CommonResult.success(CommonPage.restPage(selectOmsOrderReturnReasonListByPage));
		
	} 
	
	
	@ApiOperation("批量删除退货申请处理")
	@RequestMapping(value = "/OmsOrderReturnApply/delete",method = RequestMethod.POST)
	public CommonResult deleteOmsOrderReturnApplyByIds(@RequestParam(value = "ids") List<Long> ids) {
		int i = omsOrderReturnApplyService.deleteOmsOrderReturnApplyByIds(ids);
		if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("批量删除退货申请处理失败");
        }
		
	} 
	
	@ApiOperation("查询单个退货申请处理")
	@RequestMapping(value = "/OmsOrderReturnApply/{id}",method = RequestMethod.POST)
	public CommonResult selectOmsOrderReturnApplyById(@PathVariable(value = "id") Long id) {
		OmsOrderReturnApply selectOmsOrderReturnApplyById = omsOrderReturnApplyService.selectOmsOrderReturnApplyById(id);
		return	CommonResult.success(selectOmsOrderReturnApplyById);
		
	} 
	
	
	@ApiOperation("修改退货申请的状态值")
	@RequestMapping(value = "/OmsOrderReturnApply/updateStatus/{id}",method = RequestMethod.POST)
	public CommonResult updateOmsOrderReturnApplyStatus(@PathVariable(value = "id") Long id,OmsUpdateStatusParam omsUpdateStatusParam) {
		int i = omsOrderReturnApplyService.updateOmsOrderReturnApplyStatus(id,omsUpdateStatusParam);
		if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改退货申请的状态值失败");
        }
		
	} 
	
}
