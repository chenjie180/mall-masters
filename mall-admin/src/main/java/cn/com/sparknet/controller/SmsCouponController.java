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
import cn.com.sparknet.dto.SmsCouponParam;
import cn.com.sparknet.model.SmsCoupon;
import cn.com.sparknet.service.SmsCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "SmsCouponController",description = "优惠卷管理")
public class SmsCouponController {
	@Autowired
	private SmsCouponService smsCouponService;
	
	@ApiOperation("分页查询优惠卷活动列表")
    @RequestMapping(value = "/SmsCoupon/selectByPage",method = RequestMethod.POST)
	public CommonResult<CommonPage<SmsCoupon>> selectSmsCouponByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,String name, Integer type){
		List<SmsCoupon> selectSmsCouponByPage = smsCouponService.selectSmsCouponByPage(pageNum,pageSize,name,type);
		 return  CommonResult.success(CommonPage.restPage(selectSmsCouponByPage));
		
	}
	
	@ApiOperation("新增优惠卷活动")
    @RequestMapping(value = "/SmsCoupon/insert",method = RequestMethod.POST)
	public CommonResult<Integer> insertSmsCoupon(@RequestBody SmsCouponParam couponParam){
		int i = smsCouponService.insertSmsCoupon(couponParam);
		 if(i>0){
	            return  CommonResult.success(i);
	        }
	        return  CommonResult.failed("新增优惠卷活动失败");
		
	}
	
	@ApiOperation("删除优惠卷活动")
    @RequestMapping(value = "/SmsCoupon/delete",method = RequestMethod.POST)
	public CommonResult<Integer> deleteSmsCoupon(@RequestParam Long id){
		int i = smsCouponService.deleteSmsCoupon(id);
		 if(i>0){
	            return  CommonResult.success(i);
	        }
	        return  CommonResult.failed("删除优惠卷活动失败");
		
	}
	
	
	@ApiOperation("查询单个优惠卷活动")
    @RequestMapping(value = "/SmsCoupon/select/{id}",method = RequestMethod.POST)
	public CommonResult<SmsCoupon> selectSmsCouponById(@PathVariable("id") Long id){
		SmsCoupon selectSmsCouponById = smsCouponService.selectSmsCouponById(id);
		 
	        return  CommonResult.success(selectSmsCouponById);
		
	}
	@ApiOperation("查询要修改的优惠卷活动")
    @RequestMapping(value = "/SmsCoupon/selectById/{id}",method = RequestMethod.POST)
	public CommonResult<List<SmsCouponParam>> selectSmsCouponInfoById(@PathVariable("id") Long id){
		List<SmsCouponParam> selectSmsCouponInfoById = smsCouponService.selectSmsCouponInfoById(id);
	        return  CommonResult.success(selectSmsCouponInfoById);
		
	}
	
	@ApiOperation("修改优惠卷活动")
    @RequestMapping(value = "/SmsCoupon/update",method = RequestMethod.POST)
	public CommonResult updateSmsCouponInfoById(@RequestBody SmsCouponParam smsCouponParam){
		int i = smsCouponService.updateSmsCouponInfoById(smsCouponParam);
		if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("修改优惠卷活动失败");
	
}
		
	

}
