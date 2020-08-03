package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.mapper.SmsHomeNewProductMapper;
import cn.com.sparknet.mapper.SmsHomeRecommendProductMapper;
import cn.com.sparknet.model.SmsHomeNewProduct;
import cn.com.sparknet.model.SmsHomeNewProductExample;
import cn.com.sparknet.model.SmsHomeRecommendProduct;
import cn.com.sparknet.model.SmsHomeRecommendProductExample;
import cn.com.sparknet.service.SmsHomeRecommendProductService;
@Service
public class SmsHomeRecommendProductServiceImpl implements SmsHomeRecommendProductService {
	@Autowired
	private SmsHomeRecommendProductMapper smsHomeRecommendProductMapper;

	@Override
	public int insertSmsHomeRecommendProductInfo(SmsHomeRecommendProduct smsHomeRecommendProduct) {
		int insertSelective = smsHomeRecommendProductMapper.insertSelective(smsHomeRecommendProduct);
		return insertSelective;
	}

	@Override
	public List<SmsHomeRecommendProduct> selectSmsHomeRecommendProductByPage(Integer pageNum, Integer pageSize,
			String productName, Integer recommendStatus) {
		PageHelper.startPage(pageNum, pageSize);
		SmsHomeRecommendProductExample example=new SmsHomeRecommendProductExample();
		if(!StringUtils.isEmpty(productName)) {
			example.createCriteria().andProductNameLike("%"+productName+"%");
		}
		if(!StringUtils.isEmpty(recommendStatus)) {
			example.createCriteria().andRecommendStatusEqualTo(recommendStatus);
		}
		List<SmsHomeRecommendProduct> selectByExample = smsHomeRecommendProductMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public int deleteSmsHomeRecommendProductByIds(List<Long> ids) {
		SmsHomeRecommendProductExample example=new SmsHomeRecommendProductExample();
		example.createCriteria().andIdIn(ids);
		int deleteByExample = smsHomeRecommendProductMapper.deleteByExample(example);
		return deleteByExample;
	}

	@Override
	public int updateSmsHomeRecommendProductStatusByIds(List<Long> ids, int recommendStatus) {
		SmsHomeRecommendProduct record=new SmsHomeRecommendProduct();
		record.setRecommendStatus(recommendStatus);
		SmsHomeRecommendProductExample example=new SmsHomeRecommendProductExample();
		example.createCriteria().andIdIn(ids);
		int updateByExampleSelective = smsHomeRecommendProductMapper.updateByExampleSelective(record, example);
		return updateByExampleSelective;
	}

	@Override
	public int updateSmsHomeRecommendProductSortById(Long id, int sort) {
		SmsHomeRecommendProduct record=new SmsHomeRecommendProduct();
		record.setId(id);
		record.setSort(sort);
		int updateByPrimaryKeySelective = smsHomeRecommendProductMapper.updateByPrimaryKeySelective(record);
		return updateByPrimaryKeySelective;
	}
}
