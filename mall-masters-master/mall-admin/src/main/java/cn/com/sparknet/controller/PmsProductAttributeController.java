package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.PmsProductAttributeParam;
import cn.com.sparknet.model.PmsProductAttribute;
import cn.com.sparknet.model.PmsProductAttributeCategory;
import cn.com.sparknet.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "PmsProductAttributeController",description = "商品品牌管理")
public class PmsProductAttributeController {
	
	@Autowired
	private PmsProductAttributeService pmsProductAttributeService;
	
	@ApiOperation("新增商品属性")
	@RequestMapping(value = "PmsProductAttribute/insert",method =RequestMethod.POST)
	public CommonResult insertPmsProductAttribute(@Validated @RequestBody PmsProductAttributeParam pmsProductAttributeParam,
			 BindingResult result) {
		int insertPmsProductAttribute = pmsProductAttributeService.insertPmsProductAttribute(pmsProductAttributeParam);
		if(insertPmsProductAttribute>0) {
			return	CommonResult.success(insertPmsProductAttribute);
			}else {
				return CommonResult.failed("通过id修改商品类型失败");
			}
		
	}
	
	
	@ApiOperation("分页查询商品属性")
	@RequestMapping(value = "/PmsProductAttribute/listPage/{productAttributeCategoryId}/{type}",method = RequestMethod.POST)
	public CommonResult selectPmsProductAttributeListByPage(@PathVariable(name ="productAttributeCategoryId" ) long productAttributeCategoryId,
			@PathVariable(name ="type" ) int type,@RequestParam(value  = "pageNum",defaultValue ="1" ) int pageNum,
			@RequestParam(value  = "pageSize",defaultValue ="5") int pageSize) {
		List<PmsProductAttribute> selectPmsProductAttributeListByPage = pmsProductAttributeService.selectPmsProductAttributeListByPage(productAttributeCategoryId,type,pageNum, pageSize);
		if(!StringUtils.isEmpty(selectPmsProductAttributeListByPage)) {
		return	CommonResult.success(CommonPage.restPage(selectPmsProductAttributeListByPage));
		}else {
			return CommonResult.failed("失败");
		}
		
	}
	
	@ApiOperation("查询所有的商品属性")
	@RequestMapping(value = "/PmsProductAttributeCategory/listAll",method = RequestMethod.POST)
	public CommonResult<List<PmsProductAttributeCategory>> selectPmsProductAttributeCategoryListAll(
			) {
		List<PmsProductAttributeCategory> selectPmsProductAttributeCategoryListAll = pmsProductAttributeService.selectPmsProductAttributeCategoryListAll();
		if(!CollectionUtils.isEmpty(selectPmsProductAttributeCategoryListAll)) {
		return	CommonResult.success(selectPmsProductAttributeCategoryListAll);
		}else {
			return CommonResult.failed("失败");
		}
		
	}
	
	@ApiOperation("批量删除商品属性")
	@RequestMapping(value = "/PmsProductAttribute/delete",method = RequestMethod.POST)
	public CommonResult deletePmsProductAttributeListByIds(@RequestParam("ids") List<Long> ids) {
		int deletePmsProductAttributeListByIds = pmsProductAttributeService.deletePmsProductAttributeListByIds(ids);
		if(deletePmsProductAttributeListByIds>0) {
			return	CommonResult.success(deletePmsProductAttributeListByIds);
			}else {
				return CommonResult.failed("批量删除商品属性失败");
			}
	}
	
	@ApiOperation("删除商品属性")
	@RequestMapping(value = "/PmsProductAttribute/delete/{id}",method = RequestMethod.POST)
	public CommonResult deletePmsProductAttribute(@PathVariable("id") Long id) {
		int deletePmsProductAttributeListByIds = pmsProductAttributeService.deletePmsProductAttribute(id);
		if(deletePmsProductAttributeListByIds>0) {
			return	CommonResult.success(deletePmsProductAttributeListByIds);
			}else {
				return CommonResult.failed("批量删除商品属性失败");
			}
	}
	
	
	@ApiOperation("通过id查询商品属性")
	@RequestMapping(value = "/PmsProductAttribute/{id}",method = RequestMethod.POST)
	public CommonResult selectPmsProductAttributeById(@PathVariable("id") Long id) {
		 PmsProductAttribute selectPmsProductAttributeById = pmsProductAttributeService.selectPmsProductAttributeById(id);
		 if(!StringUtils.isEmpty(selectPmsProductAttributeById)) {
				return	CommonResult.success(selectPmsProductAttributeById);
				}else {
					return CommonResult.failed("失败");
				}
	}
	
	
	@ApiOperation("通过id修改商品属性")
	@RequestMapping(value = "/PmsProductAttribute/update/{id}",method = RequestMethod.POST)
	public CommonResult updatePmsProductAttributeById(@PathVariable("id") Long id,@RequestBody PmsProductAttributeParam pmsProductAttributeParam ) {
		 int updatePmsProductAttributeById = pmsProductAttributeService.updatePmsProductAttributeById(id,pmsProductAttributeParam);
		 if(updatePmsProductAttributeById>0) {
				return	CommonResult.success(updatePmsProductAttributeById);
				}else {
					return CommonResult.failed("失败");
				}
	}
	

}
