package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.SmsHomeRecommendSubject;

public interface SmsHomeRecommendSubjectService {

	public int insertSmsHomeRecommendSubjectInfo(SmsHomeRecommendSubject smsHomeRecommendSubject);

	public List<SmsHomeRecommendSubject> selectSmsHomeRecommendSubjectByPage(Integer pageNum, Integer pageSize,
			String subjectName, Integer recommendStatus);

	public int deleteSmsHomeRecommendSubjectByIds(List<Long> ids);

	public int updateSmsHomeRecommendSubjectStatusByIds(List<Long> ids, int recommendStatus);

	public int updateSmsHomeRecommendSubjectSortById(Long id, int sort);

}
