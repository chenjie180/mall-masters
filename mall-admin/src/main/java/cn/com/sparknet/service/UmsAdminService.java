package cn.com.sparknet.service;

import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-03 21:29
 */
public interface UmsAdminService {
    public  int insertUmsAdminInfo(UmsAdmin umsAdmin);

    public List<UmsAdmin> selectUmsAdminByPage(Integer pageNum, Integer pageSize, String userName);

    public int deleteUmsAdminById(Long id);

    public  int updateUmsAdminStatusById(Long id, int status);

    public UmsAdmin selectUmsAdminById(Long id);

    public int updateUmsAdminById(UmsAdmin umsAdmin);

    public List<UmsRole> selectRoleByUmsAdminId(Long adminId);

    public int updateUmsAdminWithRoleId(Long adminId, List<Long> roleIds);

    public String login(String username, String password);
    public UserDetails loadUserByUsername(String username);
    public UmsAdmin getAdminByUsername(String username);
    public List<UmsResource> getResourceList(Long adminId);
}
