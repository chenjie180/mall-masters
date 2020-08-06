package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.UmsMenu;
import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.model.UmsRole;

/**
 * @author shkstart
 * @create 2020-08-03 22:03
 */
public interface UmsRoleService {
    public int insertUmsRoleInfo(UmsRole umsRole);

	public List<UmsRole> selectUmsRoleByPage(Integer pageNum, Integer pageSize, String name);

	public List<UmsResource> selectResourceById(Long roleId);

	public int roleIdBingResourceById(Long roleId, List<Long> resources);

	public List<UmsMenu> selectMenuById(Long roleId);

	public int roleIdBingMenuById(Long roleId, List<Long> menuId);
}
