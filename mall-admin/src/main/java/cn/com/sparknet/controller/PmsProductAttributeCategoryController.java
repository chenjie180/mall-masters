package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.PmsProductAttributeCategoryParam;
import cn.com.sparknet.model.PmsProductAttributeCategory;
import cn.com.sparknet.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "PmsProductAttributeCategoryController", description = "商品类型管理")
public class PmsProductAttributeCategoryController {
	
	@Autowired
	private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;
	
	
	@ApiOperation("分页查询商品类型")
	@RequestMapping(value = "/PmsProductAttributeCategory/listPage",method = RequestMethod.POST)
	public CommonResult selectPmsProductAttributeCategoryListByPage(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		List<PmsProductAttributeCategory> selectPmsProductAttributeCategoryByPage = pmsProductAttributeCategoryService.selectPmsProductAttributeCategoryListByPage(pageNum, pageSize);
		if(!StringUtils.isEmpty(selectPmsProductAttributeCategoryByPage)) {
		return	CommonResult.success(CommonPage.restPage(selectPmsProductAttributeCategoryByPage));
		}else {
			return CommonResult.failed("失败");
		}
		
	}
	
	
	@ApiOperation("新增商品类型")
	@RequestMapping(value = "/PmsProductAttributeCategory/insert",method = RequestMethod.POST)
	public CommonResult insertPmsProductAttributeCategory(@RequestBody PmsProductAttributeCategoryParam pmsProductAttributeCategoryParam) {
		 int insertPmsProductAttributeCategory = pmsProductAttributeCategoryService.insertPmsProductAttributeCategory(pmsProductAttributeCategoryParam);
		if(insertPmsProductAttributeCategory>0) {
		return	CommonResult.success(insertPmsProductAttributeCategory);
		}else {
			return CommonResult.failed("新增商品类型失败");
		}
		
	}
	
	
	@ApiOperation("通过id查询商品类型")
	@RequestMapping(value = "/PmsProductAttributeCategory/{id}",method = RequestMethod.POST)
	public CommonResult selectPmsProductAttributeCategoryById(@PathVariable("id") long id) {
		PmsProductAttributeCategory selectPmsProductAttributeCategoryById = pmsProductAttributeCategoryService.selectPmsProductAttributeCategoryById(id);
		if(!StringUtils.isEmpty(selectPmsProductAttributeCategoryById)) {
		return	CommonResult.success(selectPmsProductAttributeCategoryById);
		}else {
			return CommonResult.failed("通过id查询商品类型失败");
		}
		
	}
	
	
	
	
	
	@ApiOperation("通过id修改商品类型")
	@RequestMapping(value = "/PmsProductAttributeCategory/update/{id}",method = RequestMethod.POST)
	public CommonResult updatePmsProductAttributeCategoryById(@PathVariable("id") long id,@RequestBody PmsProductAttributeCategoryParam pmsProductAttributeCategoryParam) {
		int updatePmsProductAttributeCategoryById = pmsProductAttributeCategoryService.updatePmsProductAttributeCategoryById(id,pmsProductAttributeCategoryParam);
		if(updatePmsProductAttributeCategoryById>0) {
			return	CommonResult.success(updatePmsProductAttributeCategoryById);
			}else {
				return CommonResult.failed("通过id修改商品类型失败");
			}
		
	}
	
	
	
	@ApiOperation("通过id删除商品类型")
	@RequestMapping(value = "/PmsProductAttributeCategory/delete/{id}",method = RequestMethod.POST)
	public CommonResult deletePmsProductAttributeCategoryById(@PathVariable("id") long id) {
		int updatePmsProductAttributeCategoryById = pmsProductAttributeCategoryService.deletePmsProductAttributeCategoryById(id);
		if(updatePmsProductAttributeCategoryById>0) {
			return	CommonResult.success(updatePmsProductAttributeCategoryById);
			}else {
				return CommonResult.failed("通过id修改商品类型失败");
			}
		
	}
	
	
	
	

}
