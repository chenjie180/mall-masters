package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.SmsHomeNewProduct;

public interface SmsHomeNewProductService {

	public int insertSmsHomeNewProductInfo(SmsHomeNewProduct smsHomeNewProduct);

	public List<SmsHomeNewProduct> selectSmsHomeNewProductByPage(Integer pageNum, Integer pageSize, String productName,
			Integer recommendStatus);

	public int deleteSmsHomeNewProductByIds(List<Long> ids);

	public int updateSmsHomeNewProductStatusByIds(List<Long> ids, int recommendStatus);

	public int updateSmsHomeNewProductSortById(Long id, int sort);

}
