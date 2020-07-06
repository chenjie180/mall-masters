package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.PmsProductAttributeCategoryParam;
import cn.com.sparknet.model.PmsProductAttributeCategory;

public interface PmsProductAttributeCategoryService {
	
	public List<PmsProductAttributeCategory> selectPmsProductAttributeCategoryListByPage(int pageNum,int pageSize);

	public int insertPmsProductAttributeCategory(PmsProductAttributeCategoryParam pmsProductAttributeCategoryParam);

	public PmsProductAttributeCategory selectPmsProductAttributeCategoryById(long id) ;

	public int updatePmsProductAttributeCategoryById(long id,PmsProductAttributeCategoryParam pmsProductAttributeCategoryParam);

	public int deletePmsProductAttributeCategoryById(long id);
}
