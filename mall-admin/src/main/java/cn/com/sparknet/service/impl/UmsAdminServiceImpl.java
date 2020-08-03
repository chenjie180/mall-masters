package cn.com.sparknet.service.impl;

import cn.com.sparknet.mapper.UmsAdminMapper;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsAdminExample;
import cn.com.sparknet.service.UmsAdminService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-03 21:29
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper umsAdminMapper;


    @Override
    public int insertUmsAdminInfo(UmsAdmin umsAdmin) {
        umsAdmin.setCreateTime(new Date());
        int i = umsAdminMapper.insertSelective(umsAdmin);
   return i;
    }

    @Override
    public List<UmsAdmin> selectUmsAdminByPage(Integer pageNum, Integer pageSize, String userName) {
        PageHelper.startPage(pageNum,pageSize);
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        if(!StringUtils.isEmpty(userName)){
            umsAdminExample.createCriteria().andUsernameLike("%"+userName+"%");
        }
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(umsAdminExample);
        return umsAdmins;
    }

    @Override
    public int deleteUmsAdminById(Long id) {
        int i = umsAdminMapper.deleteByPrimaryKey(id);
        return  i;
        }

    @Override
    public int updateUmsAdminStatusById(Long id, int status) {
        UmsAdmin umsAdmin=new UmsAdmin();
        umsAdmin.setId(id);
        umsAdmin.setStatus(status);
        int i = umsAdminMapper.updateByPrimaryKeySelective(umsAdmin);
        return i;

    }

    @Override
    public UmsAdmin selectUmsAdminById(Long id) {
        UmsAdmin umsAdmin = umsAdminMapper.selectByPrimaryKey(id);
        return umsAdmin;

    }

    @Override
    public int updateUmsAdminById(UmsAdmin umsAdmin) {
        int i = umsAdminMapper.updateByPrimaryKeySelective(umsAdmin);
        return i;

    }
}
