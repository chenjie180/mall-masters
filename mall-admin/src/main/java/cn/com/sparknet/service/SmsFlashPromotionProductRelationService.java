package cn.com.sparknet.service;

import java.util.List;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dto.SmsFlashPromotionProductRelationReturn;

public interface SmsFlashPromotionProductRelationService {

	public long selectCountById(Long promotionId,Long promotionSessionId);
	 /**
     * 根据活动和场次id获取商品关系数量
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @return
     */
    long getCount(Long flashPromotionId,Long flashPromotionSessionId);
    
	public  List<SmsFlashPromotionProductRelationReturn> selectSmsFlashPromotionProductRelationByPage(Integer pageNum, Integer pageSize, Long promotionId,
			Long promotionSessionId);
	
}
