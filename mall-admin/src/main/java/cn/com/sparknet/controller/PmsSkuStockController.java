package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.PmsSkuStock;
import cn.com.sparknet.service.PmsSkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "PmsSkuStockController",description = "商品sku管理")
public class PmsSkuStockController {
	
	@Autowired
	private PmsSkuStockService pmsSkuStockService;
	
	@ApiOperation("通过productId查询商品sku")
	@RequestMapping(value = "pmsSkuStock/selectByproductId",method = RequestMethod.POST)
	public List<PmsSkuStock> selectPmsSkuStockListbyProductId(@RequestParam(value = "productId") Long productId,
			@RequestParam(value = "skuCode")String skuCode){
		List<PmsSkuStock> selectPmsSkuStockListbyProductId = pmsSkuStockService.selectPmsSkuStockListbyProductId(productId, skuCode);
				return selectPmsSkuStockListbyProductId;
		
	}
	
	@ApiOperation("通过productId修改商品sku")
	@RequestMapping(value = "pmsSkuStock/updateByProductId",method = RequestMethod.POST)
	public CommonResult<Integer> updatePmsSkuStockByProductId(@RequestParam(value = "productId") Long productId,
			@RequestBody List<PmsSkuStock> pmsSkuStockList ){
		 int updatePmsSkuStockByProductId = pmsSkuStockService.updatePmsSkuStockByProductId(productId, pmsSkuStockList);
		 if(updatePmsSkuStockByProductId>0){
	            return   CommonResult.success(updatePmsSkuStockByProductId);
	        }else{
	            return   CommonResult.failed("修改失败");
	        }
		
	}

}
