package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.dto.SmsFlashPromotionProductRelationReturn;
import cn.com.sparknet.model.SmsFlashPromotionProductRelation;

public interface SmsFlashPromotionProductRelationDao {

	public	 List<SmsFlashPromotionProductRelationReturn> selectSmsFlashPromotionProductRelationByPage(@Param(value = "promotionId")Long promotionId,@Param(value = "promotionSessionId") Long promotionSessionId);

	public int insertSmsFlashPromotionProductRelationbatch(List<SmsFlashPromotionProductRelation> smsFlashPromotionProductRelationList);

}
