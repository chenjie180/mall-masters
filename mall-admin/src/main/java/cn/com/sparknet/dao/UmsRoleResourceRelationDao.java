package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UmsRoleResourceRelationDao {

	public int roleIdBingResourceById(@Param("roleId")Long roleId, @Param("resources")List<Long> resources);

}
