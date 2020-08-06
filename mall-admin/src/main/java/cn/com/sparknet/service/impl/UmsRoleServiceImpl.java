package cn.com.sparknet.service.impl;

import cn.com.sparknet.dao.UmsMenuDao;
import cn.com.sparknet.dao.UmsRoleDao;
import cn.com.sparknet.dao.UmsRoleResourceRelationDao;
import cn.com.sparknet.mapper.UmsRoleMapper;
import cn.com.sparknet.mapper.UmsRoleMenuRelationMapper;
import cn.com.sparknet.mapper.UmsRoleResourceRelationMapper;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsAdminExample;
import cn.com.sparknet.model.UmsMenu;
import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.model.UmsRole;
import cn.com.sparknet.model.UmsRoleExample;
import cn.com.sparknet.model.UmsRoleMenuRelationExample;
import cn.com.sparknet.model.UmsRoleResourceRelationExample;
import cn.com.sparknet.service.UmsRoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

/**
 * @author shkstart
 * @create 2020-08-03 22:04
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Autowired
    private UmsRoleResourceRelationDao umsRoleResourceRelationDao;
    
    @Autowired
    private UmsRoleResourceRelationMapper umsRoleResourceRelationMapper;
    
    @Autowired
    private UmsRoleMenuRelationMapper umsRoleMenuRelationMapper;
    @Autowired
    private UmsRoleDao umsRoleDao;
    @Autowired
    private UmsMenuDao umsMenuDao;
    @Override
    public int insertUmsRoleInfo(UmsRole umsRole) {
        int i = umsRoleMapper.insertSelective(umsRole);
        return i;
    }
	@Override
	public List<UmsRole> selectUmsRoleByPage(Integer pageNum, Integer pageSize, String name) {
		  PageHelper.startPage(pageNum,pageSize);
		  UmsRoleExample umsAdminExample=new UmsRoleExample();
	        if(!StringUtils.isEmpty(name)){
	            umsAdminExample.createCriteria().andNameLike("%"+name+"%");
	        }
	        List<UmsRole> umsAdmins = umsRoleMapper.selectByExample(umsAdminExample);
	        return umsAdmins;
	}
	@Override
	public List<UmsResource> selectResourceById(Long roleId) {
		List<UmsResource> list=umsRoleDao.selectResourceById(roleId);
		return list;
	}
	@Override
	public int roleIdBingResourceById(Long roleId, List<Long> resources) {
		UmsRoleResourceRelationExample example=new UmsRoleResourceRelationExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		int deleteByExample = umsRoleResourceRelationMapper.deleteByExample(example);
		int i=umsRoleResourceRelationDao.roleIdBingResourceById(roleId,resources);
		return i;
	}
	@Override
	public List<UmsMenu> selectMenuById(Long roleId) {
		List<UmsMenu> list=umsMenuDao.selectMenuById(roleId);
		return list;
	}
	@Override
	public int roleIdBingMenuById(Long roleId, List<Long> menuIds) {
		UmsRoleMenuRelationExample example=new UmsRoleMenuRelationExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		int deleteByExample = umsRoleMenuRelationMapper.deleteByExample(example);
		int i=umsMenuDao.insertRoleIdBingMenuBatch(roleId,menuIds);
		return i;
	}


}
