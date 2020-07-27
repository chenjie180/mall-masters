package cn.com.sparknet.service;

import cn.com.sparknet.dto.SmsFlashPromotionParam;
import cn.com.sparknet.model.SmsFlashPromotion;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-27 20:14
 */
public interface SmsFlashPromotionService {
    public List<SmsFlashPromotion> selectSmsFlashPromotionByPage(int pageNum, int pageSize, String title );

  public   int insertSmsFlashPromotionInfo(SmsFlashPromotionParam smsFlashPromotionParam);

    public int updateSmsFlashPromotionStatus(long id, int status);

    public int deleteSmsFlashPromotion(long id);

    public SmsFlashPromotion selectSmsFlashPromotionById(long id);
}
