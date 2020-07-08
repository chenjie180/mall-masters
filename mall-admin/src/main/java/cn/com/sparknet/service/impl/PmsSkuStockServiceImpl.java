package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sparknet.mapper.PmsSkuStockMapper;
import cn.com.sparknet.model.PmsSkuStock;
import cn.com.sparknet.model.PmsSkuStockExample;
import cn.com.sparknet.model.PmsSkuStockExample.Criteria;
import cn.com.sparknet.service.PmsSkuStockService;

@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {
	@Autowired
	private PmsSkuStockMapper pmsSkuStockMapper;
	
	public List<PmsSkuStock> selectPmsSkuStockListbyProductId(Long productId,String skuCode) {
		PmsSkuStockExample example=new PmsSkuStockExample();
		Criteria createCriteria = example.createCriteria();
		if(null!=skuCode) {
			createCriteria.andSkuCodeLike("%"+skuCode+"%");
		}
		createCriteria.andProductIdEqualTo(productId);
		List<PmsSkuStock> selectByExample = pmsSkuStockMapper.selectByExample(example);
		return selectByExample;
	}

}
