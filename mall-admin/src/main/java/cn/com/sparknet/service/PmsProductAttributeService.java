package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.PmsProductAttributeParam;
import cn.com.sparknet.model.PmsProductAttribute;
import cn.com.sparknet.model.PmsProductAttributeCategory;

public interface PmsProductAttributeService {

	public int insertPmsProductAttribute(PmsProductAttributeParam pmsProductAttributeParam);

	public List<PmsProductAttribute> selectPmsProductAttributeListByPage(long productAttributeCategoryId, int type, int pageNum, int pageSize);

	public int deletePmsProductAttributeListByIds(List<Long> ids);

	public int deletePmsProductAttribute(long id);

	public PmsProductAttribute selectPmsProductAttributeById(Long id);

	public int updatePmsProductAttributeById(Long id,PmsProductAttributeParam pmsProductAttributeParam);

	public  List<PmsProductAttributeCategory>  selectPmsProductAttributeCategoryListAll();
	
}
