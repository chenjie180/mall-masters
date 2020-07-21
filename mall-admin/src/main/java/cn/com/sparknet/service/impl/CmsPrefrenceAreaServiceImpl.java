package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sparknet.mapper.CmsPrefrenceAreaMapper;
import cn.com.sparknet.model.CmsPrefrenceArea;
import cn.com.sparknet.model.CmsPrefrenceAreaExample;
import cn.com.sparknet.service.CmsPrefrenceAreaService;

@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService{
	
	@Autowired
	private CmsPrefrenceAreaMapper CmsPrefrenceAreaMapper;
	
	public List<CmsPrefrenceArea> selectCmsPrefrenceAreaList() {
		CmsPrefrenceAreaExample example=new CmsPrefrenceAreaExample();
		example.setOrderByClause("sort");
		List<CmsPrefrenceArea> selectByExample = CmsPrefrenceAreaMapper.selectByExample(example);
		return selectByExample;
	}

}
