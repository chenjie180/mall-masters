package cn.com.sparknet.dao;

import java.util.List;

import cn.com.sparknet.dto.UmsMenuNode;

public interface UmsMenuDao {

	public List<UmsMenuNode> selectBingTreeNode(Long roleId);

}
