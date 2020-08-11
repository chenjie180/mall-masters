package cn.com.sparknet.dao;

import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.model.UmsRole;

import java.util.List;

public interface UmsRoleDao {

	public List<UmsResource> selectResourceById(Long roleId);

    public List<UmsRole> selectRoleByUmsAdminId(Long adminId);
}
