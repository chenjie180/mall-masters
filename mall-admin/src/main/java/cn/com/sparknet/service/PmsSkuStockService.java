package cn.com.sparknet.service;

import cn.com.sparknet.model.PmsSkuStock;

import java.util.List;

public interface PmsSkuStockService {

	public List<PmsSkuStock> selectPmsSkuStockListbyProductId(Long productId,String skuCode);

	public int updatePmsSkuStockByProductId(Long productId, List<PmsSkuStock> pmsSkuStockList);

    int updatePmsSkuStockListbyProductId(Long productId, List<PmsSkuStock> pmsSkuStockList);
}
