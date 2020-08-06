package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.dto.UmsMenuNode;
import cn.com.sparknet.model.UmsMenu;

public interface UmsMenuDao {

	public List<UmsMenuNode> selectBingTreeNode(Long roleId);

	public List<UmsMenu> selectMenuById(Long roleId);

	public int insertRoleIdBingMenuBatch(@Param("roleId")Long roleId, @Param("menuIds")List<Long> menuIds);

}
