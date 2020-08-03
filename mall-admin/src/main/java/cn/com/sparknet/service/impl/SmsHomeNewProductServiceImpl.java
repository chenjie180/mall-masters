package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.mapper.SmsHomeNewProductMapper;
import cn.com.sparknet.model.SmsHomeNewProduct;
import cn.com.sparknet.model.SmsHomeNewProductExample;
import cn.com.sparknet.service.SmsHomeNewProductService;
@Service
public class SmsHomeNewProductServiceImpl implements SmsHomeNewProductService {

	@Autowired
	private SmsHomeNewProductMapper homeNewProductMapper;

	@Override
	public int insertSmsHomeNewProductInfo(SmsHomeNewProduct smsHomeNewProduct) {
		int insertSelective = homeNewProductMapper.insertSelective(smsHomeNewProduct);
		return insertSelective;
	}

	@Override
	public List<SmsHomeNewProduct> selectSmsHomeNewProductByPage(Integer pageNum, Integer pageSize, String productName,
			Integer recommendStatus) {
		PageHelper.startPage(pageNum, pageSize);
		SmsHomeNewProductExample example=new SmsHomeNewProductExample();
		if(!StringUtils.isEmpty(productName)) {
			example.createCriteria().andProductNameLike("%"+productName+"%");
		}
		if(!StringUtils.isEmpty(recommendStatus)) {
			example.createCriteria().andRecommendStatusEqualTo(recommendStatus);
		}
		List<SmsHomeNewProduct> selectByExample = homeNewProductMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public int deleteSmsHomeNewProductByIds(List<Long> ids) {
		SmsHomeNewProductExample example=new SmsHomeNewProductExample();
		example.createCriteria().andIdIn(ids);
		int deleteByExample = homeNewProductMapper.deleteByExample(example);
		return deleteByExample;
	}

	@Override
	public int updateSmsHomeNewProductStatusByIds(List<Long> ids, int recommendStatus) {
		SmsHomeNewProduct record=new SmsHomeNewProduct();
		record.setRecommendStatus(recommendStatus);
		SmsHomeNewProductExample example=new SmsHomeNewProductExample();
		example.createCriteria().andIdIn(ids);
		int updateByExampleSelective = homeNewProductMapper.updateByExampleSelective(record, example);
		return updateByExampleSelective;
	}

	@Override
	public int updateSmsHomeNewProductSortById(Long id, int sort) {
		SmsHomeNewProduct record=new SmsHomeNewProduct();
		record.setId(id);
		record.setSort(sort);
		int updateByPrimaryKeySelective = homeNewProductMapper.updateByPrimaryKeySelective(record);
		return updateByPrimaryKeySelective;
	}
	
	
}
