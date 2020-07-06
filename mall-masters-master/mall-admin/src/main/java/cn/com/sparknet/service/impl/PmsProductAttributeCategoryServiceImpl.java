package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dto.PmsProductAttributeCategoryParam;
import cn.com.sparknet.mapper.PmsProductAttributeCategoryMapper;
import cn.com.sparknet.model.PmsProductAttributeCategory;
import cn.com.sparknet.model.PmsProductAttributeCategoryExample;
import cn.com.sparknet.service.PmsProductAttributeCategoryService;
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
	@Autowired
	private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

	@Override
	public List<PmsProductAttributeCategory> selectPmsProductAttributeCategoryListByPage(int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PmsProductAttributeCategoryExample example=new PmsProductAttributeCategoryExample();
		List<PmsProductAttributeCategory> selectByExample = pmsProductAttributeCategoryMapper.selectByExample(example);
		return selectByExample;
	}
	
	
	@Override
	public int insertPmsProductAttributeCategory(PmsProductAttributeCategoryParam pmsProductAttributeCategoryParam) {
		PmsProductAttributeCategory attributeCategory=new PmsProductAttributeCategory();
		attributeCategory.setParamCount(0);
		attributeCategory.setAttributeCount(0);
		BeanUtils.copyProperties(pmsProductAttributeCategoryParam, attributeCategory);
		int insert = pmsProductAttributeCategoryMapper.insert(attributeCategory);
		return insert;
	}
	
	
	@Override
	public PmsProductAttributeCategory selectPmsProductAttributeCategoryById(long id) {
		PmsProductAttributeCategory selectByPrimaryKey = pmsProductAttributeCategoryMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}
	
	
	@Override
	public int updatePmsProductAttributeCategoryById(long id,PmsProductAttributeCategoryParam pmsProductAttributeCategoryParam) {
		PmsProductAttributeCategory attributeCategory=new PmsProductAttributeCategory();
		attributeCategory.setId(id);
		BeanUtils.copyProperties(pmsProductAttributeCategoryParam, attributeCategory);
		int updateByPrimaryKey = pmsProductAttributeCategoryMapper.updateByPrimaryKeySelective(attributeCategory);
		return updateByPrimaryKey;
	}
	
	
	@Override
	public int deletePmsProductAttributeCategoryById(long id) {
		int deleteByPrimaryKey = pmsProductAttributeCategoryMapper.deleteByPrimaryKey(id);
		return deleteByPrimaryKey;
	}

}
