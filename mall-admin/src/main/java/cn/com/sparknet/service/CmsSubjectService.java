package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.CmsSubject;

public interface CmsSubjectService {

	public List<CmsSubject> selectCmsSubjectByCategoryId(long categorgId); 
	
	
}
