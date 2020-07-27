package cn.com.sparknet.service.impl;

import cn.com.sparknet.mapper.SmsFlashPromotionSessionMapper;
import cn.com.sparknet.model.SmsFlashPromotionSession;
import cn.com.sparknet.model.SmsFlashPromotionSessionExample;
import cn.com.sparknet.service.SmsFlashPromotionSessionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-27 21:41
 */
@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {

    @Autowired
    private SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper;

    public List<SmsFlashPromotionSession> selectSmsFlashPromotionSessionByPage(int pageNum,int pageSize ){
        PageHelper.startPage(pageNum,pageSize);
        SmsFlashPromotionSessionExample smsFlashPromotionSessionExample=new SmsFlashPromotionSessionExample();
        List<SmsFlashPromotionSession> smsFlashPromotionSessions = smsFlashPromotionSessionMapper.selectByExample(smsFlashPromotionSessionExample);
        return smsFlashPromotionSessions;

    }

    @Override
    public int insertSmsFlashPromotionSessionInfo(SmsFlashPromotionSession smsFlashPromotionSession) {
        int insert = smsFlashPromotionSessionMapper.insert(smsFlashPromotionSession);
        return  insert;

    }

    @Override
    public int updateSmsFlashPromotionSessionStatus(long id, int status) {
        SmsFlashPromotionSession smsFlashPromotionSession=new SmsFlashPromotionSession();
        smsFlashPromotionSession.setId(id);
        smsFlashPromotionSession.setStatus(status);
        int i = smsFlashPromotionSessionMapper.updateByPrimaryKeySelective(smsFlashPromotionSession);
        return  i;
    }

    @Override
    public int deleteSmsFlashPromotionSession(long id) {
        int i = smsFlashPromotionSessionMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public SmsFlashPromotionSession selectSmsFlashPromotionSessionById(long id) {
        SmsFlashPromotionSession smsFlashPromotion = smsFlashPromotionSessionMapper.selectByPrimaryKey(id);
        return smsFlashPromotion;

    }
}
