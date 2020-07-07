package cn.com.sparknet.dao;

import java.util.List;

import cn.com.sparknet.dto.PmsProductCategoryChildren;

public interface PmsProductCategoryDao {
	
	public List<PmsProductCategoryChildren> selectPmsProductCategoryAllChildren();

}
