package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.UmsRole;

/**
 * @author shkstart
 * @create 2020-08-03 22:03
 */
public interface UmsRoleService {
    public int insertUmsRoleInfo(UmsRole umsRole);

	public List<UmsRole> selectUmsRoleByPage(Integer pageNum, Integer pageSize, String name);
}
