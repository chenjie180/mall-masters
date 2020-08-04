package cn.com.sparknet.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sparknet.mapper.UmsResourceCategoryMapper;
import cn.com.sparknet.model.UmsResourceCategory;
import cn.com.sparknet.model.UmsResourceCategoryExample;
import cn.com.sparknet.service.UmsResourceCategoryService;
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
	
	@Autowired
	private UmsResourceCategoryMapper categoryMapper;

	@Override
	public int insertUmsResourceCategoryInfo(UmsResourceCategory umsResourceCategory) {
		umsResourceCategory.setCreateTime(new Date());
		int insertSelective = categoryMapper.insertSelective(umsResourceCategory);
		return insertSelective;
	}

	@Override
	public List<UmsResourceCategory> selectUUmsResourceCategoryList() {
		UmsResourceCategoryExample example=new UmsResourceCategoryExample();
		List<UmsResourceCategory> selectByExample = categoryMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public int deleteUmsResourceCategoryById(Long id) {
		int i = categoryMapper.deleteByPrimaryKey(id);
        return  i;
	}

	@Override
	public UmsResourceCategory selectUmsResourceCategoryById(Long id) {
		UmsResourceCategory selectByPrimaryKey = categoryMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public int updateUmsResourceCategoryById(UmsResourceCategory umsResourceCategory) {
		int updateByPrimaryKeySelective = categoryMapper.updateByPrimaryKeySelective(umsResourceCategory);
		return updateByPrimaryKeySelective;
	}
	
	

}
