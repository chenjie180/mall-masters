package cn.com.sparknet.service;

import cn.com.sparknet.model.UmsResource;

import java.util.List;

public interface UmsResourceService {

	public int insertUmsResourceInfo(UmsResource umsResource);

	public List<UmsResource> selectUmsResourceByPage(Integer pageNum, Integer pageSize, String name, String url,
			Long categoryId);

	public int deleteUmsResourceById(Long id);

	public UmsResource selectUmsResourceById(Long id);

	public int updateUmsResourceById(UmsResource umsResource);

	public List<UmsResource> selectUmsResourceselectAll(String name, String url, Long categoryId);

	public List<UmsResource> listAll();
}
