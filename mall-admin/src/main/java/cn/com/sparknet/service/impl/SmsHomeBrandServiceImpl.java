package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.mapper.SmsHomeBrandMapper;
import cn.com.sparknet.model.SmsHomeBrand;
import cn.com.sparknet.model.SmsHomeBrandExample;
import cn.com.sparknet.service.SmsHomeBrandService;
@Service
public class SmsHomeBrandServiceImpl implements SmsHomeBrandService {
	
	@Autowired
	private SmsHomeBrandMapper brandMapper;
	

	@Override
	public int insertSmsFlashPromotionSessionInfo(SmsHomeBrand smsHomeBrand) {
		smsHomeBrand.setSort(0);
		smsHomeBrand.setRecommendStatus(1);
		int insertSelective = brandMapper.insertSelective(smsHomeBrand);
		return insertSelective;
	}


	@Override
	public List<SmsHomeBrand> selectSmsHomeBrandByPage(Integer pageNum, Integer pageSize, String brandName,
			Integer recommendStatus) {
		PageHelper.startPage(pageNum, pageSize);
		SmsHomeBrandExample brandExample=new SmsHomeBrandExample();
		if(!StringUtils.isEmpty(brandName)) {
			brandExample.createCriteria().andBrandNameLike("%"+brandName+"%");
		}
		if(!StringUtils.isEmpty(recommendStatus)) {
			brandExample.createCriteria().andRecommendStatusEqualTo(recommendStatus);
		}
		List<SmsHomeBrand> selectByExample = brandMapper.selectByExample(brandExample);
		return selectByExample;
	}


	@Override
	public int deleteSmsHomeBrandByIds(List<Long> ids) {
		SmsHomeBrandExample brandExample=new SmsHomeBrandExample();
		brandExample.createCriteria().andIdIn(ids);
		int deleteByExample = brandMapper.deleteByExample(brandExample);
		return deleteByExample;
	}


	@Override
	public int updateSmsHomeBrandStatusByIds(List<Long> ids, int recommendStatus) {
		SmsHomeBrandExample brandExample=new SmsHomeBrandExample();
		brandExample.createCriteria().andIdIn(ids);
		SmsHomeBrand record=new SmsHomeBrand();
		record.setRecommendStatus(recommendStatus);
		int example = brandMapper.updateByExampleSelective(record, brandExample);
		return example;
	}


	@Override
	public int updateSmsHomeBrandSortById(Long id, int sort) {
		SmsHomeBrand record=new SmsHomeBrand();
		record.setId(id);
		record.setSort(sort);
		int updateByPrimaryKeySelective = brandMapper.updateByPrimaryKeySelective(record);
		return updateByPrimaryKeySelective;
	}

}
