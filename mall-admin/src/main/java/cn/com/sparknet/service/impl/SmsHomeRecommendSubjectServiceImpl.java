package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.mapper.SmsHomeRecommendSubjectMapper;
import cn.com.sparknet.model.SmsHomeRecommendProduct;
import cn.com.sparknet.model.SmsHomeRecommendProductExample;
import cn.com.sparknet.model.SmsHomeRecommendSubject;
import cn.com.sparknet.model.SmsHomeRecommendSubjectExample;
import cn.com.sparknet.service.SmsHomeRecommendSubjectService;
@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {

	@Autowired
	private SmsHomeRecommendSubjectMapper smsHomeRecommendSubjectMapper;

	

	@Override
	public int insertSmsHomeRecommendSubjectInfo(SmsHomeRecommendSubject smsHomeRecommendSubject) {
		int insertSelective = smsHomeRecommendSubjectMapper.insertSelective(smsHomeRecommendSubject);
		return insertSelective;
	}



	@Override
	public List<SmsHomeRecommendSubject> selectSmsHomeRecommendSubjectByPage(Integer pageNum, Integer pageSize,
			String subjectName, Integer recommendStatus) {
		PageHelper.startPage(pageNum, pageSize);
		SmsHomeRecommendSubjectExample example=new SmsHomeRecommendSubjectExample();
		if(!StringUtils.isEmpty(subjectName)) {
			example.createCriteria().andSubjectNameLike("%"+subjectName+"%");
		}
		if(!StringUtils.isEmpty(recommendStatus)) {
			example.createCriteria().andRecommendStatusEqualTo(recommendStatus);
		}
		List<SmsHomeRecommendSubject> selectByExample = smsHomeRecommendSubjectMapper.selectByExample(example);
		return selectByExample;
	}



	@Override
	public int deleteSmsHomeRecommendSubjectByIds(List<Long> ids) {
		SmsHomeRecommendSubjectExample example=new SmsHomeRecommendSubjectExample();
		example.createCriteria().andIdIn(ids);
		int deleteByExample = smsHomeRecommendSubjectMapper.deleteByExample(example);
		return deleteByExample;
	}



	@Override
	public int updateSmsHomeRecommendSubjectStatusByIds(List<Long> ids, int recommendStatus) {
		SmsHomeRecommendSubject record=new SmsHomeRecommendSubject();
		record.setRecommendStatus(recommendStatus);
		SmsHomeRecommendSubjectExample example=new SmsHomeRecommendSubjectExample();
		example.createCriteria().andIdIn(ids);
		int updateByExampleSelective = smsHomeRecommendSubjectMapper.updateByExampleSelective(record, example);
		return updateByExampleSelective;
	}



	@Override
	public int updateSmsHomeRecommendSubjectSortById(Long id, int sort) {
		SmsHomeRecommendSubject record=new SmsHomeRecommendSubject();
		record.setId(id);
		record.setSort(sort);
		int updateByPrimaryKeySelective = smsHomeRecommendSubjectMapper.updateByPrimaryKeySelective(record);
		return updateByPrimaryKeySelective;
	}
	
}
