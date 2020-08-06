package cn.com.sparknet.dao;

import java.util.List;

import cn.com.sparknet.model.UmsResource;

public interface UmsRoleDao {

	public List<UmsResource> selectResourceById(Long roleId);

}
