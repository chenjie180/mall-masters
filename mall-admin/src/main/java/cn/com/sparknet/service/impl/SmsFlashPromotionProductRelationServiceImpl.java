package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dao.SmsFlashPromotionProductRelationDao;
import cn.com.sparknet.dto.SmsFlashPromotionProductRelationReturn;
import cn.com.sparknet.mapper.SmsFlashPromotionProductRelationMapper;
import cn.com.sparknet.model.SmsFlashPromotionProductRelation;
import cn.com.sparknet.model.SmsFlashPromotionProductRelationExample;
import cn.com.sparknet.service.SmsFlashPromotionProductRelationService;

@Service
public class SmsFlashPromotionProductRelationServiceImpl implements SmsFlashPromotionProductRelationService{
	
	@Autowired
	private SmsFlashPromotionProductRelationMapper flashPromotionProductRelationMapper;
	@Autowired
	private SmsFlashPromotionProductRelationDao smsFlashPromotionProductRelationDao;
	
	public long selectCountById(Long promotionId,Long promotionSessionId) {
//		SmsFlashPromotionProductRelationExample example=new SmsFlashPromotionProductRelationExample();
//		example.createCriteria().andFlashPromotionIdEqualTo(promotionId).andFlashPromotionSessionIdEqualTo(promotionSessionId);
//		return flashPromotionProductRelationMapper.countByExample(example);
		 SmsFlashPromotionProductRelationExample examples = new SmsFlashPromotionProductRelationExample();
	        examples.createCriteria()
	                .andFlashPromotionIdEqualTo(promotionId)
	                .andFlashPromotionSessionIdEqualTo(promotionSessionId);
	        return flashPromotionProductRelationMapper.countByExample(examples);
	}

	@Override
	public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
		 SmsFlashPromotionProductRelationExample examples = new SmsFlashPromotionProductRelationExample();
	        examples.createCriteria()
	                .andFlashPromotionIdEqualTo(flashPromotionId)
	                .andFlashPromotionSessionIdEqualTo(flashPromotionSessionId);
	        return flashPromotionProductRelationMapper.countByExample(examples);
	}

	@Override
	public List<SmsFlashPromotionProductRelationReturn> selectSmsFlashPromotionProductRelationByPage(Integer pageNum, Integer pageSize, Long promotionId,
			Long promotionSessionId) {
		PageHelper.startPage(pageNum, pageSize);
		List<SmsFlashPromotionProductRelationReturn> selectSmsFlashPromotionProductRelationByPage = smsFlashPromotionProductRelationDao.selectSmsFlashPromotionProductRelationByPage(promotionId,promotionSessionId);
		return selectSmsFlashPromotionProductRelationByPage;
		
	}

	@Override
	public int insertSmsFlashPromotionProductRelationbatch(
			List<SmsFlashPromotionProductRelation> smsFlashPromotionProductRelationList) {
		int i=smsFlashPromotionProductRelationDao.insertSmsFlashPromotionProductRelationbatch(smsFlashPromotionProductRelationList);
		return i;
	}

	@Override
	public int updateSmsFlashPromotionProductRelation(
			SmsFlashPromotionProductRelation smsFlashPromotionProductRelation) {
		SmsFlashPromotionProductRelationExample example=new SmsFlashPromotionProductRelationExample();
		example.createCriteria().andIdEqualTo(smsFlashPromotionProductRelation.getId());
		int updateByExampleSelective = flashPromotionProductRelationMapper.updateByExampleSelective(smsFlashPromotionProductRelation, example);
		return updateByExampleSelective;
	}

	@Override
	public int deleteSmsFlashPromotionProductRelation(Long id) {
		int deleteByPrimaryKey = flashPromotionProductRelationMapper.deleteByPrimaryKey(id);
		return deleteByPrimaryKey;
	}

}
