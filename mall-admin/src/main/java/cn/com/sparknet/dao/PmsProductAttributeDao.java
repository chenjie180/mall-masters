package cn.com.sparknet.dao;

import java.util.List;

import cn.com.sparknet.dto.PmsProductAttributeCategoryItem;
import cn.com.sparknet.dto.PmsProductCategoryChildren;
import cn.com.sparknet.model.PmsProductAttribute;

public interface PmsProductAttributeDao {
	
	public List<PmsProductAttributeCategoryItem> selectPmsProductAttributeWithChildren();

}
