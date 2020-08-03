package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.SmsHomeNewProduct;
import cn.com.sparknet.model.SmsHomeRecommendProduct;

public interface SmsHomeRecommendProductService {

	public int insertSmsHomeRecommendProductInfo(SmsHomeRecommendProduct smsHomeRecommendProduct);

	public List<SmsHomeRecommendProduct> selectSmsHomeRecommendProductByPage(Integer pageNum, Integer pageSize,
			String productName, Integer recommendStatus);

	public int deleteSmsHomeRecommendProductByIds(List<Long> ids);

	public int updateSmsHomeRecommendProductStatusByIds(List<Long> ids, int recommendStatus);

	public int updateSmsHomeRecommendProductSortById(Long id, int sort);

}
