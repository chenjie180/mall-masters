package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sparknet.mapper.CmsSubjectMapper;
import cn.com.sparknet.model.CmsSubject;
import cn.com.sparknet.model.CmsSubjectExample;
import cn.com.sparknet.service.CmsSubjectService;

@Service
public class CmsSubjectServiceImpl  implements CmsSubjectService{
	
	@Autowired
	private CmsSubjectMapper cmsSubjectMapper;
	
	public List<CmsSubject> selectCmsSubjectByCategoryId(long categorgId) {
		CmsSubjectExample example=new CmsSubjectExample();
		example.setOrderByClause(" create_time desc");
		example.createCriteria().andCategoryIdEqualTo(categorgId);
		List<CmsSubject> selectByExample = cmsSubjectMapper.selectByExample(example);
		return selectByExample;
	}

}
