package cn.com.sparknet.service.impl;

import cn.com.sparknet.mapper.UmsRoleMapper;
import cn.com.sparknet.model.UmsRole;
import cn.com.sparknet.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shkstart
 * @create 2020-08-03 22:04
 */
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Override
    public int insertUmsRoleInfo(UmsRole umsRole) {
        int i = umsRoleMapper.insertSelective(umsRole);
        return i;
    }


}
