package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.PmsSkuStock;

public interface PmsSkuStockService {

	public List<PmsSkuStock> selectPmsSkuStockListbyProductId(Long productId,String skuCode);
	
}
