package cn.com.sparknet.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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
import cn.com.sparknet.dto.PmsProductParam;
import cn.com.sparknet.dto.PmsProductQueryParam;
import cn.com.sparknet.model.PmsProduct;
import cn.com.sparknet.service.PmsProductService;
import cn.com.sparknet.service.impl.PmsProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "PmsProductController",description = "商品管理")
public class PmsProductController {
	
	@Autowired
	private PmsProductService  pmsProductService;
	
	
	@ApiOperation("新增商品")
	@RequestMapping(value = "pmsProduct/insert",method = RequestMethod.POST)
	public CommonResult<Object> insertPmsProduct(@RequestBody PmsProductParam param) {
		int insertPmsProduct = pmsProductService.insertPmsProduct(param);
		if(insertPmsProduct>0){
            return   CommonResult.success(insertPmsProduct);
        }else{
            return   CommonResult.failed("修改失败");
        }
	}
	
	@ApiOperation("分页查询商品")
	@RequestMapping(value = "pmsProduct/selectByPage",method = RequestMethod.POST)
	public CommonResult<Object> selectPmsProductByPage(@RequestBody PmsProductQueryParam queryParam, @RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize) {
		List<PmsProduct> selectPmsProductByPage = pmsProductService.selectPmsProductByPage(queryParam, pageNum, pageSize);
		 
	            return   CommonResult.success(CommonPage.restPage(selectPmsProductByPage) );
	        
	}
	
	
	@ApiOperation("修改商品上架状态")
	@RequestMapping(value = "pmsProduct/updatePublishStatus",method = RequestMethod.POST)
	public CommonResult<Object> updatePublishStatus( @RequestParam(value = "ids" ) List<Long> ids,
			@RequestParam(value = "publishStatus" ) Integer publishStatus) {
		 int updatePublishStatus = pmsProductService.updatePublishStatus(ids,publishStatus);
		 if(updatePublishStatus>0){
	            return   CommonResult.success(updatePublishStatus);
	        }else{
	            return   CommonResult.failed("修改失败");
	        }
	        
	}
	
	@ApiOperation("修改商品新品状态")
	@RequestMapping(value = "pmsProduct/updateNewStatus",method = RequestMethod.POST)
	public CommonResult<Object> updateNewStatus( @RequestParam(value = "ids" ) List<Long> ids,
			@RequestParam(value = "newStatus" ) Integer newStatus) {
		 int updateNewStatus = pmsProductService.updateNewStatus(ids,newStatus);
		 if(updateNewStatus>0){
	            return   CommonResult.success(updateNewStatus);
	        }else{
	            return   CommonResult.failed("修改失败");
	        }
	        
	}
	@ApiOperation("修改商品推荐状态")
	@RequestMapping(value = "pmsProduct/updateRecommandStatus",method = RequestMethod.POST)
	public CommonResult<Object> updateRecommandStatus( @RequestParam(value = "ids" ) List<Long> ids,
			@RequestParam(value = "recommandStatus" ) Integer recommandStatus) {
		 int updateNewStatus = pmsProductService.updateRecommandStatus(ids,recommandStatus);
		 if(updateNewStatus>0){
	            return   CommonResult.success(updateNewStatus);
	        }else{
	            return   CommonResult.failed("修改失败");
	        }
	        
	}
	
	
	@ApiOperation("商品删除")
	@RequestMapping(value = "pmsProduct/deleteByProductIds",method = RequestMethod.POST)
	public CommonResult<Object> deleteByProductIds( @RequestParam(value = "ids" ) List<Long> ids,
			@RequestParam(value = "deleteStatus") int deleteStatus) {
		 int updateNewStatus = pmsProductService.deleteByProductIds(ids, deleteStatus);
		 if(updateNewStatus>0){
	            return   CommonResult.success(updateNewStatus);
	        }else{
	            return   CommonResult.failed("修改失败");
	        }
	        
	}
	
	@ApiOperation("通过id查询商品信息")
	@RequestMapping(value = "pmsProduct/select/{productId}",method = RequestMethod.POST)
	public CommonResult<Object> selectPmsProductByProductId( @PathVariable(value = "productId" ) Long productId
			) {
		List<PmsProductParam> selectPmsProductByProductId = pmsProductService.selectPmsProductByProductId(productId);
	            return   CommonResult.success(selectPmsProductByProductId);
	}
	
	@ApiOperation("通过id修改商品信息")
	@RequestMapping(value = "pmsProduct/updateByProductId/{productId}",method = RequestMethod.POST)
	public CommonResult<Object> updatePmsProductByProductId( @PathVariable(value = "productId" ) Long productId,
			@RequestBody PmsProductParam queryParam) {
		 int updatePmsProductByProductId = pmsProductService.updatePmsProductByProductId(productId,queryParam);
		 if(updatePmsProductByProductId>0){
	            return   CommonResult.success(updatePmsProductByProductId);
	        }else{
	            return   CommonResult.failed("修改失败");
	        }
	}
	

}
