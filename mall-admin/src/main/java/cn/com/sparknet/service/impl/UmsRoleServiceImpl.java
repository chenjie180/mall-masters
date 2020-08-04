package cn.com.sparknet.service.impl;

import cn.com.sparknet.mapper.UmsRoleMapper;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsAdminExample;
import cn.com.sparknet.model.UmsRole;
import cn.com.sparknet.model.UmsRoleExample;
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


}
