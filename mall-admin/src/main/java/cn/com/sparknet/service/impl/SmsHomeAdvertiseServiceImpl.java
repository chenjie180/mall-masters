package cn.com.sparknet.service.impl;

import cn.com.sparknet.mapper.SmsHomeAdvertiseMapper;
import cn.com.sparknet.model.SmsHomeAdvertise;
import cn.com.sparknet.model.SmsHomeAdvertiseExample;
import cn.com.sparknet.service.SmsHomeAdvertiseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-03 20:09
 */
@Service
public class SmsHomeAdvertiseServiceImpl implements SmsHomeAdvertiseService {
@Autowired
private SmsHomeAdvertiseMapper smsHomeAdvertiseMapper;

    @Override
    public int insertSmsHomeAdvertiseInfo(SmsHomeAdvertise smsHomeAdvertise) {
        smsHomeAdvertise.setClickCount(0);
        smsHomeAdvertise.setOrderCount(0);
        int i = smsHomeAdvertiseMapper.insertSelective(smsHomeAdvertise);
        return i;
    }

    @Override
    public List<SmsHomeAdvertise> selectSmsHomeAdvertiseByPage(Integer pageNum, Integer pageSize, String name, Integer type, String endTime) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeAdvertiseExample smsHomeAdvertiseExample=new SmsHomeAdvertiseExample();
        if(!StringUtils.isEmpty(name)){
            smsHomeAdvertiseExample.createCriteria().andNameLike("%"+name+"%");
        }
        if(!StringUtils.isEmpty(type)){
            smsHomeAdvertiseExample.createCriteria().andTypeEqualTo(type);
        }
        if(!StringUtils.isEmpty(endTime)){
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            try {
                start = sdf.parse(startStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date end = null;
            try {
                end = sdf.parse(endStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (start != null && end != null) {
                smsHomeAdvertiseExample.createCriteria().andEndTimeBetween(start, end);
            }
        }
        smsHomeAdvertiseExample.setOrderByClause("sort desc");

        List<SmsHomeAdvertise> smsFlashPromotionSessions = smsHomeAdvertiseMapper.selectByExample(smsHomeAdvertiseExample);
        return smsFlashPromotionSessions;
    }

    @Override
    public int deleteSmsHomeAdvertiseByIds(List<Long> ids) {
        SmsHomeAdvertiseExample smsHomeAdvertiseExample=new SmsHomeAdvertiseExample();
        smsHomeAdvertiseExample.createCriteria().andIdIn(ids);
        int i = smsHomeAdvertiseMapper.deleteByExample(smsHomeAdvertiseExample);
        return  i;
    }

    @Override
    public int updateSmsHomeAdvertiseStatusByIds(Long id, int status) {
        SmsHomeAdvertise smsHomeAdvertise=new SmsHomeAdvertise();
        smsHomeAdvertise.setId(id);
        smsHomeAdvertise.setStatus(status);
        int i = smsHomeAdvertiseMapper.updateByPrimaryKeySelective(smsHomeAdvertise);
        return i;

    }

    @Override
    public SmsHomeAdvertise selectSmsHomeAdvertiseById(Long id) {
        SmsHomeAdvertise smsHomeAdvertise = smsHomeAdvertiseMapper.selectByPrimaryKey(id);
    return smsHomeAdvertise;
    }

    @Override
    public int updateSmsHomeAdvertiseInfo(SmsHomeAdvertise smsHomeAdvertise) {
        int i = smsHomeAdvertiseMapper.updateByPrimaryKeySelective(smsHomeAdvertise);
    return i;
    }
}
