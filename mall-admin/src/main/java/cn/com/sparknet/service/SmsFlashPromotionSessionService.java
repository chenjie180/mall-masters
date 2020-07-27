package cn.com.sparknet.service;

import cn.com.sparknet.model.SmsFlashPromotionSession;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-27 21:40
 */
public interface SmsFlashPromotionSessionService {

    public List<SmsFlashPromotionSession> selectSmsFlashPromotionSessionByPage(int pageNum, int pageSize );

    public int insertSmsFlashPromotionSessionInfo(SmsFlashPromotionSession smsFlashPromotionSession);

    public int updateSmsFlashPromotionSessionStatus(long id, int status);
    public int deleteSmsFlashPromotionSession(long id);

    public SmsFlashPromotionSession selectSmsFlashPromotionSessionById(long id);
}
