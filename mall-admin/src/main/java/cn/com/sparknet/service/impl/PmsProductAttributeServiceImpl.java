package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dao.PmsProductAttributeDao;
import cn.com.sparknet.dto.PmsProductAttributeCategoryItem;
import cn.com.sparknet.dto.PmsProductAttributeParam;
import cn.com.sparknet.mapper.PmsProductAttributeCategoryMapper;
import cn.com.sparknet.mapper.PmsProductAttributeMapper;
import cn.com.sparknet.model.PmsProductAttribute;
import cn.com.sparknet.model.PmsProductAttributeCategory;
import cn.com.sparknet.model.PmsProductAttributeCategoryExample;
import cn.com.sparknet.model.PmsProductAttributeExample;
import cn.com.sparknet.service.PmsProductAttributeService;
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService{
	@Autowired
	private PmsProductAttributeMapper pmsProductAttributeMapper;
	@Autowired
	private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;
	@Autowired
	private PmsProductAttributeDao pmsProductAttributeDao;
	
	
	public int insertPmsProductAttribute(PmsProductAttributeParam pmsProductAttributeParam) {
		PmsProductAttribute pmsProductAttribute=new PmsProductAttribute();
		BeanUtils.copyProperties(pmsProductAttributeParam, pmsProductAttribute);
		int insertSelective = pmsProductAttributeMapper.insertSelective(pmsProductAttribute);
		return insertSelective;
		
	}

	@Override
	public List<PmsProductAttribute> selectPmsProductAttributeListByPage(long productAttributeCategoryId, int type,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PmsProductAttributeExample example=new PmsProductAttributeExample();
		example.createCriteria().andProductAttributeCategoryIdEqualTo(productAttributeCategoryId).andTypeEqualTo(type);
		List<PmsProductAttribute> selectByExample = pmsProductAttributeMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public int deletePmsProductAttributeListByIds(List<Long> ids) {
		PmsProductAttributeExample example=new PmsProductAttributeExample();
		example.createCriteria().andIdIn(ids);
		int deleteByExample = pmsProductAttributeMapper.deleteByExample(example);
		return deleteByExample;
	}
	@Override
	public int deletePmsProductAttribute(long id) {
		int deleteByPrimaryKey = pmsProductAttributeMapper.deleteByPrimaryKey(id);
		return deleteByPrimaryKey;
	}

	@Override
	public PmsProductAttribute selectPmsProductAttributeById(Long id) {
		PmsProductAttribute selectByPrimaryKey = pmsProductAttributeMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public int updatePmsProductAttributeById(Long id,PmsProductAttributeParam pmsProductAttributeParam) {
		PmsProductAttribute pmsProductAttribute=new PmsProductAttribute();
		BeanUtils.copyProperties(pmsProductAttributeParam, pmsProductAttribute);
		PmsProductAttributeExample example=new PmsProductAttributeExample();
		example.createCriteria().andIdEqualTo(id);
		int updateByExampleSelective = pmsProductAttributeMapper.updateByExampleSelective(pmsProductAttribute, example);
		return updateByExampleSelective;
	}

	@Override
	public List<PmsProductAttributeCategory> selectPmsProductAttributeCategoryListAll() {
		PmsProductAttributeCategoryExample example=new PmsProductAttributeCategoryExample();
		example.setOrderByClause(" id");
		List<PmsProductAttributeCategory> selectByExample = pmsProductAttributeCategoryMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public List<PmsProductAttributeCategoryItem> selectPmsProductAttributeWithChildren() {
		List<PmsProductAttributeCategoryItem> selectPmsProductAttributeWithChildren = pmsProductAttributeDao.selectPmsProductAttributeWithChildren();
		return selectPmsProductAttributeWithChildren;
	}
	
}
