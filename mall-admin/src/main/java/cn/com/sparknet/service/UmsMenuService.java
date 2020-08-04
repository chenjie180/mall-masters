package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.UmsMenuNode;
import cn.com.sparknet.model.UmsMenu;

public interface UmsMenuService {

	public int insertUmsMenuInfo(UmsMenu umsMenu);

	public List<UmsMenu> selectUmsMenuByPage(Integer pageNum, Integer pageSize,Long parentId);

	public int updateUmsMenuHiddenById(Long id, int hidden);

	public int deleteUmsMenuById(Long id);

	public UmsMenu selectUmsMenuById(Long id);

	public int updateUmsMenuById(UmsMenu umsMenu);

	public List<UmsMenuNode> selectTreeNodeUmsMenu();

}
