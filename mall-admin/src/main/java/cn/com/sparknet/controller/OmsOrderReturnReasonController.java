package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.model.OmsOrder;
import cn.com.sparknet.model.OmsOrderReturnReason;
import cn.com.sparknet.service.OmsOrderReturnReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "OmsOrderReturnReasonController", description = "退货原因设置管理")
@RestController
public class OmsOrderReturnReasonController {

	@Autowired
	private OmsOrderReturnReasonService  omsOrderReturnReasonService;
	
	@ApiOperation("分页查询退货原因")
	@RequestMapping(value = "/OmsOrderReturnReason/listPage",method = RequestMethod.POST)
	public CommonResult selectOmsOrderReturnReasonListByPage(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize",defaultValue = "5") int pageSize) {
		List<OmsOrderReturnReason> selectOmsOrderReturnReasonListByPage = omsOrderReturnReasonService.selectOmsOrderReturnReasonListByPage(pageNum, pageSize);
		return	CommonResult.success(CommonPage.restPage(selectOmsOrderReturnReasonListByPage));
		
	} 
	
	@ApiOperation("修改退货原因状态值")
	@RequestMapping(value = "/OmsOrderReturnReason/updateStatusById",method = RequestMethod.POST)
	public CommonResult updateOmsOrderReturnReasonStatusById(@RequestParam(value = "id") Long id,
			@RequestParam(value = "status") int status) {
		int i = omsOrderReturnReasonService.updateOmsOrderReturnReasonStatusById(id, status);
		if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改退货原因状态值失败");
        }
	} 
	
	@ApiOperation("批量删除退货原因")
	@RequestMapping(value = "/OmsOrderReturnReason/deleteByIds",method = RequestMethod.POST)
	public CommonResult deleteOmsOrderReturnReasonByIds(@RequestParam(value = "ids") List<Long> ids) {
		int i = omsOrderReturnReasonService.deleteOmsOrderReturnReasonByIds(ids);
		if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("批量删除退货原因失败");
        }
	} 
	
	@ApiOperation("查询单个退货原因")
	@RequestMapping(value = "/OmsOrderReturnReason/selectById/{id}",method = RequestMethod.POST)
	public CommonResult selectOmsOrderReturnReasonById(@PathVariable(value = "id") Long id) {
		OmsOrderReturnReason selectOmsOrderReturnReasonById = omsOrderReturnReasonService.selectOmsOrderReturnReasonById(id);
            return   CommonResult.success(selectOmsOrderReturnReasonById);
	} 
	
	
	@ApiOperation("修改单个退货原因")
	@RequestMapping(value = "/OmsOrderReturnReason/updateById/{id}",method = RequestMethod.POST)
	public CommonResult updateOmsOrderReturnReasonById(@PathVariable(value = "id") Long id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "status") Integer status,@RequestParam(value = "sort") Integer sort) {
		int i=omsOrderReturnReasonService.updateOmsOrderReturnReasonById(id,name,status,sort);
		if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改单个退货原因失败");
        }
	} 
	
	@ApiOperation("新增单个退货原因")
	@RequestMapping(value = "/OmsOrderReturnReason/insert",method = RequestMethod.POST)
	public CommonResult insertOmsOrderReturnReason(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "status") Integer status,@RequestParam(value = "sort") Integer sort) {
		int i=omsOrderReturnReasonService.insertOmsOrderReturnReason(name,status,sort);
		if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("新增单个退货原因失败");
        }
	} 
	
	
}
