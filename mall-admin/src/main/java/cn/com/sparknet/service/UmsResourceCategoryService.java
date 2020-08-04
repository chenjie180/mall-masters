package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.UmsResourceCategory;

public interface UmsResourceCategoryService {

	public int insertUmsResourceCategoryInfo(UmsResourceCategory umsResourceCategory);

	public List<UmsResourceCategory> selectUUmsResourceCategoryList();

	public int deleteUmsResourceCategoryById(Long id);

	public UmsResourceCategory selectUmsResourceCategoryById(Long id);

	public int updateUmsResourceCategoryById(UmsResourceCategory umsResourceCategory);

}
