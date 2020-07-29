package cn.com.sparknet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sparknet.mapper.SmsFlashPromotionProductRelationMapper;
import cn.com.sparknet.model.SmsFlashPromotionProductRelationExample;
import cn.com.sparknet.service.SmsFlashPromotionProductRelationService;

@Service
public class SmsFlashPromotionProductRelationServiceImpl implements SmsFlashPromotionProductRelationService{
	
	@Autowired
	private SmsFlashPromotionProductRelationMapper flashPromotionProductRelationMapper;
	
	public long selectCountById(Long promotionId,Long promotionSessionId) {
		SmsFlashPromotionProductRelationExample example=new SmsFlashPromotionProductRelationExample();
		example.createCriteria().andFlashPromotionIdEqualTo(promotionId).andFlashPromotionSessionIdEqualTo(promotionSessionId);
		return flashPromotionProductRelationMapper.countByExample(example);
	}

}
