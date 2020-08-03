package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.PmsProductParam;
import cn.com.sparknet.dto.PmsProductQueryParam;
import cn.com.sparknet.model.PmsProduct;

public interface PmsProductService {

	public int insertPmsProduct(PmsProductParam param) ;

	public List<PmsProduct> selectPmsProductByPage(PmsProductQueryParam queryParam, Integer pageNum, Integer pageSize);

	public int updatePublishStatus(List<Long> ids, Integer publishStatus);
	
	public int updateNewStatus(List<Long> ids, Integer newStatus);
	
	public int updateRecommandStatus(List<Long> ids, Integer recommandStatus);

	public int deleteByProductIds(List<Long> ids,int deleteStatus);

	public List<PmsProductParam> selectPmsProductByProductId(Long id) ;

	public int updatePmsProductByProductId(Long productId, PmsProductParam queryParam);

	public List<PmsProduct> selectPmsProductByKeys(String keys);
}
