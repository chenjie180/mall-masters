package cn.com.sparknet.service.impl;

import cn.com.sparknet.bo.AdminUserDetails;
import cn.com.sparknet.dao.UmsAdminDao;
import cn.com.sparknet.dao.UmsRoleDao;
import cn.com.sparknet.mall.security.util.JwtTokenUtil;
import cn.com.sparknet.mapper.UmsAdminLoginLogMapper;
import cn.com.sparknet.mapper.UmsAdminMapper;
import cn.com.sparknet.mapper.UmsAdminRoleRelationMapper;
import cn.com.sparknet.mapper.UmsRoleMapper;
import cn.com.sparknet.model.*;
import cn.com.sparknet.service.AdminCacheService;
import cn.com.sparknet.service.UmsAdminService;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private UmsRoleDao umsRoleDao;
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Autowired
    private AdminCacheService adminCacheService;
    @Autowired
    private UmsAdminDao umsAdminDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsAdminLoginLogMapper umsAdminLoginLogMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


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

    @Override
    public List<UmsRole> selectRoleByUmsAdminId(Long adminId) {
         List<UmsRole> list=umsRoleDao.selectRoleByUmsAdminId(adminId);
        return  list;
    }

    @Override
    public int updateUmsAdminWithRoleId(Long adminId, List<Long> roleIds) {
        UmsAdminRoleRelationExample umsAdminRoleRelationExample=new UmsAdminRoleRelationExample();
        umsAdminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        int i = umsAdminRoleRelationMapper.deleteByExample(umsAdminRoleRelationExample);
        roleIds.forEach(roleId->{
            UmsAdminRoleRelation umsAdminRoleRelation=new UmsAdminRoleRelation();
            umsAdminRoleRelation.setAdminId(adminId);
            umsAdminRoleRelation.setRoleId(roleId);
            umsAdminRoleRelationMapper.insertSelective(umsAdminRoleRelation);
            //查询角色对饮的用户数量，并录入
            UmsAdminRoleRelationExample adminRoleRelationExample=new UmsAdminRoleRelationExample();
            adminRoleRelationExample.createCriteria().andRoleIdEqualTo(roleId);
            long l = umsAdminRoleRelationMapper.countByExample(adminRoleRelationExample);
            UmsRoleExample roleExample=new UmsRoleExample();
            roleExample.createCriteria().andIdEqualTo(roleId);
            UmsRole umsRole=new UmsRole();
            umsRole.setAdminCount((int)l);
            int i1 = umsRoleMapper.updateByExampleSelective(umsRole, roleExample);

        });
         i=1;
        return i;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        UmsAdmin umsAdmin=adminCacheService.getAdmin(username);
        if(StringUtils.isEmpty(umsAdmin)){
            UmsAdminExample umsAdminExample=new UmsAdminExample();
            umsAdminExample.createCriteria().andUsernameEqualTo(username);
            List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(umsAdminExample);
            if(!StringUtils.isEmpty(umsAdmins)){
                umsAdmin=umsAdmins.get(0);
                adminCacheService.setAdmin(umsAdmin);
            }
        }
        //查询用户对应的资源
           List<UmsResource> umsResources= adminCacheService.getResource(umsAdmin.getId());
            if(StringUtils.isEmpty(umsResources)){
                umsResources= umsAdminDao.selectUserResource(umsAdmin.getId());
                if(!StringUtils.isEmpty(umsResources)){
                    adminCacheService.setResource(umsAdmin.getId(),umsResources);
                }
            }
        AdminUserDetails adminUserDetails=new AdminUserDetails(umsAdmin,umsResources);
        if(!passwordEncoder.matches(password,adminUserDetails.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(adminUserDetails, null, adminUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        token = jwtTokenUtil.generateToken(adminUserDetails);
        //登录的计入日志

        UmsAdminLoginLog umsAdminLoginLog=new UmsAdminLoginLog();
        umsAdminLoginLog.setAdminId(umsAdmin.getId());
        umsAdminLoginLog.setCreateTime(new Date());
        int i = umsAdminLoginLogMapper.insertSelective(umsAdminLoginLog);

        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsResource> resourceList =
                    getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = adminCacheService.getAdmin(username);
        if(admin!=null) return  admin;
        UmsAdminExample example = new UmsAdminExample();

        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = umsAdminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            adminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = adminCacheService.getResource(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            return  resourceList;
        }
        resourceList= umsAdminDao.selectUserResource(adminId);
        if(!StringUtils.isEmpty(resourceList)){
            adminCacheService.setResource(adminId,resourceList);
        }
        return resourceList;
    }


}
