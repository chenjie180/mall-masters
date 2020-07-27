package cn.com.sparknet.service.impl;

import cn.com.sparknet.mapper.PmsSkuStockMapper;
import cn.com.sparknet.model.PmsSkuStock;
import cn.com.sparknet.model.PmsSkuStockExample;
import cn.com.sparknet.model.PmsSkuStockExample.Criteria;
import cn.com.sparknet.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public int updatePmsSkuStockByProductId(Long productId, List<PmsSkuStock> pmsSkuStockList) {
		PmsSkuStockExample example=new PmsSkuStockExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andProductIdEqualTo(productId);
		int updateByExampleSelective = 0;
		for (PmsSkuStock pmsSkuStock : pmsSkuStockList) {
			 updateByExampleSelective = pmsSkuStockMapper.updateByExampleSelective(pmsSkuStock, example);
		}
		return updateByExampleSelective;
	}

	@Override
	public int updatePmsSkuStockListbyProductId(Long productId, List<PmsSkuStock> pmsSkuStockList) {
		PmsSkuStockExample pmsSkuStockExample=new PmsSkuStockExample();
		pmsSkuStockExample.createCriteria().andProductIdEqualTo(productId);
		int i = 0;
		for (PmsSkuStock pmsSkuStock: pmsSkuStockList){
			i = pmsSkuStockMapper.updateByExampleSelective(pmsSkuStock, pmsSkuStockExample);
		};
		return i;
	}

}
