package cn.com.sparknet.service.impl;

import cn.com.sparknet.dto.SmsFlashPromotionSessionDetail;
import cn.com.sparknet.dto.SmsFlashPromotionSessionReturn;
import cn.com.sparknet.mapper.SmsFlashPromotionSessionMapper;
import cn.com.sparknet.model.SmsFlashPromotionSession;
import cn.com.sparknet.model.SmsFlashPromotionSessionExample;
import cn.com.sparknet.service.SmsFlashPromotionProductRelationService;
import cn.com.sparknet.service.SmsFlashPromotionSessionService;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-27 21:41
 */
@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {

    @Autowired
    private SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper;
    @Autowired
    private SmsFlashPromotionProductRelationService smsFlashPromotionProductRelationService;
    
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

	@Override
	public List<SmsFlashPromotionSessionReturn> selectSmsFlashPromotionSessionCount(Long flashPromotionId) {
		List<SmsFlashPromotionSessionReturn> list=new ArrayList<>();
		SmsFlashPromotionSessionExample example=new SmsFlashPromotionSessionExample();
		example.createCriteria().andStatusEqualTo(1);
		List<SmsFlashPromotionSession> selectByExample = smsFlashPromotionSessionMapper.selectByExample(example);
		System.out.println(selectByExample);
		for (SmsFlashPromotionSession smsFlashPromotionSession : selectByExample) {
			SmsFlashPromotionSessionReturn flashPromotionSessionReturn=new SmsFlashPromotionSessionReturn();
			BeanUtils.copyProperties(smsFlashPromotionSession, flashPromotionSessionReturn);
			long selectCountById = smsFlashPromotionProductRelationService.selectCountById(flashPromotionId, smsFlashPromotionSession.getId());
			flashPromotionSessionReturn.setProductCount(selectCountById);
			list.add(flashPromotionSessionReturn);
		}
		return list;
		
		
	}
	
	@Override
    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        List<SmsFlashPromotionSessionDetail> result = new ArrayList<>();
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        example.createCriteria().andStatusEqualTo(1);
        List<SmsFlashPromotionSession> list = smsFlashPromotionSessionMapper.selectByExample(example);
        System.out.println(list);
        for (SmsFlashPromotionSession promotionSession : list) {
            SmsFlashPromotionSessionDetail detail = new SmsFlashPromotionSessionDetail();
            BeanUtils.copyProperties(promotionSession, detail);
            long count = smsFlashPromotionProductRelationService.getCount(flashPromotionId, promotionSession.getId());
            detail.setProductCount(count);
            result.add(detail);
        }
        return result;
    }
	
}
