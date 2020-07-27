package cn.com.sparknet.service.impl;

import cn.com.sparknet.dto.SmsFlashPromotionParam;
import cn.com.sparknet.mapper.SmsFlashPromotionMapper;
import cn.com.sparknet.model.SmsFlashPromotion;
import cn.com.sparknet.model.SmsFlashPromotionExample;
import cn.com.sparknet.service.SmsFlashPromotionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-27 20:14
 */
@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService {
    @Autowired
    private SmsFlashPromotionMapper  smsFlashPromotionMapper;

    public List<SmsFlashPromotion> selectSmsFlashPromotionByPage(int pageNum,int pageSize,String title ){
        PageHelper.startPage(pageNum,pageSize);
        SmsFlashPromotionExample smsFlashPromotionExample=new SmsFlashPromotionExample();
        if(!StringUtils.isEmpty(title)){
            smsFlashPromotionExample.createCriteria().andTitleLike("%"+title+"%");
        }
        List<SmsFlashPromotion> smsFlashPromotions = smsFlashPromotionMapper.selectByExample(smsFlashPromotionExample);
        return  smsFlashPromotions;

    }

    @Override
    public int insertSmsFlashPromotionInfo(SmsFlashPromotionParam smsFlashPromotionParam) {
        SmsFlashPromotion smsFlashPromotion=new SmsFlashPromotion();
        BeanUtils.copyProperties(smsFlashPromotionParam,smsFlashPromotion);
        smsFlashPromotion.setCreateTime(new Date());
        int i = smsFlashPromotionMapper.insertSelective(smsFlashPromotion);
        return i;
    }

    @Override
    public int updateSmsFlashPromotionStatus(long id, int status) {
        SmsFlashPromotion smsFlashPromotion=new SmsFlashPromotion();
        smsFlashPromotion.setId(id);
        smsFlashPromotion.setStatus(status);
        int i = smsFlashPromotionMapper.updateByPrimaryKeySelective(smsFlashPromotion);
        return i;

    }

    @Override
    public int deleteSmsFlashPromotion(long id) {
        int i = smsFlashPromotionMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public SmsFlashPromotion selectSmsFlashPromotionById(long id) {
        SmsFlashPromotion smsFlashPromotion = smsFlashPromotionMapper.selectByPrimaryKey(id);
        return smsFlashPromotion;

    }
}
